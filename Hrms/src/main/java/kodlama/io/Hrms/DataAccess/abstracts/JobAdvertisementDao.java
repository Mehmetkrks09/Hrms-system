package kodlama.io.Hrms.DataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
	
	  List<JobAdvertisement> getByEmployerId(int employerId);
  List<JobAdvertisement> getByEmployerIdAndIsActiveTrue(int employerId);
    List<JobAdvertisement> getByIsActiveTrue();
    List<JobAdvertisement> getByDeadlineLessThanEqual(String date);
    List<JobAdvertisement> getByCityId(int cityId);
    List<JobAdvertisement> getByWayOfWorkingId(int wayOfWorkingId);
   
    
}