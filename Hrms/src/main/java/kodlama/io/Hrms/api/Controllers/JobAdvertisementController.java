package kodlama.io.Hrms.api.Controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudinary.http44.api.Response;

import kodlama.io.Hrms.Business.abstracts.JobAdvertisementService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.entities.concretes.JobAdvertisement;
import kodlama.io.Hrms.entities.concretes.Dtos.JobAdvertisementDto;
import kodlama.io.Hrms.entities.concretes.Dtos.JobAdvertisementFilter;

@CrossOrigin
@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {
    JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll(){
        return this.jobAdvertisementService.getAll();
    }
    @GetMapping("getAllByEmployer")
    DataResult<List<JobAdvertisement>> getAllByEmployer(@RequestParam int employerId){
        return jobAdvertisementService.getByEmployerIdAndIsActiveTrue(employerId);
    }

    @GetMapping("getByIsActiveTrue")
    DataResult<List<JobAdvertisement>> getByIsActiveTrue(){
        return jobAdvertisementService.getByIsActiveTrue();
    }

    @GetMapping("getByApplicationDeadlineLessThanEqual")
    DataResult<List<JobAdvertisement>> getByDeadlineLessThanEqual(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String date){
        return jobAdvertisementService.getByDeadlineLessThanEqual(date);
    }
    @PostMapping("/add")
    public Result add( @RequestBody JobAdvertisementDto  jobAdvertisementDto){
       
    	return this.jobAdvertisementService.add(jobAdvertisementDto);
        
    }
    @GetMapping("getByCityId")
    DataResult<List<JobAdvertisement>> getByCityId(int id){
        return jobAdvertisementService.getByCityId(id);
    }

    @GetMapping("getByWayOfWorking")
    DataResult<List<JobAdvertisement>> getByWayOfWorking(int id){
        return jobAdvertisementService.getByWayOfWorkingId(id);
    }
    
    
    
    @GetMapping("/getAllByActivatedAndWayOfWorkingandWorkingtime")
	public ResponseEntity<?> getAllByActivatedAndWorkingPlaceTypeAndWorkingTime(
			@RequestParam(name = "wayOfWorkingId") int workingPlaceTypeId,
			@RequestParam(name = "workingTimeId") int workingTimeTypeId) {
		return ResponseEntity.ok(this.jobAdvertisementService
				.getByIsActiveTrueAndWayOfWorkingIdAndWorkingTimeId(workingPlaceTypeId, workingTimeTypeId));
	}

	@GetMapping("/getAllByActivatedWithPageable")
	public ResponseEntity<?> getAllByActivatedWithPageable(@RequestParam(name = "pageNumber") int pageNumber,
			@RequestParam(name = "pageSize") int pageSize) {
		Pageable allEntitiesWithPageable = PageRequest.of(pageNumber - 1, pageSize);
		return ResponseEntity.ok(this.jobAdvertisementService.getAllByIsActivatedWithPageable(allEntitiesWithPageable));
	}

	@GetMapping("/getAllbyActivatedAndwayOfWorkingAndWorkingtimeWithPageable")
	public ResponseEntity<?>getAllByActivatedAndWayofWorkingAndWorkingTimeWithPageable(
			@RequestParam(name  ="wayOfWorkingId") int wayOfWorking,
			@RequestParam(name = "workingTimeId") int workingTimeId,
			@RequestParam(name = "pageNumber") int pageNumber, @RequestParam(name = "pageSize") int pageSize)
			{
		Pageable allEntitiesWithPageable = PageRequest.of(pageNumber - 1, pageSize);
		return ResponseEntity.ok(jobAdvertisementService.getByIsActiveTrueAndWayOfWorkingIdAndWorkingTimeId(wayOfWorking, workingTimeId, allEntitiesWithPageable));
	}
	
	  @GetMapping("/getAllByActivatedAndWayOfWorkingandCityId")
		public ResponseEntity<?> getAllByActivatedAndWayOfWorkingAndCityId(
				@RequestParam(name = "wayOfWorkingId") int WayOfWorkingAndCityId,
				@RequestParam(name = "cityId") int cityId) {
			return ResponseEntity.ok(this.jobAdvertisementService
					.getByIsActiveTrueAndWayOfWorkingIdAndCityId(WayOfWorkingAndCityId, cityId));
		}
	  
	  @GetMapping("/getAllByActivatedAndWayOfWorking")
		public ResponseEntity<?> getAllByActivatedAndWayOfWorking(
				@RequestParam(name = "wayOfWorkingId") int WayOfWorkingId)
			{
			return ResponseEntity.ok(this.jobAdvertisementService
					.getByIsActiveTrueAndWayOfWorkingId(WayOfWorkingId));
		}


	

    

}