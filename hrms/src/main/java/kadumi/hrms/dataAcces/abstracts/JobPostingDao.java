package kadumi.hrms.dataAcces.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kadumi.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	
	
	JobPosting findByPostingIdEquals(int titleId);
	

	List<JobPosting> findByIsActive(boolean isActive);
	List<JobPosting> findByIsActiveOrderByDeadline(boolean isActive);
	List<JobPosting> findByIsActiveTrueAndEmployer_CompanyName(String companyName);

}
