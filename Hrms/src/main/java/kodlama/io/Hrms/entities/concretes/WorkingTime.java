package kodlama.io.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "working_times")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdvertisement" })
public class WorkingTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="time")
	private String time;

	@JsonIgnore()
	@OneToMany(mappedBy = "workingTime",cascade = {CascadeType.ALL})
	private List<JobAdvertisement> jobAdvertisement;

}