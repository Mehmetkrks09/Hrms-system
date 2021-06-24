package kodlama.io.Hrms.DataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Hrms.entities.concretes.City;
import kodlama.io.Hrms.entities.concretes.Employee;

public interface CityDao extends JpaRepository<City,Integer> {
City getById (int id);
}
