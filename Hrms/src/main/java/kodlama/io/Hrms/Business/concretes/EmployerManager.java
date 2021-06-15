package kodlama.io.Hrms.Business.concretes;

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

@Service
public class EmployerManager implements EmployerService {
	EmployerDao employerDao;
	ValidatorService<Employer> validatorService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, ValidatorService<Employer> validatorService) {
		super();
		this.employerDao = employerDao;
		this.validatorService = validatorService;

	}

	@Override
	public Result register(Employer employer) {
		if (!isAllFieldsFilled(employer)) {
			return new ErrorResult("Bütün Alanları Doldurunuz");

		} 
		else if(employerDao.existsByemail(employer.getEmail())) {
			return new ErrorResult(employer.getEmail() + " Sistemde kayıtlı ");
		}
		else {
			this.employerDao.save(employer);
validatorService.sendVerificationMail(employer);
			return new SuccessResult("İşveren Başarılıyla koydoldu");
		}
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "  Başarılıyla Listelendi ");
	}

	public boolean isAllFieldsFilled(Employer employer) {

		if (employer.getCompanyName() == "" || employer.getEmail() == "" || employer.getPhoneNumber() == ""
				|| employer.getWebAddress() == "" || employer.getPassword() == "") {
			return false;
		}

		return true;
	}

}
