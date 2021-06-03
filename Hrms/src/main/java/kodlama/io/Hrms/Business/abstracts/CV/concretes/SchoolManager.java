package kodlama.io.Hrms.Business.abstracts.CV.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Business.abstracts.CV.abstracts.SchoolService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent.SchoolDao;
import kodlama.io.Hrms.entities.concretes.CV.School;

@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;

	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("School has been Added!");

	}

	@Override
	public DataResult<List<School>> getAllByOrderByFinishYearDesc() {
		return new SuccessDataResult<List<School>>(this.schoolDao.getAllByOrderByFinishYearDesc(), "Data Sıralandı");

	}


}
