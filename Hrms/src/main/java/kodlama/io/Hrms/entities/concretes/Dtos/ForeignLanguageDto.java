package kodlama.io.Hrms.entities.concretes.Dtos;

import java.util.Date;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForeignLanguageDto {
private int id;
private int CvId;
private String languageName;
private int languageLevel;

}




