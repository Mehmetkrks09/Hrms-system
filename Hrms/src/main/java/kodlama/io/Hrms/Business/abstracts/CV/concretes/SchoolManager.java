package kodlama.io.Hrms.Business.abstracts.CV.concretes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Business.abstracts.CV.abstracts.SchoolService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent.CvMainDao;
import kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent.SchoolDao;
import kodlama.io.Hrms.entities.concretes.CV.School;
import kodlama.io.Hrms.entities.concretes.Dtos.SchoolDto;

@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;
	private CvMainDao cvMainDao;

	public SchoolManager(SchoolDao schoolDao,CvMainDao cvMainDao) {
		super();
		this.schoolDao = schoolDao;
		this.cvMainDao=cvMainDao;
	}

	@Override
	public Result add(SchoolDto schoolDto) {
		School school= new School();
		school.setId(schoolDto.getId());
		school.setDepartment(schoolDto.getDepartment());
		school.setSchoolName(schoolDto.getSchoolName());
		school.setAdditionDate(LocalDate.now());
school.setFinishYear(schoolDto.getFinishYear());
school.setStartYear(schoolDto.getStartYear());
school.setCvMain(cvMainDao.getById(schoolDto.getCvMainid()));
		

		this.schoolDao.save(school);
		return new SuccessResult("School has been Added!");

	}

	@Override
	public DataResult<List<School>> getAllByOrderByFinishYearDesc() {
		return new SuccessDataResult<List<School>>(this.schoolDao.getAllByOrderByFinishYearDesc(), "Data Sıralandı");

	}

	@Override
	public DataResult<List<School>> getAll() {
	
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll());
	}

}
