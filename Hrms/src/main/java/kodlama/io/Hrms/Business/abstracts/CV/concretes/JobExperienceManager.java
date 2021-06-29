package kodlama.io.Hrms.Business.abstracts.CV.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Business.abstracts.CV.abstracts.JobExperienceService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent.CvMainDao;
import kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent.JobExperienceDao;
import kodlama.io.Hrms.entities.concretes.CV.JobExperience;
import kodlama.io.Hrms.entities.concretes.CV.School;
import kodlama.io.Hrms.entities.concretes.Dtos.JobExperienceDto;
@Service
public class JobExperienceManager implements JobExperienceService {

	private JobExperienceDao jobExperienceDao;
	private CvMainDao cvMainDao;
	public JobExperienceManager(JobExperienceDao jobExperienceDao, CvMainDao cvMainDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.cvMainDao=cvMainDao;
	}
	@Override
	public Result add(JobExperienceDto jobExperienceDto) {
JobExperience jobExperience= new JobExperience();
jobExperience.setId(jobExperienceDto.getId());
jobExperience.setDepartment(jobExperienceDto.getDepartment());
jobExperience.setFinishYear(jobExperienceDto.getFinishYear());
jobExperience.setStartYear(jobExperienceDto.getStartYear());
jobExperience.setAdditionDate(LocalDate.now());
jobExperience.setJobName(jobExperienceDto.getJobName());
jobExperience.setCvMain(cvMainDao.getById(jobExperienceDto.getCvMainId()));

			
this.jobExperienceDao.save(jobExperience);
return new SuccessResult("Job Experience Has Been Experience");

	}
	@Override
	public DataResult<List<JobExperience>> getAllByOrderByFinishYearDesc() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getAllByOrderByFinishYearDesc(),"Data Sıralandı");
		
	}
	@Override
	public DataResult<List<JobExperience>> getAll() {
	return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll());
	}


}
