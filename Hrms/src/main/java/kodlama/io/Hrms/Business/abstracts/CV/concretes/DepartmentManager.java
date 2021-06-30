package kodlama.io.Hrms.Business.abstracts.CV.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Business.abstracts.CV.abstracts.DepartmentService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent.CvMainDao;
import kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent.DepartmentDao;
import kodlama.io.Hrms.entities.concretes.CV.Department;
import kodlama.io.Hrms.entities.concretes.Dtos.CvMainDto;
import kodlama.io.Hrms.entities.concretes.Dtos.DepartmentDto;
@Service
public class DepartmentManager implements DepartmentService {
private DepartmentDao departmentDao;
private CvMainDao cvMainDao;

@Autowired
	public DepartmentManager(DepartmentDao departmentDao,CvMainDao cvMainDao) {
	super();
	this.departmentDao = departmentDao;
	this.cvMainDao=cvMainDao;
}
	@Override
	public Result add(DepartmentDto departmentDto) {
		Department department = new Department();
		
		department.setId(departmentDto.getId());
		department.setDepartmentName(departmentDto.getDepatmentName());
		department.setCvMain(cvMainDao.getById(departmentDto.getCvMainId()));
		department.setAdditionDate(LocalDate.now());
		
		
		
		
		
		this.departmentDao.save(department);
		return new SuccessResult("Bölüm Başarıyla Eklendi");
	}
	@Override
	public DataResult<List<Department>> getAll() {
		
		return new SuccessDataResult<List<Department>>(this.departmentDao.findAll(),"Data Listelendi");
	}

}
