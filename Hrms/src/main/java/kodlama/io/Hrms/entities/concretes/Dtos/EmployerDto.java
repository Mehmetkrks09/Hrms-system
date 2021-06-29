package kodlama.io.Hrms.entities.concretes.Dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDto {

	private int id;
	private String phoneNumber;
	private String webAddress;

	private String email;
	private String password;
	private String companyName;
}










