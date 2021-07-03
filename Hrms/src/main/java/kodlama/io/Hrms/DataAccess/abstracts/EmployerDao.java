package kodlama.io.Hrms.DataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Hrms.entities.concretes.Employer;
import kodlama.io.Hrms.entities.concretes.JobAdvertisement;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
	boolean existsByemail(String email);
	
	  Employer getById(int id);
	

}
