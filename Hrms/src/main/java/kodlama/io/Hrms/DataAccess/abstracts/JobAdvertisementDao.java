package kodlama.io.Hrms.DataAccess.abstracts;




import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlama.io.Hrms.entities.concretes.JobAdvertisement;
import kodlama.io.Hrms.entities.concretes.Dtos.JobAdvertisementFilter;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
	
	  List<JobAdvertisement> getByEmployerId(int employerId);
  List<JobAdvertisement> getByEmployerIdAndIsActiveTrue(int employerId);
    List<JobAdvertisement> getByIsActiveTrue();
    List<JobAdvertisement> getByDeadlineLessThanEqual(String date);
    List<JobAdvertisement> getByCityId(int cityId);
    List<JobAdvertisement> getByWayOfWorkingId(int wayOfWorkingId);
   
	List<JobAdvertisement> getByIsActiveTrueAndWayOfWorkingIdAndWorkingTimeId(Integer wayOfWorkingId, Integer workingTimeId);
	List<JobAdvertisement> getByIsActiveTrueAndWayOfWorkingIdAndCityId(Integer wayOfWorkingId, Integer cityId);
	List<JobAdvertisement> getByIsActiveTrue(Pageable pageable);
	List<JobAdvertisement>  getByIsActiveTrueAndWayOfWorkingIdAndWorkingTimeId(Integer wayOfWorkingId, Integer workingTimeId, Pageable pageable);
	List<JobAdvertisement> getByIsActiveTrueAndWayOfWorkingId(int wayOfWorkingId);

}