package kodlama.io.Hrms.Business.abstracts.CV.concretes;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.Hrms.Business.abstracts.CV.abstracts.CvMainService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent.CvMainDao;
import kodlama.io.Hrms.Service.CloudinaryService;
import kodlama.io.Hrms.entities.concretes.JobSeeker;
import kodlama.io.Hrms.entities.concretes.CV.CvMain;

@Service
public class CvMainManager implements CvMainService {

	private CvMainDao cvMainDao;
	private CloudinaryService cloudinaryService;

	public CvMainManager(CvMainDao cvMainDao, CloudinaryService cloudinaryService) {
		super();
		this.cvMainDao = cvMainDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public Result add(CvMain cvMain) {
		this.cvMainDao.save(cvMain);
		return new SuccessResult("Cv Başarıyla Eklendi");
	}

	@Override
	public DataResult<CvMain> imageUpload(int cvMainId, MultipartFile multipartFile) throws IOException {

		CvMain cvMain = this.cvMainDao.findById(cvMainId).get();
		var result = this.cloudinaryService.imageUpload(multipartFile);
		cvMain.setPhoto(result.getData().get("url").toString());
		this.cvMainDao.save(cvMain);
		return new SuccessDataResult<>("Fotoğrafınız başarıyla kaydedildi.");
	}

	@Override
	public DataResult<CvMain> getByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<CvMain>(this.cvMainDao.getByJobSeekerId(jobSeekerId),"Data Listelendi");
	}

	

}
