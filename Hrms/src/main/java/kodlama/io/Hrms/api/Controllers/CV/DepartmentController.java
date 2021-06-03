package kodlama.io.Hrms.api.Controllers.CV;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Hrms.Business.abstracts.CV.abstracts.DepartmentService;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.entities.concretes.CV.Department;

@RestController
@RequestMapping("/api/cv/department")
public class DepartmentController {
	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	@PostMapping("/add")
	Result add(@RequestBody Department department)
	{
		this.departmentService.add(department);
		return new SuccessResult("Department Has been Added!");
	}

}