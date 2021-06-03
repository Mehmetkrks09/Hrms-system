package kodlama.io.Hrms.api.Controllers.CV;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Hrms.Business.abstracts.CV.abstracts.JobExperienceService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.entities.concretes.CV.JobExperience;
import kodlama.io.Hrms.entities.concretes.CV.School;



@RestController
@RequestMapping("/api/cv/jobExperience")
public class JobExperienceController {
	private JobExperienceService jobExperienceService;

	public JobExperienceController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@PostMapping("/add")
	Result add(@RequestBody  JobExperience jobExperience)
	{
		this.jobExperienceService.add(jobExperience);
		return new SuccessResult("Job Experience Has Been Added!");
		
	}
	@GetMapping("/ByGrudutionYear")
	public DataResult<List<JobExperience>> ByGrudutionYear()
	{ return this.jobExperienceService. getAllByOrderByFinishYearDesc();
		
		}

}
