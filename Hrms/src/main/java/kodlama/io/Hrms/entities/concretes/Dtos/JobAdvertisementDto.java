package kodlama.io.Hrms.entities.concretes.Dtos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kodlama.io.Hrms.entities.concretes.City;
import kodlama.io.Hrms.entities.concretes.Employer;
import kodlama.io.Hrms.entities.concretes.Job;
import kodlama.io.Hrms.entities.concretes.WayOfWorking;
import kodlama.io.Hrms.entities.concretes.WorkingTime;
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
	
	private WorkingTime workingTimeId;

	private WayOfWorking wayOfWorkingId;

	private Job jobId;;

	private int employerId;

	private String description;

	private City cityCityid;

	private int salaryMin;

	private int salaryMax;
}
