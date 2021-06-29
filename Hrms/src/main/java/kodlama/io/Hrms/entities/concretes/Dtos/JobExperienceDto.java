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
public class JobExperienceDto {

	private int id;
	private int CvMainId;
	private String jobName;
	private String department;
	private LocalDate startYear;
	private LocalDate finishYear;
}



