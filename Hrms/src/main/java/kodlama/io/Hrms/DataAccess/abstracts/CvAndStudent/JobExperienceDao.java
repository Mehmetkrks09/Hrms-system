package kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Hrms.entities.concretes.CV.CvMain;
import kodlama.io.Hrms.entities.concretes.CV.Department;
import kodlama.io.Hrms.entities.concretes.CV.JobExperience;
import kodlama.io.Hrms.entities.concretes.CV.School;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {

//	List<JobExperience> getByJobSeekerId(int id);
	List<JobExperience> getAllByOrderByFinishYearDesc();
	List<JobExperience> getById(int id);
}
