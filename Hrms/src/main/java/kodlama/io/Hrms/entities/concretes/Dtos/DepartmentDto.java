package kodlama.io.Hrms.entities.concretes.Dtos;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
	
	
	private int id;
	private int CvMainId;
	private String depatmentName;
}

