package kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Hrms.entities.concretes.CV.CvMain;
import kodlama.io.Hrms.entities.concretes.CV.Department;


public interface DepartmentDao extends JpaRepository<Department,Integer>{
	List<Department> getById(int id);
//	List<Department> getByJobSeekerId(int id);
}
