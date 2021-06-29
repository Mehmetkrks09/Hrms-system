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

public class SchoolDto {

	private int id;
	private int CvMainid;
	private String schoolName;
	private String department;
	private LocalDate StartYear;
	private LocalDate finishYear;
}




