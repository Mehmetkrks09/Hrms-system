package kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Hrms.entities.concretes.JobSeeker;
import kodlama.io.Hrms.entities.concretes.CV.CvMain;
import kodlama.io.Hrms.entities.concretes.CV.School;

public interface CvMainDao extends JpaRepository<CvMain,Integer> {

	List<CvMain> getByJobSeekerId(int jobSeekerId); 
	CvMain getById(int id);
}
