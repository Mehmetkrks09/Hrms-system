package kodlama.io.Hrms.Business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.hql.internal.ast.tree.IsNullLogicOperatorNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Business.abstracts.EmployerService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.ErrorResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.Core.abstracts.ValidatorService;
import kodlama.io.Hrms.DataAccess.abstracts.EmployerDao;
import kodlama.io.Hrms.DataAccess.abstracts.EmployerUpdateDao;
import kodlama.io.Hrms.entities.concretes.Employer;
import kodlama.io.Hrms.entities.concretes.EmployerUpdate;
import kodlama.io.Hrms.entities.concretes.Dtos.EmployerDto;

@Service
public class EmployerManager implements EmployerService {
private	EmployerDao employerDao;
private	ValidatorService validatorService;
private EmployerUpdateDao employerUpdateDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao, ValidatorService validatorService,EmployerUpdateDao employerUpdateDao) {
		super();
		this.employerDao = employerDao;
		this.validatorService = validatorService;
	this.employerUpdateDao = employerUpdateDao;

	}

	@Override
	public Result register(EmployerDto employerDto) {
		if (!isAllFieldsFilled(employerDto)) {
			return new ErrorResult("Bütün Alanları Doldurunuz");

		} 
		else if(employerDao.existsByemail(employerDto.getEmail())) {
			return new ErrorResult(employerDto.getEmail() + " Sistemde kayıtlı ");
		}
		else {
			validatorService.sendVerificationMail(employerDto.getEmail());
			
Employer employer=new Employer();
employer.setPhoneNumber(employerDto.getPhoneNumber());
employer.setId(1);
employer.setCompanyName(employerDto.getCompanyName());
employer.setEmail(employerDto.getEmail());
employer.setPassword(employerDto.getPassword());
employer.setWebAddress(employerDto.getWebAddress());
employer.setEmailVerify(true);

employer.setCreatedOn(LocalDate.now());
employer.setStatus(true);
employer.setSystemPersonnelVerify(true);
employerDao.save(employer);

			return new SuccessResult("İşveren Başarılıyla koydoldu");
		}
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "  Başarılıyla Listelendi ");
	}

	public boolean isAllFieldsFilled(EmployerDto employer) {

		if (employer.getCompanyName() == "" || employer.getEmail() == "" || employer.getPhoneNumber() == ""
				|| employer.getWebAddress() == "" || employer.getPassword() == "") {
			return false;
		}

		return true;
	}

	@Override
    public Result update(EmployerUpdate employerUpdate) {
        employerUpdate.setId(0);
        employerUpdate.setCreateDay(LocalDate.now());

      
        Employer employer=this.employerDao.getById(employerUpdate.getEmployerId());
        this.employerUpdateDao.save(employerUpdate);
        employer.setSystemPersonnelVerify(false);
        this.employerDao.save(employer);
        return new SuccessResult("Güncelleme isteği gönderildi personelin onayı ardından görünür olacaktır");
    }

    @Override
    public Result verifyUpdate(int employerId) {
    
    	if(!employerUpdateDao.existsByemployerId(employerId))
    	{
    		return new ErrorResult(employerId+" İd numaralı Employer bilgilerini Güncelleme istemedi");
    	}
    	else
    	{
    		 EmployerUpdate employerUpdate=this.employerUpdateDao.getByEmployerId(employerId);
    	        Employer employer=this.employerDao.getById(employerId);

    	        employerUpdate.setVerifyed(true);
    	        
    	        employerUpdate.setVerifyDate(LocalDate.now());
    	        this.employerUpdateDao.save(employerUpdate);

    	        employer.setEmail(employerUpdate.getEmail());
    	        employer.setCompanyName(employerUpdate.getCompanyName());
    	        employer.setPhoneNumber(employerUpdate.getPhoneNumber());
    	        employer.setWebAddress(employerUpdate.getWebSite());
    	        employer.setSystemPersonnelVerify(true);
    	        employer.setCreatedOn(LocalDate.now());
    	        this.employerDao.save(employer);
   
    	        this.employerUpdateDao.delete(employerUpdateDao.getByEmployerId(employerId));;
    	        return new SuccessResult("Bilgiler güncellendi");
    		
    	}
        
       
      
       
    }

	@Override
	public DataResult<List<EmployerUpdate>> getAllUpdate() {
		
return new SuccessDataResult<List<EmployerUpdate>>(this.employerUpdateDao.findAll());
}

   

}
