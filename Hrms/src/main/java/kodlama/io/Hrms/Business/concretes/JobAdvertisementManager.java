package kodlama.io.Hrms.Business.concretes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Business.abstracts.JobAdvertisementService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.DataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.Hrms.entities.concretes.JobAdvertisement;


@Service
public class JobAdvertisementManager implements JobAdvertisementService {


	  private JobAdvertisementDao jobAdvertisementDao;
	    @Autowired
	    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
	        this.jobAdvertisementDao = jobAdvertisementDao;
	    }

	    @Override
	    public DataResult<List<JobAdvertisement>> getAll() {
	        return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(),"Listelendi");
	    }
	    @Override
	    public DataResult<List<JobAdvertisement>> getByEmployerIdAndIsActiveTrue(int employerId) {
	        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployerIdAndIsActiveTrue(employerId));
	    }

	    @Override
	    public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
	        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrue());

	    }

	    @Override
	    public DataResult<List<JobAdvertisement>> getByDeadlineLessThanEqual(String date) {
	        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByDeadlineLessThanEqual(date));

	    }
	    @Override
	    public Result add(JobAdvertisement jobAdvertisement) {
	       jobAdvertisementDao.save(jobAdvertisement);
	        return new SuccessResult("Eklendi");
	    }
}
