package kodlama.io.Hrms.api.Controllers;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Hrms.Business.abstracts.JobSeekerService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.JobSeeker;
import kodlama.io.Hrms.entities.concretes.Dtos.JobSeekerDto;


@CrossOrigin
@RestController
@RequestMapping("/api/jobSeekers")
public class JobSeekersController {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll() {
		
		return this.jobSeekerService.getAll();
	}
	@GetMapping("/getById")
	public DataResult<JobSeeker> getById(int id) {
		
		return this.jobSeekerService.getById(id);
	}
	
	
	@PostMapping("/register")
	public Result add(@RequestBody JobSeekerDto jobSeekerDto) {
		
		return this.jobSeekerService.register(jobSeekerDto);
	}

}
