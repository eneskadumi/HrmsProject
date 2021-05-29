package kadumi.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kadumi.hrms.business.abstracts.JobPostingService;
import kadumi.hrms.core.utilities.results.DataResult;
import kadumi.hrms.core.utilities.results.Result;
import kadumi.hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("/job_posting")
public class JobPostingsController {
	
	private JobPostingService jobPostingService;

	
	@Autowired
	public JobPostingsController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}

	
	@PostMapping("/add")
	Result add(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.add(jobPosting);
	}
	@PostMapping("/delete")
	Result delete(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.delete(jobPosting);
	}
	@GetMapping("/getByIsActive")
	DataResult<List<JobPosting>> findByIsActive(boolean isActive){
		return this.jobPostingService.findByIsActive(isActive);
		
	}
	@GetMapping("/getByIsActiveOrderByDeadline")
	DataResult<List<JobPosting>> findByIsActiveOrderByDeadline(boolean isActive){
		return this.jobPostingService.findByIsActiveOrderByDeadline(isActive);
		
		
	}
	@GetMapping("/gettByIsActiveTrueAndEmployer_CompanyName")
	DataResult<List<JobPosting>> findByIsActiveTrueAndEmployer_CompanyName(@RequestParam String companyName){
		return this.jobPostingService.findByIsActiveTrueAndEmployer_CompanyName(companyName);
	}
	
}
