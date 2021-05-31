package kodlama.io.Hrms.DataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
	boolean existsByemail(String email);
}
