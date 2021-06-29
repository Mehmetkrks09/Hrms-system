package kodlama.io.Hrms.Business.abstracts;

import java.util.List;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.FavoriteAdvertisement;
import kodlama.io.Hrms.entities.concretes.Dtos.FavoriteAdvertisementDto;

public interface FavoriteAdvertisementService {

    DataResult<List<FavoriteAdvertisement>> getAll();
    DataResult<FavoriteAdvertisement> getById(int id);
    DataResult<List<FavoriteAdvertisement>> getAllByJobSeekerId(int jobSeekerId);
    DataResult<FavoriteAdvertisement> findByJobSeekerIdAndJobAdvertisementId(int jobSeekerId,int advertisementId);
    Result add(FavoriteAdvertisementDto favoriteAdvertisementDto);
    Result delete(int id);

}