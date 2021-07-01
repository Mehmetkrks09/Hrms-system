package kodlama.io.Hrms.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Hrms.Business.abstracts.EmployeeService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.entities.concretes.Employee;
import kodlama.io.Hrms.entities.concretes.Dtos.EmployeeDto;
@CrossOrigin
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	@PostMapping("/register")
	Result  add(@RequestBody EmployeeDto employee) {
		return this.employeeService.add(employee);
	}
	@GetMapping("getAll")
	public DataResult<List<Employee>> getAll( )
	{
		return this.employeeService.getAll();
		
	}
	@PutMapping("/update")
	Result update(@RequestBody EmployeeDto employee) {
		return this.employeeService.add(employee);
	}
	
}
