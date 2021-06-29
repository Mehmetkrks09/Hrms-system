package kodlama.io.Hrms.Business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Business.abstracts.EmployeeService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.DataAccess.abstracts.EmployeeDao;
import kodlama.io.Hrms.entities.concretes.Employee;
import kodlama.io.Hrms.entities.concretes.Dtos.EmployeeDto;
@Service
public class EmployeeManager implements EmployeeService{
	
private EmployeeDao employeeDao;

@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
	super();
	this.employeeDao = employeeDao;
}

	

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"İşçi güncellendi ");
	}

	@Override
	public Result add(EmployeeDto employeeDto) {
Employee employee=new Employee();

employee.setId(employeeDto.getId());
employee.setEmail(employeeDto.getEmail());
employee.setFirstName(employeeDto.getFirstName());
employee.setLastName(employeeDto.getLastName());
employee.setPassword(employeeDto.getPassword());
employee.setStatus(true);
employee.setCreatedOn(LocalDate.now());
this.employeeDao.save(employee);
return new SuccessResult("Person Has Been Update");


	}

}
