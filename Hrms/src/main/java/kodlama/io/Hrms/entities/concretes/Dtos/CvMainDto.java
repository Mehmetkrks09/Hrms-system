package kodlama.io.Hrms.entities.concretes.Dtos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlama.io.Hrms.entities.concretes.JobSeeker;
import kodlama.io.Hrms.entities.concretes.CV.Department;
import kodlama.io.Hrms.entities.concretes.CV.ForeignLanguage;
import kodlama.io.Hrms.entities.concretes.CV.JobExperience;
import kodlama.io.Hrms.entities.concretes.CV.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvMainDto {
	
	private int id;
	
	private String photo;
	
	private String GitHubLink;
	
	private String LinkedLink;
	
	private String description;
	
	private int foreignLanguageId;
	
	  private int jobExperienceId;
	  
	  private int schoolId;
	
	  private int departmentId;
	  
	  private int jobSeekerId;


	
	
	

}
