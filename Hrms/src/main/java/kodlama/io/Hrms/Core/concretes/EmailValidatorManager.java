package kodlama.io.Hrms.Core.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.Core.abstracts.ValidatorService;

@Service
public class EmailValidatorManager<T> implements ValidatorService<T> {

	@Override
	public Result sendVerificationMail(T user) {
		System.out.println("Doğrulama Linki Gönderildi");
		return new SuccessResult("SuccessResult ile Doğrulama Linki Gönderildi mesajı");
		
	}

	
		
	

}
