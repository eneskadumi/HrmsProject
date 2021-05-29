package kadumi.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kadumi.hrms.business.abstracts.JobPostingService;
import kadumi.hrms.core.utilities.results.DataResult;
import kadumi.hrms.core.utilities.results.ErrorResult;
import kadumi.hrms.core.utilities.results.Result;
import kadumi.hrms.core.utilities.results.SuccessDataResult;
import kadumi.hrms.core.utilities.results.SuccessResult;
import kadumi.hrms.dataAcces.abstracts.JobPostingDao;
import kadumi.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public Result add(JobPosting jobPosting) {
		if(jobPostingDao.findByPostingIdEquals(jobPosting.getJobPostingId())!=null) {
			return new ErrorResult("iş ilanı mevcut");
		}else {
			this.jobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı eklendi");
		}
	}

	@Override
	public Result delete(JobPosting jobPosting) {
		this.jobPostingDao.delete(jobPosting);
		return new SuccessResult(" Silindi.");
	}

	@Override
	public DataResult<List<JobPosting>> findByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findByIsActive(isActive));
	}

	@Override
	public DataResult<List<JobPosting>> findByIsActiveOrderByDeadline(boolean isActive) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findByIsActiveOrderByDeadline(isActive));
	}

	@Override
	public DataResult<List<JobPosting>> findByIsActiveTrueAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findByIsActiveTrueAndEmployer_CompanyName(companyName));
	}

}
