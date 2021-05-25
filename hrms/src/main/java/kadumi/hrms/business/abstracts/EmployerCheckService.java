package kadumi.hrms.business.abstracts;

import java.util.List;

import kadumi.hrms.core.utilities.results.DataResult;
import kadumi.hrms.entities.concretes.Employer;

public interface EmployerCheckService {
	
	boolean checkIfMailExist(Employer employer);
	boolean checkMailActivation();
	DataResult<List<Employer>> findByEmail(String email); 
	boolean checkIfMailDomain(Employer employer);
	
	

}
