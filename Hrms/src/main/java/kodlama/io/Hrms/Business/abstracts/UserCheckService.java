package kodlama.io.Hrms.Business.abstracts;



public interface UserCheckService {
	
	
	boolean isValidEMail(String email);
	
	boolean isFirstNameOk(String firstName);
	boolean isLastNameOk(String lastName);
	boolean isPasswordOk(String password);
	
}	
