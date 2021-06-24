package kodlama.io.Hrms.entities.concretes.Dtos;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {

	private int numberOfOpenPositions;

	private LocalDate deadline;
	
	
	private int workingTimeId;

	private int wayOfWorkingId;

	private int jobId;

	private int employerId;

	private String description;

	private int cityId;

	private int salaryMin;

	private int salaryMax;
}
