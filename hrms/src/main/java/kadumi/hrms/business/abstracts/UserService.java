package kadumi.hrms.business.abstracts;

import java.util.List;

import kadumi.hrms.core.utilities.results.DataResult;
import kadumi.hrms.core.utilities.results.Result;
import kadumi.hrms.entities.concretes.User;

public interface UserService {
	
	DataResult<List<User>> getAll();
	
	Result delete(User user);
	
	

}
