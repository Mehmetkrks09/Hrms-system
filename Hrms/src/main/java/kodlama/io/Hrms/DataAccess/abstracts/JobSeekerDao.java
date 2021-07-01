package kodlama.io.Hrms.DataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Hrms.entities.concretes.JobSeeker;


public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer>  {
	boolean existsBynationalityId(String identityNumber);
	boolean existsByemail(String email);
	JobSeeker getById(int id);
}	
