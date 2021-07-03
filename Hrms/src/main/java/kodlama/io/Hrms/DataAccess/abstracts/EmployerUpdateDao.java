package kodlama.io.Hrms.DataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Hrms.entities.concretes.EmployerUpdate;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate, Integer> {
	EmployerUpdate getByEmployerId(int employerUpdateId);
	boolean existsByemployerId(int id);
}