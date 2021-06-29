package kodlama.io.Hrms.Business.concretes;

import java.time.LocalDate;
import java.util.List;

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
import kodlama.io.Hrms.entities.concretes.Employer;
import kodlama.io.Hrms.entities.concretes.Dtos.EmployerDto;

@Service
public class EmployerManager implements EmployerService {
	EmployerDao employerDao;
	ValidatorService validatorService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, ValidatorService validatorService) {
		super();
		this.employerDao = employerDao;
		this.validatorService = validatorService;

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

}
