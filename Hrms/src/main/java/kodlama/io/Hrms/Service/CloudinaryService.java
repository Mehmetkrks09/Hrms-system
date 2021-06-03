package kodlama.io.Hrms.Service;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.Hrms.Core.Results.DataResult;

public interface CloudinaryService {
	DataResult<Map> imageUpload(MultipartFile multipartFile) throws IOException;
}