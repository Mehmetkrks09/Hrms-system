package kodlama.io.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="working_times")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class WorkingTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String time;

    @OneToMany(mappedBy = "workingTime")
    private List<JobAdvertisement> jobAdverts;

}