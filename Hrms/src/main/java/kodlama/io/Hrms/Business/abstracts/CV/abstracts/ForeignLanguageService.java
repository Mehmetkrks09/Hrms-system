package kodlama.io.Hrms.Business.abstracts.CV.abstracts;

import java.util.List;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.CV.ForeignLanguage;
import kodlama.io.Hrms.entities.concretes.Dtos.ForeignLanguageDto;

public interface ForeignLanguageService {

	Result add(ForeignLanguageDto foreignLanguageDto);
	DataResult<List<ForeignLanguage>> getAll();
}
