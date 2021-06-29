package kodlama.io.Hrms.Core.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.Core.abstracts.ValidatorService;

@Service
public class EmailValidatorManager implements ValidatorService {


	@Override
	public Result sendVerificationMail(String email) {
		return new SuccessResult(email +" Doğrulama Linki Gönderildi");
	}

	
		
	

}
