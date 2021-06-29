package kodlama.io.Hrms.Business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Business.abstracts.JobSeekerService;
import kodlama.io.Hrms.Business.abstracts.UserActivationService;
import kodlama.io.Hrms.Business.abstracts.UserCheckService;
import kodlama.io.Hrms.Core.Results.DataResult;

import kodlama.io.Hrms.Core.Results.ErrorResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.Core.abstracts.ValidatorService;
import kodlama.io.Hrms.DataAccess.abstracts.JobSeekerDao;
import kodlama.io.Hrms.DataAccess.abstracts.UserDao;
import kodlama.io.Hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private UserCheckService userCheckService;
	private UserActivationService userActivationService;
	private ValidatorService validatorService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserDao userDao, UserCheckService userCheckService,
			ValidatorService validatorService, UserActivationService userActivationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userCheckService = userCheckService;
		this.userActivationService = userActivationService;
		this.validatorService = validatorService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll());
	}

	@Override
	public Result register(JobSeeker jobSeeker) {
		if (isFill(jobSeeker)) {
			return new ErrorResult("Bütün alanları doldurunuz");

		}  if (userCheckService.isValidEMail(jobSeeker.getEmail())) {
			return new ErrorResult(" mail de Karakter kurallarına uyunuz");
		}  if (jobSeekerDao.existsByemail(jobSeeker.getEmail())) {
			return new ErrorResult(jobSeeker.getEmail() + " Sistemde kayıtlı ");

		}  if (jobSeekerDao.existsBynationalityId(jobSeeker.getNationalityId())) {
			return new ErrorResult(jobSeeker.getNationalityId() + " Tc no Sistemde Kayıtlı");
		} else {
			validatorService.sendVerificationMail(jobSeeker.getEmail());
			userActivationService.userActivation(jobSeeker);
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult(" Başarılıyla kaydoldunuz");
		}

	}

	public boolean isFill(JobSeeker jobSeeker) {
		if (jobSeeker.getFirstName() != null && jobSeeker.getLastName() != null && jobSeeker.getPassword() != null
				&& jobSeeker.getBirthYear() != null && jobSeeker.getPassword() != null && jobSeeker.getEmail() != null
				&& jobSeeker.getPassword() != null) {
			return false;
		}
		return true;
	}

}
