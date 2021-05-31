package kodlama.io.Hrms.Business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Business.abstracts.JobService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.ErrorResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.DataAccess.abstracts.JobDao;
import kodlama.io.Hrms.entities.concretes.Job;


@Service
public class JobManager implements JobService{
	private JobDao jobDao;

	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(jobDao.findAll());
	}

	@Override
	public Result add(Job job) {
		if(jobDao.existsByjobName(job.getJobName()))
		{
			return new ErrorResult(job.getJobName()+" Sistemde kayıtlı");
		}
		this.jobDao.save(job);
		return new SuccessResult("İş eklendi");
	}
 
	
	

}
