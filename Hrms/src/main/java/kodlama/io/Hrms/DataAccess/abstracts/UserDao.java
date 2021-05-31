package kodlama.io.Hrms.DataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

	
}
