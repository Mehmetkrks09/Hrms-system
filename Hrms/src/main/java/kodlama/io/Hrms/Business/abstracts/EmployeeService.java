package kodlama.io.Hrms.Business.abstracts;

import java.util.List;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.Employee;
import kodlama.io.Hrms.entities.concretes.Dtos.EmployeeDto;

public interface EmployeeService {
	
	
	DataResult<List<Employee>> getAll();
	Result add(EmployeeDto employeeDto);

}
