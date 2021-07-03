package kodlama.io.Hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employer_update")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "employer_id")
    private int employerId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_site")
    private String webSite;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "create_day")
    @JsonIgnore
    private LocalDate createDay;

    @Column(name = "verifyed")
    @JsonIgnore
    private boolean verifyed;

    

    @Column(name = "verify_date")
    @JsonIgnore
    private LocalDate verifyDate;
}