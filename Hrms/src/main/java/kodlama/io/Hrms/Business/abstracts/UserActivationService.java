package kodlama.io.Hrms.Business.abstracts;

import kodlama.io.Hrms.Core.Results.Result;
import kodlama.io.Hrms.entities.concretes.User;

public interface UserActivationService {
	Result userActivation(String email);
}
