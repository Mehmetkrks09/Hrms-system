package kodlama.io.Hrms.entities.concretes.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteAdvertisementDto {

    private int id;
    private int jobAdvertisementId;
    private int jobSeekerId;
}