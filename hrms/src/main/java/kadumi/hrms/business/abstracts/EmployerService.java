package kadumi.hrms.business.abstracts;

import java.util.List;

import kadumi.hrms.core.utilities.results.DataResult;
import kadumi.hrms.core.utilities.results.Result;
import kadumi.hrms.entities.concretes.Employer;

public interface EmployerService {
	

	DataResult<List<Employer>> getAll();
	Result add(Employer employer);

}
