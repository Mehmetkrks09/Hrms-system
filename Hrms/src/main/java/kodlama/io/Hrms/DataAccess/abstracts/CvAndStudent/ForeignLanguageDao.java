package kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Hrms.entities.concretes.CV.CvMain;
import kodlama.io.Hrms.entities.concretes.CV.Department;
import kodlama.io.Hrms.entities.concretes.CV.ForeignLanguage;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage,Integer>{
//	List<ForeignLanguage> getByJobSeekerId(int id);
	ForeignLanguage getById(int id);

}
