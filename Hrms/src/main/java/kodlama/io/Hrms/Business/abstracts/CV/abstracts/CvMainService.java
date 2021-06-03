package kodlama.io.Hrms.Business.abstracts.CV.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.CV.CvMain;

public interface CvMainService {
	Result add(CvMain cvMain);
	DataResult<CvMain> imageUpload(int cvMain, MultipartFile multipartFile) throws IOException;
	
}
