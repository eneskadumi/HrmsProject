package kadumi.hrms.business.abstracts;

import java.util.List;

import kadumi.hrms.core.utilities.results.DataResult;
import kadumi.hrms.entities.concretes.JobTitle;

public interface JobTitleCheckService {

	boolean checkIfTitleExist(JobTitle jobtitle);
	DataResult<List<JobTitle>> findByTitle(String title);
	
	
}
