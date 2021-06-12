package kodlama.io.Hrms.Business.abstracts;

import java.util.List;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.WorkingTime;

public interface WorkingTimeService {

	Result add(WorkingTime workingTime);
	DataResult<List<WorkingTime>> getAll();
}
