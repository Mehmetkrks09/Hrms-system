package kodlama.io.Hrms.api.Controllers.CV;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.Hrms.Business.abstracts.CV.abstracts.SchoolService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.entities.concretes.Employer;
import kodlama.io.Hrms.entities.concretes.CV.School;
import kodlama.io.Hrms.entities.concretes.Dtos.SchoolDto;
@CrossOrigin
@RestController
@RequestMapping("/api/cv/school")
public class SchoolController {
	private SchoolService schoolService;

	@Autowired
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}

	@PostMapping("/add")
	Result add(@RequestBody SchoolDto schoolDto) {

		this.schoolService.add(schoolDto);
		return new SuccessResult("Başarıyla Eklendi");
	}

	@GetMapping("/ByGrudutionYear")
	public DataResult<List<School>> ByGrudutionYear() {
		return this.schoolService.getAllByOrderByFinishYearDesc();

	}

	@GetMapping("/getAll")
	public DataResult<List<School>> getAll() {
		return this.schoolService.getAll();
}
}