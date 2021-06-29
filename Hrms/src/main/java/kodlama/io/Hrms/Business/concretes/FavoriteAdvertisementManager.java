package kodlama.io.Hrms.Business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Business.abstracts.FavoriteAdvertisementService;
import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessDataResult;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.DataAccess.abstracts.FavoriteAdvertisementDao;
import kodlama.io.Hrms.DataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.Hrms.entities.concretes.FavoriteAdvertisement;
import kodlama.io.Hrms.entities.concretes.JobAdvertisement;
import kodlama.io.Hrms.entities.concretes.JobSeeker;
import kodlama.io.Hrms.entities.concretes.Dtos.FavoriteAdvertisementDto;

@Service
public class FavoriteAdvertisementManager implements FavoriteAdvertisementService{
	private FavoriteAdvertisementDao favoriteAdvertisementDao;
	
	

	@Autowired
	public FavoriteAdvertisementManager(FavoriteAdvertisementDao favoriteAdvertisementDao) {
		super();
		this.favoriteAdvertisementDao=favoriteAdvertisementDao;
	

		
	}

	@Override
	public DataResult<List<FavoriteAdvertisement>> getAll() {
		return new SuccessDataResult<List<FavoriteAdvertisement>>(this.favoriteAdvertisementDao.findAll(),"Listelendi");
	}

	@Override
	public DataResult<FavoriteAdvertisement> getById(int id) {
	return new SuccessDataResult<FavoriteAdvertisement>(this.favoriteAdvertisementDao.findById(id).get(),"id ye göre getirildi");
	}

	@Override
	public DataResult<List<FavoriteAdvertisement>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<FavoriteAdvertisement>>(this.favoriteAdvertisementDao.getAllByJobSeekerId(jobSeekerId),"Data listelendi");
		}

	@Override
	public DataResult<FavoriteAdvertisement> findByJobSeekerIdAndJobAdvertisementId(int jobSeekerId, int advertisementId) {
		return new SuccessDataResult<FavoriteAdvertisement>(this.favoriteAdvertisementDao.findByJobSeekerIdAndJobAdvertisementId(jobSeekerId, advertisementId),"data listelendi");
	}

	@Override
	public Result add(FavoriteAdvertisementDto favoriteAdvertisementDto) {
		
		
      JobAdvertisement jobAdvertisement = new JobAdvertisement();
     JobSeeker jobSeeker=new JobSeeker();
		FavoriteAdvertisement favoriteAdvertisement=new FavoriteAdvertisement();
		
		favoriteAdvertisement.setId(0);
		jobAdvertisement.setId(favoriteAdvertisementDto.getJobAdvertisementId());
		jobSeeker.setId(favoriteAdvertisementDto.getJobSeekerId());
        favoriteAdvertisement.setJobAdvertisement(jobAdvertisement);
        favoriteAdvertisement.setJobSeeker(jobSeeker);
        this.favoriteAdvertisementDao.save(favoriteAdvertisement);
        return new SuccessResult("Favorite Advertisement Has Been Added ");
	}

	@Override
	public Result delete(int id) {
		FavoriteAdvertisement favoriteAdvertisement=new FavoriteAdvertisement();
		favoriteAdvertisement.setId(id);
		this.favoriteAdvertisementDao.delete(favoriteAdvertisement);
		return new SuccessResult("Advertisement Has Been deleted");
	}

	



}
