package kodlama.io.Hrms.Business.abstracts;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.DataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.Hrms.entities.concretes.JobAdvertisement;
import kodlama.io.Hrms.entities.concretes.Dtos.JobAdvertisementDto;


public interface JobAdvertisementService {
	  DataResult<List<JobAdvertisement>> getAll();
  DataResult<List<JobAdvertisement>> getByEmployerIdAndIsActiveTrue(int employerId);
	    DataResult<List<JobAdvertisement>> getByIsActiveTrue();
	    DataResult<List<JobAdvertisement>> getByDeadlineLessThanEqual(String date);
	    Result add(JobAdvertisementDto  jobAdvertisementDto);
}
