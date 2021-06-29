package kodlama.io.Hrms.entities.concretes.Dtos;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerDto {

	private int id;
	private String firstName;
	private String nationalityId;
	private String password;
	private String email;
	private String lastName;
	private Date birthYear;
}




