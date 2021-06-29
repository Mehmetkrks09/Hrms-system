package kodlama.io.Hrms.Business.abstracts.CV.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Business.abstracts.CV.abstracts.ForeignLanguageService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent.CvMainDao;
import kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent.ForeignLanguageDao;
import kodlama.io.Hrms.entities.concretes.CV.CvMain;
import kodlama.io.Hrms.entities.concretes.CV.ForeignLanguage;
import kodlama.io.Hrms.entities.concretes.Dtos.ForeignLanguageDto;
@Service
public class ForeignLanguageManager implements ForeignLanguageService {

	private ForeignLanguageDao foreignLanguageDao;
	private CvMainDao cvMainDao;
	
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao,CvMainDao cvMainDao) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
		this.cvMainDao= cvMainDao;
		
	}
	@Override
	public Result add(ForeignLanguageDto foreignLanguageDto) {
		 ForeignLanguage foreignLanguage=new ForeignLanguage();
		 foreignLanguage.setId(foreignLanguageDto.getId());
		 foreignLanguage.setCvMain(this.cvMainDao.getById(foreignLanguageDto.getCvId()));
		 foreignLanguage.setLanguageLevel(foreignLanguageDto.getLanguageLevel());
		 foreignLanguage.setLanguageName(foreignLanguageDto.getLanguageName());
		 foreignLanguage.setAdditionDate(LocalDate.now());
	
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("Başarıyla Eklendi");
	}
	@Override
	public DataResult<List<ForeignLanguage>> getAll() {
		
return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAll());
	}

}
