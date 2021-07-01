package kodlama.io.Hrms.entities.concretes.Dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementFilter {

	
	 private List<Integer> cityId;
	    private List<Integer> jobId;
	    private List<Integer> wayOfWorkingId;
	    private List<Integer> workingTimeId;
}
