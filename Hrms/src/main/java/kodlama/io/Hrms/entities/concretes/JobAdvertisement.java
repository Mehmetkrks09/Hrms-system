package kodlama.io.Hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_advertisements")

@NoArgsConstructor
@AllArgsConstructor

public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "min_salary")
	private double minSalary;

	@Column(name = "max_salary")
	private double maxSalary;

	@Column(name = "description")
	private String description;

	@Column(name = "numberOfOpenPositions")
	private int numberOfOpenPositions;

	@Column(name = "creationDate")
	private String createdDate;

	@Column(name = "deadline")
	private String deadline;

	@Column(name = "is_deleted")
	private boolean isDeleted = false;

	@Column(name = "is_active")
	private boolean isActive = true;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name = "job_position_id")

	private Job job;

	@ManyToOne()
	@JoinColumn(name = "city_id")

	private City city;

	@ManyToOne()

	@JoinColumn(name = "way_of_working_id")
	private WayOfWorking wayOfWorking;

	@ManyToOne()

	@JoinColumn(name = "working_time_id")
	private WorkingTime workingTime;
}