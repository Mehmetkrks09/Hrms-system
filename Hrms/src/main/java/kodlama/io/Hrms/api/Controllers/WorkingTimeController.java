package kodlama.io.Hrms.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Hrms.Business.abstracts.WorkingTimeService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.WorkingTime;

@RequestMapping("/api/workingTime")
@CrossOrigin
@RestController
public class WorkingTimeController {
	private WorkingTimeService workingTimeService;

	@Autowired
	public WorkingTimeController(WorkingTimeService workingTimeService) {
		super();
		this.workingTimeService = workingTimeService;
	}
	@PostMapping("/add")
	Result add(@RequestBody WorkingTime workingTime) {
		
		return this.workingTimeService.add(workingTime);
	}

	@GetMapping("/getAll")
	public DataResult<List<WorkingTime>> getAll(){
		return this.workingTimeService.getAll();
	}
}
