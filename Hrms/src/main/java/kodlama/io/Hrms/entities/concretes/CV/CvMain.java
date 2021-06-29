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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlama.io.Hrms.entities.concretes.Job;
import kodlama.io.Hrms.entities.concretes.JobAdvertisement;
import kodlama.io.Hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cv")
public class CvMain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private int id;



	@Column(name = "photo")
	private String photo;

	@Column(name = "github_link")
	private String GitHubLink;

	@Column(name = "linkedin_link")
	private String LinkedLink;

	@Column(name = "description")
	private String description;

	@Column(name = "created_date")
	private LocalDate createdDate;

	@Column(name = "active")
	private boolean active;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "cvMain")
	private List<ForeignLanguage> foreignLanguage;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "cvMain")
    private List<JobExperience> jobExperience;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "cvMain")
	private List<School> school;
	
	
	@OneToOne()
	@JoinColumn(name = "jobSeeker_id")
	private JobSeeker jobSeeker;
	
	
	@JsonIgnore()
	@OneToMany(mappedBy = "cvMain")
	private List<Department> department;

}
