package kodlama.io.Hrms.api.Controllers.CV;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Hrms.Business.abstracts.CV.abstracts.DepartmentService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.entities.concretes.CV.Department;
import kodlama.io.Hrms.entities.concretes.Dtos.DepartmentDto;
@CrossOrigin
@RestController
@RequestMapping("/api/cv/department")
public class DepartmentController {
	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	@PostMapping("/add")
	Result add(@RequestBody DepartmentDto departmentDto)
	{
		this.departmentService.add(departmentDto);
		return new SuccessResult("Department Has been Added!");
	}
	@GetMapping("/getAll")
	public DataResult<List<Department>> getAll(){
		
		return this.departmentService.getAll();
	}
	

}
