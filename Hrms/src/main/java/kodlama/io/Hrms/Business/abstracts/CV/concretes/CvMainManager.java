package kodlama.io.Hrms.Business.abstracts.CV.concretes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.Hrms.Business.abstracts.CV.abstracts.CvMainService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent.CvMainDao;
import kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent.DepartmentDao;
import kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent.ForeignLanguageDao;
import kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent.JobExperienceDao;
import kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent.SchoolDao;
import kodlama.io.Hrms.Service.CloudinaryService;
import kodlama.io.Hrms.Service.ImageService;
import kodlama.io.Hrms.entities.concretes.JobSeeker;
import kodlama.io.Hrms.entities.concretes.CV.CvMain;
import kodlama.io.Hrms.entities.concretes.Dtos.CvMainDto;

@Service
public class CvMainManager implements CvMainService {

	private CvMainDao cvMainDao;
	private ImageService ımageService;
	



@Autowired
	public CvMainManager(CvMainDao cvMainDao, ImageService ımageService
			) {
		super();
		this.cvMainDao = cvMainDao;
		this.ımageService=ımageService;

	}

	

@Override
public DataResult<CvMain> imageUpload(int cvMainId, MultipartFile multipartFile) throws IOException {

	CvMain cvMain = this.cvMainDao.findById(cvMainId).get();
	var result = this.ımageService.uploadImageFile(multipartFile);
	cvMain.setPhoto(result.getData().get("url").toString());
	this.cvMainDao.save(cvMain);
	return new SuccessDataResult<>("Fotoğrafınız başarıyla kaydedildi.");
}

	@Override
	public DataResult<List<CvMain>> getByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<CvMain>>(this.cvMainDao.getByJobSeekerId(jobSeekerId),"Data Listelendi");
	}

	@Override
	public Result update(CvMainDto cvMainDto) {
		return new SuccessResult("Data Has Been Updated");
	}



	@Override
	public Result add(CvMainDto cvMainDto) {
	CvMain cvMain = new CvMain();
	cvMain.setId(cvMainDto.getId());
cvMain.setDescription(cvMainDto.getDescription());
cvMain.setGitHubLink(cvMainDto.getGitHubLink());
cvMain.setLinkedLink(cvMainDto.getLinkedLink());

cvMain.setPhoto(cvMainDto.getPhoto());
cvMain.setActive(true);
cvMain.setCreatedDate(LocalDate.now());
cvMainDao.save(cvMain);
return new SuccessResult("Data Eklendi");
		
	}



	

	

}
