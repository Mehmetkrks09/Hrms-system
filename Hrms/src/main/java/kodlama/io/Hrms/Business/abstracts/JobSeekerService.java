package kodlama.io.Hrms.Business.abstracts;

import java.util.List;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.JobSeeker;


public interface JobSeekerService {

	Result register(JobSeeker jobSeeker);
	DataResult<List<JobSeeker>> getAll();
}
