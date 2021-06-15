package kodlama.io.Hrms.DataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Hrms.entities.concretes.Employee;
import kodlama.io.Hrms.entities.concretes.Employer;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {

}
