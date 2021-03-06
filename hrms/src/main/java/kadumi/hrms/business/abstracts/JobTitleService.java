package kadumi.hrms.business.abstracts;

import java.util.List;

import kadumi.hrms.core.utilities.results.DataResult;
import kadumi.hrms.core.utilities.results.Result;
import kadumi.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	
	DataResult<List<JobTitle>> getAll();
	Result add(JobTitle jobTitle);

}
