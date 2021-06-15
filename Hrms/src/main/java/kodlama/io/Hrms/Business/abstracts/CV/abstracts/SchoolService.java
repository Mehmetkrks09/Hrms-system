package kodlama.io.Hrms.Business.abstracts.CV.abstracts;

import java.util.Date;
import java.util.List;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.CV.School;

public interface SchoolService {
	Result add(School school);

	DataResult<List<School>> getAllByOrderByFinishYearDesc();
}
