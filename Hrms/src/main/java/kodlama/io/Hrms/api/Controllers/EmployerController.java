package kodlama.io.Hrms.api.Controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Hrms.Business.abstracts.EmployerService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.entities.concretes.Employer;
import kodlama.io.Hrms.entities.concretes.EmployerUpdate;
import kodlama.io.Hrms.entities.concretes.Dtos.EmployerDto;


@CrossOrigin
@RestController
@RequestMapping("/api/employers")
public class EmployerController {
private EmployerService employerService;

@Autowired
public EmployerController(EmployerService employerService) {
	super();
	this.employerService = employerService;
}


@GetMapping("/getall")
public DataResult<List<Employer>> getAll() {
	return this.employerService.getAll();
}


@PostMapping("/register")
Result add(@RequestBody EmployerDto employerDto) {
	
	return this.employerService.register(employerDto);
	
}
@PutMapping("/update")
public ResponseEntity<?> update(@RequestBody EmployerUpdate employerUpdate){
    Result result = this.employerService.update(employerUpdate);
    if(result.isSuccess()){
        return ResponseEntity.ok(result);
    }
    return ResponseEntity.badRequest().body(result);
}

@PutMapping("/verifyUpdate")
public ResponseEntity<?> verifyUpdate(@RequestParam int employerId){
    Result result = this.employerService.verifyUpdate(employerId);
    if(result.isSuccess()){
        return ResponseEntity.ok(result);
    }
    return ResponseEntity.badRequest().body(result);
}

@GetMapping("/getallUpdate")
public DataResult<List<EmployerUpdate>> getAllUpdate() {
	return this.employerService.getAllUpdate();
}

}
