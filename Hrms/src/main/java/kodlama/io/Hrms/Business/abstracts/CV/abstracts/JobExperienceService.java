package kodlama.io.Hrms.Business.abstracts.CV.abstracts;

import java.util.List;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.CV.JobExperience;
import kodlama.io.Hrms.entities.concretes.CV.School;
import kodlama.io.Hrms.entities.concretes.Dtos.JobExperienceDto;

public interface JobExperienceService {

	Result add(JobExperienceDto jobExperienceDto);
	DataResult<List<JobExperience>> getAllByOrderByFinishYearDesc();
	DataResult<List<JobExperience>> getAll();
}
