package kodlama.io.Hrms.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;

@Service
public class ImageCloudinaryManager implements  CloudinaryService{

	Cloudinary cloudinary;
	
	private Map<String, String> valuesMap = new HashMap<>();
	
	public ImageCloudinaryManager() {
		
		valuesMap.put("cloud_name", "mykodlama-io");
		valuesMap.put("api_key", "442578988248129");
		valuesMap.put("api_secret", "fTmUSo7DOVTE_b2Riw1QpqtjAWk");
		cloudinary = new Cloudinary(valuesMap);
	}
	
	@Override
	public DataResult<Map> imageUpload(MultipartFile multipartFile) throws IOException {
		
		File file = fileConvert(multipartFile);
		Map resultMap = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		file.delete();
		return new SuccessDataResult<>(resultMap);
	}
	
	private File fileConvert(MultipartFile multipartFile) throws IOException {
		
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		fileOutputStream.write(multipartFile.getBytes());
		fileOutputStream.close();
		return file;
	}

}