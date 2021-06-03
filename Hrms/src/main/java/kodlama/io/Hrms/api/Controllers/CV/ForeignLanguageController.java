package kodlama.io.Hrms.api.Controllers.CV;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Hrms.Business.abstracts.CV.abstracts.ForeignLanguageService;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.entities.concretes.CV.ForeignLanguage;

@RestController
@RequestMapping("/api/cv/foreignLanguage")
public class ForeignLanguageController {
private ForeignLanguageService foreignLanguageService;

public ForeignLanguageController(ForeignLanguageService foreignLanguageService) {
	super();
	this.foreignLanguageService = foreignLanguageService;
}
@PostMapping("/add")
Result add(@RequestBody ForeignLanguage foreignLanguage)
{
	this.foreignLanguageService.add(foreignLanguage);
	return new SuccessResult("Foreign Language Has Been Added!");
}

}
