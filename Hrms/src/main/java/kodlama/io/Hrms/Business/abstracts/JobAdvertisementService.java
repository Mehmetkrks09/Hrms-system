package kodlama.io.Hrms.Business.abstracts;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.DataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.Hrms.entities.concretes.JobAdvertisement;
import kodlama.io.Hrms.entities.concretes.Dtos.JobAdvertisementDto;
import kodlama.io.Hrms.entities.concretes.Dtos.JobAdvertisementFilter;


public interface JobAdvertisementService {
	  DataResult<List<JobAdvertisement>> getAll();
  DataResult<List<JobAdvertisement>> getByEmployerIdAndIsActiveTrue(int employerId);
	    DataResult<List<JobAdvertisement>> getByIsActiveTrue();
	    DataResult<List<JobAdvertisement>> getByDeadlineLessThanEqual(String date);
	    Result add(JobAdvertisementDto  jobAdvertisementDto);
	   DataResult<List<JobAdvertisement>> getByCityId(int cityId);
	   DataResult<List<JobAdvertisement>> getByWayOfWorkingId(int id);

	   DataResult<List<JobAdvertisement>> getByIsActiveTrueAndWayOfWorkingIdAndWorkingTimeId(int wayOfWorkingId, int workingTimeId);
	   
	   DataResult<List<JobAdvertisement>> getByIsActiveTrueAndWayOfWorkingIdAndCityId(int wayOfWorkingId, int cityId);
	   
	   DataResult<List<JobAdvertisement>> getByIsActiveTrueAndWayOfWorkingId(int wayOfWorkingId);
		
		
		DataResult<List<JobAdvertisement>> getByIsActiveTrueAndWayOfWorkingIdAndWorkingTimeId(int wayOfWorkingId, int workingTimeId, Pageable pageable);
		DataResult<List<JobAdvertisement>> getAllByIsActivatedWithPageable(Pageable pageable);
	
}	