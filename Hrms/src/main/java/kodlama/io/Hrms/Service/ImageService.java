package kodlama.io.Hrms.Service;


import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.Hrms.Core.Results.DataResult;


public interface ImageService {

    DataResult<Map> uploadImageFile(MultipartFile imageFile);
}