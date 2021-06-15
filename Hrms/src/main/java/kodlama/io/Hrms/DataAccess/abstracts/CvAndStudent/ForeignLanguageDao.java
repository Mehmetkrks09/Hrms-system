package kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Hrms.entities.concretes.CV.Department;
import kodlama.io.Hrms.entities.concretes.CV.ForeignLanguage;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage,Integer>{

}
