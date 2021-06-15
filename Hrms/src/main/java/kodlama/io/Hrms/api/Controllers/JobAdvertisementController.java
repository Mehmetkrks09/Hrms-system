package kodlama.io.Hrms.api.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Hrms.Business.abstracts.JobAdvertisementService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.entities.concretes.JobAdvertisement;

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
//    @GetMapping("getAllByEmployer")
//    DataResult<List<JobAdvertisement>> getAllByEmployer(@RequestParam int employerId){
//        return jobAdvertisementService.getByEmployerIdAndIsActiveTrue(employerId);
//    }

    @GetMapping("getByIsActiveTrue")
    DataResult<List<JobAdvertisement>> getByIsActiveTrue(){
        return jobAdvertisementService.getByIsActiveTrue();
    }

    @GetMapping("getByApplicationDeadlineLessThanEqual")
    DataResult<List<JobAdvertisement>> getByDeadlineLessThanEqual(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String date){
        return jobAdvertisementService.getByDeadlineLessThanEqual(date);
    }
    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
       
        this.jobAdvertisementService.add(jobAdvertisement);
        return new  SuccessResult("iş İlanı Başarıyla Eklendi");
        
    }
}