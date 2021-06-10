package kodlama.io.Hrms.api.Controllers.CV;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.Hrms.Business.abstracts.CV.abstracts.CvMainService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.entities.concretes.JobSeeker;
import kodlama.io.Hrms.entities.concretes.CV.CvMain;
import kodlama.io.Hrms.entities.concretes.CV.School;
@CrossOrigin
@RestController
@RequestMapping("/api/cv")
public class CvMainController {
	private CvMainService cvMainService;

	@Autowired
	public CvMainController(CvMainService cvMainService) {
		super();
		this.cvMainService = cvMainService;
	}

	@PostMapping("/add")
	Result add(@RequestBody CvMain cvMain) {

		this.cvMainService.add(cvMain);
		return new SuccessResult("Başarıyla Eklendi");
	}

	@PostMapping("/imageUpload")
	public ResponseEntity<?> imageUpload(@RequestParam int curriculumVitaeId, @RequestParam MultipartFile multipartFile)
			throws IOException {

		return new ResponseEntity<>(this.cvMainService.imageUpload(curriculumVitaeId, multipartFile), HttpStatus.OK);
	}

	@GetMapping("/getByJobSeekerId")
	public DataResult<List<CvMain>> getByJobSeekerId( int jobSeekerId) {
		return this.cvMainService.getByJobSeekerId(jobSeekerId);

	}
}
