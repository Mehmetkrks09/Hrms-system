package kodlama.io.Hrms.Business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Business.abstracts.WayOfWorkingService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.DataAccess.abstracts.WayOfWorkingDao;
import kodlama.io.Hrms.entities.concretes.WayOfWorking;

@Service
public class WayOfWorkingManager implements WayOfWorkingService {
	private WayOfWorkingDao wayOfWorkingDao;

	public WayOfWorkingManager(WayOfWorkingDao wayOfWorkingDao) {
		super();
		this.wayOfWorkingDao = wayOfWorkingDao;
	}

	@Override
	public Result add(WayOfWorking wayOfWorking) {
		this.wayOfWorkingDao.save(wayOfWorking);
	return new SuccessResult("Way Of Working Has Been Added");
	}

	@Override
	public DataResult<List<WayOfWorking>> getAll() {
		return new SuccessDataResult<List<WayOfWorking>>(this.wayOfWorkingDao.findAll(),"Way Of Working Has Been Listed");
	}

}
