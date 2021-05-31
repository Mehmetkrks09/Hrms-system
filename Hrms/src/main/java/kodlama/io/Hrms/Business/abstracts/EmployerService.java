package kodlama.io.Hrms.Business.abstracts;

import java.util.List;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.Employer;

public interface EmployerService {
	Result register(Employer employer);
	DataResult<List<Employer>> getAll();

}
