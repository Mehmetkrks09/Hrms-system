package kodlama.io.Hrms.Business.abstracts.CV.abstracts;

import java.util.List;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.CV.JobExperience;
import kodlama.io.Hrms.entities.concretes.CV.School;

public interface JobExperienceService {

	Result add(JobExperience jobExperience);
	DataResult<List<JobExperience>> getAllByOrderByFinishYearDesc();
}
