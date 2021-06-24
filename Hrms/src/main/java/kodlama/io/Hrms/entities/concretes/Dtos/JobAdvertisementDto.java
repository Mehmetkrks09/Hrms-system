package kodlama.io.Hrms.entities.concretes.Dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {

	private int numberOfOpenPositions;

	private String deadline;
	
	private String createdDate;
	
	private int workingTimeId;

	private int wayOfWorkingId;

	private int jobId;

	private int employerId;

	private String description;

	private int cityId;

	private int salaryMin;

	private int salaryMax;
}
