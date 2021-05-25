package kadumi.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kadumi.hrms.business.abstracts.EmployerCheckService;
import kadumi.hrms.business.constants.Message;
import kadumi.hrms.core.utilities.results.DataResult;
import kadumi.hrms.core.utilities.results.SuccessDataResult;
import kadumi.hrms.dataAcces.abstracts.EmployerDao;
import kadumi.hrms.entities.concretes.Employer;

@Service 
public class EmployerCheckManager implements EmployerCheckService{

	private EmployerDao employerDao;
	
	
	@Autowired
	public EmployerCheckManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	
	@Override
	public boolean checkIfMailExist(Employer employer) {
		if(this.findByEmail(employer.getEmail()).getData().size()!=0) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean checkMailActivation() {	
		return true;
	}

	@Override
	public DataResult<List<Employer>> findByEmail(String email) {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findByEmail(email),  Message.employerMailListed);
	}

	@Override
    public boolean checkIfMailDomain(Employer employer) {
         String regex = "^[A-Za-z0-9._%+-]+@" + employer.getWebAddress() +"$";
         Pattern pattern = Pattern.compile(regex);
         Matcher matcher = pattern.matcher(employer.getEmail());
         if(matcher.matches()) {
             return true;
         }else {
             return false;
         }
	}

}
