package kodlama.io.Hrms.Business.abstracts;

import java.util.List;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.WayOfWorking;

public interface WayOfWorkingService {

	Result add(WayOfWorking wayOfWorking);
	DataResult<List<WayOfWorking>> getAll();
	
}
