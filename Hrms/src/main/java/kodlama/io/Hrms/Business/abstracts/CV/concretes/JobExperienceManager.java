package kodlama.io.Hrms.Business.abstracts.CV.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Business.abstracts.CV.abstracts.JobExperienceService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent.JobExperienceDao;
import kodlama.io.Hrms.entities.concretes.CV.JobExperience;
import kodlama.io.Hrms.entities.concretes.CV.School;
@Service
public class JobExperienceManager implements JobExperienceService {

	private JobExperienceDao jobExperienceDao;
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}
	@Override
	public Result add(JobExperience jobExperience) {

this.jobExperienceDao.save(jobExperience);
return new SuccessResult("Job Experience Has Been Experience");

	}
	@Override
	public DataResult<List<JobExperience>> getAllByOrderByFinishYearDesc() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getAllByOrderByFinishYearDesc(),"Data Sıralandı");
		
	}


}
