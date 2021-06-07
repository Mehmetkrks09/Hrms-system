package kodlama.io.Hrms.Business.abstracts;

import java.util.List;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.Employee;

public interface EmployeeService {
	
	Result add(Employee employee);
	DataResult<List<Employee>> getAll();

}
