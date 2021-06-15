package kodlama.io.Hrms.Business.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.Hrms.Business.abstracts.UserActivationService;
import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.Core.Results.SuccessResult;
import kodlama.io.Hrms.entities.concretes.User;

@Service
public class UserActivationManager implements UserActivationService{

	@Override
	public Result userActivation(User user) {
		return new SuccessResult(user.getEmail()+" aktif hale getirildi");
	}

}
