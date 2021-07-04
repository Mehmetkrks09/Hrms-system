package kodlama.io.Hrms.DataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Hrms.entities.concretes.FavoriteAdvertisement;

public interface FavoriteAdvertisementDao extends JpaRepository<FavoriteAdvertisement,Integer> {

  List<FavoriteAdvertisement> getAllByJobSeekerId(int jobSeekerId);
   FavoriteAdvertisement findByJobSeekerIdAndJobAdvertisementId(int jobSeekerId,int advertisementId);
    FavoriteAdvertisement getById(int id);
//    boolean existByjobAdvertisementId(int id);
}
