package kodlama.io.Hrms.Business.abstracts.CV.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;

import kodlama.io.Hrms.entities.concretes.CV.CvMain;
import kodlama.io.Hrms.entities.concretes.Dtos.CvMainDto;

public interface CvMainService {
	Result add(CvMainDto cvMainDto);
	DataResult<CvMain> imageUpload(int cvMain, MultipartFile multipartFile) throws IOException;
	DataResult<List<CvMain>> getByJobSeekerId(int jobSeekerId); 
	Result update(CvMainDto cvMainDto);
}
