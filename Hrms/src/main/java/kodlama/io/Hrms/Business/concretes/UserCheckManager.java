package kodlama.io.Hrms.Business.concretes;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Business.abstracts.UserCheckService;



@Service
public class UserCheckManager implements UserCheckService {

	

	@Override
	public boolean isValidEMail(String email) {

		Pattern validMailPattern = Pattern.compile("^(.+)(.+)$@");
		Matcher validMailMatcher = validMailPattern.matcher(email);
		return validMailMatcher.matches();
	}

	

	@Override
	public boolean isFirstNameOk(String firstName) {
		Pattern validNamePattern = Pattern.compile("[A-Z][a-z]*");
		Matcher validNameMatcher = validNamePattern.matcher(firstName);
		return validNameMatcher.matches();
	}

	@Override
	public boolean isLastNameOk(String lastName) {
		Pattern validLastNamePattern = Pattern.compile("[A-Z]+([ '-][a-zA-Z]+)*");
		Matcher validLastNameMatcher = validLastNamePattern.matcher(lastName);
		return validLastNameMatcher.matches();
	}

	@Override
	public boolean isPasswordOk(String password) {
		Pattern validPasswordPattern = Pattern.compile("^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,16}$");
		Matcher validPasswordMatcher = validPasswordPattern.matcher(password);
		return validPasswordMatcher.matches();
	}

	
	
}
