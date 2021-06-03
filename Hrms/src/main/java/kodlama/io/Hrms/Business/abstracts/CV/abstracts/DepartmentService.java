package kodlama.io.Hrms.Business.abstracts.CV.abstracts;

import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.CV.Department;

public interface DepartmentService {
	Result add(Department department);
}
