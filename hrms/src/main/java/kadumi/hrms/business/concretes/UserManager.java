package kadumi.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kadumi.hrms.business.abstracts.UserService;
import kadumi.hrms.core.utilities.results.DataResult;
import kadumi.hrms.core.utilities.results.Result;
import kadumi.hrms.core.utilities.results.SuccessDataResult;
import kadumi.hrms.core.utilities.results.SuccessResult;
import kadumi.hrms.dataAcces.abstracts.UserDao;
import kadumi.hrms.entities.concretes.User;


@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	
	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll());
	}

	@Override
	public Result delete(User user) {
		
		this.userDao.delete(user);
		return new SuccessResult(" Silindi");
	}

}
