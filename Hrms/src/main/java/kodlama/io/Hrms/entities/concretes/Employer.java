package kodlama.io.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employer")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdvertisement" })
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@AllArgsConstructor
@NoArgsConstructor

public class Employer extends User {

	@Column(name = "company_name")
	private String companyName;	

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "web_address")
	private String webAddress;

	@Column(name = "email_verify")
	private boolean emailVerify;

	@Column(name = "system_personnel_verify")
	private boolean systemPersonnelVerify;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "employer",cascade = {CascadeType.ALL})
	private List<JobAdvertisement> jobAdvertisement;

	

}
