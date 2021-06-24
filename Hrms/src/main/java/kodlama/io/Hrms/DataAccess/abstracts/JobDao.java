package kodlama.io.Hrms.DataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Hrms.entities.concretes.Job;



public interface JobDao extends JpaRepository<Job,Integer> {
	boolean existsByjobName(String job);
	Job getById(int id);
}
