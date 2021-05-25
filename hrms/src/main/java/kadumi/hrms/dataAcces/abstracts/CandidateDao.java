package kadumi.hrms.dataAcces.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kadumi.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	
	List<Candidate> findByEmail(String email);
	List<Candidate> findByIdentityNo(String identityNumber);

}
