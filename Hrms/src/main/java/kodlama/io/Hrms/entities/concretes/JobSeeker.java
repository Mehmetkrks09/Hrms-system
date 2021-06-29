package kodlama.io.Hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlama.io.Hrms.entities.concretes.CV.CvMain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seekers") 
//hiberrnate lazy eklenecek
@EqualsAndHashCode(callSuper = false)
public class JobSeeker extends User {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "nationality_id")
	private String nationalityId;

	@Column(name = "birth_year")
	private Date birthYear;

	 @JsonIgnore	
	 @OneToMany(mappedBy = "jobSeeker")
	 private List<FavoriteAdvertisement> favoriteAdvertisement;
}
