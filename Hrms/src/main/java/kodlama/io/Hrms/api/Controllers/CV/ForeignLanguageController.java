package kodlama.io.Hrms.api.Controllers.CV;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Hrms.Business.abstracts.CV.abstracts.ForeignLanguageService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessResult;

import kodlama.io.Hrms.entities.concretes.CV.ForeignLanguage;
import kodlama.io.Hrms.entities.concretes.Dtos.ForeignLanguageDto;
@CrossOrigin
@RestController
@RequestMapping("/api/cv/foreignLanguage")
public class ForeignLanguageController {
private ForeignLanguageService foreignLanguageService;

public ForeignLanguageController(ForeignLanguageService foreignLanguageService) {
	super();
	this.foreignLanguageService = foreignLanguageService;
}
@PostMapping("/add")
Result add(@RequestBody ForeignLanguageDto foreignLanguageDto)
{
	this.foreignLanguageService.add(foreignLanguageDto);
	return new SuccessResult("Foreign Language Has Been Added!");
}
@GetMapping("/getAll")
public DataResult<List<ForeignLanguage>> getAll(){
	
	return this.foreignLanguageService.getAll();
}


}
