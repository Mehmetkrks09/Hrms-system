package kodlama.io.Hrms.Business.abstracts.CV.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Business.abstracts.CV.abstracts.DepartmentService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent.DepartmentDao;
import kodlama.io.Hrms.entities.concretes.CV.Department;
@Service
public class DepartmentManager implements DepartmentService {
private DepartmentDao departmentDao;
	public DepartmentManager(DepartmentDao departmentDao) {
	super();
	this.departmentDao = departmentDao;
}
	@Override
	public Result add(Department department) {
		this.departmentDao.save(department);
		return new SuccessResult("Bölüm Başarıyla Eklendi");
	}
	@Override
	public DataResult<List<Department>> getAll() {
		
		return new SuccessDataResult<List<Department>>(this.departmentDao.findAll(),"Data Listelendi");
	}

}
