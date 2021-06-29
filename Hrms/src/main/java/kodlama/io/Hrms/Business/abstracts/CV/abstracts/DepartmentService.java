package kodlama.io.Hrms.Business.abstracts.CV.abstracts;

import java.util.List;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.CV.Department;
import kodlama.io.Hrms.entities.concretes.Dtos.DepartmentDto;

public interface DepartmentService {
	Result add(DepartmentDto departmentDto);
	DataResult<List<Department>> getAll();
}
