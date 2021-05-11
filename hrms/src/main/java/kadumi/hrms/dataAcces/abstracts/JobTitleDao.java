package kadumi.hrms.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kadumi.hrms.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer>{

}
