package kodlama.io.Hrms.Business.abstracts;

import java.util.List;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.JobSeeker;
import kodlama.io.Hrms.entities.concretes.Dtos.JobSeekerDto;


public interface JobSeekerService {

	Result register(JobSeekerDto jobSeekerDto);
	DataResult<List<JobSeeker>> getAll();
	DataResult< JobSeeker> getById(int id);
}
