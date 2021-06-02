package kodlama.io.Hrms.entities.concretes.Dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {

	private String companyName;
	private String jobName;
	private int numberOfOpenPositions;
	private LocalDate releaseDate;
	private LocalDate deadLine ;
	

}
