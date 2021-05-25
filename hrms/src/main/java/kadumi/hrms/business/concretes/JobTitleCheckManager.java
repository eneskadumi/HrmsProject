package kadumi.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kadumi.hrms.business.abstracts.JobTitleCheckService;
import kadumi.hrms.core.utilities.results.DataResult;
import kadumi.hrms.core.utilities.results.SuccessDataResult;
import kadumi.hrms.dataAcces.abstracts.JobTitleDao;
import kadumi.hrms.entities.concretes.JobTitle;


@Service 
public class JobTitleCheckManager implements JobTitleCheckService{

	private JobTitleDao jobTitleDao;
	
	
	@Autowired
	public JobTitleCheckManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public boolean checkIfTitleExist(JobTitle jobtitle) {
		if(this.findByTitle(jobtitle.getTitle()).getData().size()!=0) {
			return false;
		}else {
			return  true;
		}
		
			
	}

	@Override
	public DataResult<List<JobTitle>> findByTitle(String title) {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findByTitle(title));
	}

}
