package kodlama.io.Hrms.entities.concretes.Dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private int id;

	private String email;
	
	
	private String password;
	
	
	private String repassword; 
	
	private String firstName;
	
	private String lastName;
}