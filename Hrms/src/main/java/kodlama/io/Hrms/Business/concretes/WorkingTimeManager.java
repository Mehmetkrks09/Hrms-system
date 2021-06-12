package kodlama.io.Hrms.Business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Business.abstracts.WorkingTimeService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.DataAccess.abstracts.WorkingTimeDao;
import kodlama.io.Hrms.entities.concretes.WorkingTime;

@Service
public class WorkingTimeManager implements WorkingTimeService {
	private WorkingTimeDao workingTimedao;

	@Autowired
	public WorkingTimeManager(WorkingTimeDao workingTimedao) {
		super();
		this.workingTimedao = workingTimedao;
	}

	@Override
	public Result add(WorkingTime workingTime) {
		this.workingTimedao.save(workingTime);
		return new SuccessResult("Working Times Has Been Added");
	}

	@Override
	public DataResult<List<WorkingTime>> getAll() {

		return new SuccessDataResult<List<WorkingTime>>(this.workingTimedao.findAll(),"Working Times Has Been Listed");
	}

}
