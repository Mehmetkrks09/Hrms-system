package kodlama.io.Hrms.Business.abstracts;

import java.util.List;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.Employer;
import kodlama.io.Hrms.entities.concretes.EmployerUpdate;
import kodlama.io.Hrms.entities.concretes.Dtos.EmployerDto;

public interface EmployerService {
	Result register(EmployerDto employerDto);
	DataResult<List<Employer>> getAll();
	 Result update(EmployerUpdate employerUpdate);
	    Result verifyUpdate(int employerId);
	    DataResult<List<EmployerUpdate>> getAllUpdate();
}
