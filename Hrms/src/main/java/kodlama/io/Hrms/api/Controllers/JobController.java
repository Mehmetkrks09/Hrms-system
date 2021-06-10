package kodlama.io.Hrms.api.Controllers;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Hrms.Business.abstracts.JobService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.Job;

@CrossOrigin
@RestController
@RequestMapping("/api/jobs")

public class JobController {
	
	private JobService jobService;
	
	@Autowired
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	

	@GetMapping("/getall")
	public DataResult<List<Job>> getAll() {
		return this.jobService.getAll();

	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Job job) {
		
		return this.jobService.add(job);
	}

}
