package kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Hrms.Core.Results.DataResult;
import kodlama.io.Hrms.entities.concretes.CV.CvMain;
import kodlama.io.Hrms.entities.concretes.CV.Department;
import kodlama.io.Hrms.entities.concretes.CV.School;

public interface SchoolDao extends JpaRepository<School, Integer> {

	List<School> getAllByOrderByFinishYearDesc();
//	List<School> getByJobSeekerId(int id);
	List<School> getById(int id);
}
