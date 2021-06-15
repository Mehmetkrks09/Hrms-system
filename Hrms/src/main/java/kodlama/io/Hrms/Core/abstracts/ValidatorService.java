package kodlama.io.Hrms.Core.abstracts;

import kodlama.io.Hrms.Core.Results.Result;

public interface ValidatorService<T> {

	  Result sendVerificationMail( T user );
}
