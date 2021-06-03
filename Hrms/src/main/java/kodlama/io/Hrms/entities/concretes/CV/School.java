package kodlama.io.Hrms.entities.concretes.CV;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import kodlama.io.Hrms.entities.concretes.Job;
import kodlama.io.Hrms.entities.concretes.JobAdvertisement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schools")
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "cv_id")
	private int CvId;

	@Column(name = "school_name")
	private String schoolName;

	@Column(name = "department")
	private String department;

	@Column(name = "start_year")
	private Date StartYear;

	@Column(name = "finish_year")
	private Date finishYear;

	@Column(name = "addition_date")
	private Date additionDate;

}
