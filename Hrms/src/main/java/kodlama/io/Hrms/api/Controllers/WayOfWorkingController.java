package kodlama.io.Hrms.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Hrms.Business.abstracts.WayOfWorkingService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.WayOfWorking;

@RequestMapping("/api/wayOfWorking")
@CrossOrigin
@RestController
public class WayOfWorkingController {
	
	private WayOfWorkingService wayofWorkingService;

	@Autowired
	public WayOfWorkingController(WayOfWorkingService wayofWorkingService) {
		super();
		this.wayofWorkingService = wayofWorkingService;
	}
	@PostMapping("/add")
	Result add( @RequestBody WayOfWorking wayOfWorking)
	{
		return this.wayofWorkingService.add(wayOfWorking);
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<WayOfWorking>> getAll()
	{
		return this.wayofWorkingService.getAll();
	}

}
