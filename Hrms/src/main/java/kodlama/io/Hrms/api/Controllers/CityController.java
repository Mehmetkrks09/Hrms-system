package kodlama.io.Hrms.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Hrms.Business.abstracts.CityService;
import kodlama.io.Hrms.Business.abstracts.EmployeeService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.City;
import kodlama.io.Hrms.entities.concretes.Employee;

@RestController
@CrossOrigin
@RequestMapping("/api/city")
public class CityController {

	private CityService cityService;

	@Autowired
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}

	@PostMapping("/add")
	Result add(@RequestBody City city) {
		return this.cityService.add(city);
	}

	@GetMapping("getAll")
	public DataResult<List<City>> getAll() {
		return this.cityService.getAll();

	}

}
