package kadumi.hrms.business.abstracts;

import java.util.List;

import kadumi.hrms.core.utilities.results.DataResult;
import kadumi.hrms.core.utilities.results.Result;
import kadumi.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	
	Result add(JobPosting jobPosting);
	Result delete(JobPosting jobPosting);
	
	DataResult<List<JobPosting>> findByIsActive(boolean isActive);
	
	DataResult<List<JobPosting>> findByIsActiveOrderByDeadline(boolean isActive);
	
	DataResult<List<JobPosting>> findByIsActiveTrueAndEmployer_CompanyName(String companyName);

}
