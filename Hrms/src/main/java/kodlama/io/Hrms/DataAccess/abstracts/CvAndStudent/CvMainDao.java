package kodlama.io.Hrms.DataAccess.abstracts.CvAndStudent;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Hrms.entities.concretes.CV.CvMain;
import kodlama.io.Hrms.entities.concretes.CV.School;

public interface CvMainDao extends JpaRepository<CvMain,Integer> {

}
