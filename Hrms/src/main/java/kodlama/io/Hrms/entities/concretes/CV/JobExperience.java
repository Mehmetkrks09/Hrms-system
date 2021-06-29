package kodlama.io.Hrms.entities.concretes.CV;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlama.io.Hrms.entities.concretes.Job;
import kodlama.io.Hrms.entities.concretes.JobAdvertisement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_Experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cvMain"})
public class JobExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

//	@Column(name = "cv_id")
//	private int CvId;

	@Column(name = "job_name")
	private String jobName;

	@Column(name = "department")
	private String department;

	@Column(name = "start_year")
	private LocalDate startYear;

	@Column(name = "finish_year")
	private LocalDate finishYear;

	@Column(name = "addition_date")
	private LocalDate additionDate;
	
	
	@ManyToOne()
	@JsonIgnore()
	@JoinColumn(name = "cv_id")
	private CvMain cvMain;
}
