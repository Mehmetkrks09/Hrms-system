package kodlama.io.Hrms.Business.concretes;

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
@Service
public class EmployeeManager implements EmployeeService{
	
private EmployeeDao employeeDao;

@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
	super();
	this.employeeDao = employeeDao;
}

	@Override
	public Result add(Employee employee) {
		
		this.employeeDao.save(employee);
		return new SuccessResult("Data Eklendi");
		
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"İşçi Eklendi ");
	}

}
