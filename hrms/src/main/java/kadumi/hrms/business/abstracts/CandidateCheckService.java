package kadumi.hrms.business.abstracts;

import java.util.List;

import kadumi.hrms.core.utilities.results.DataResult;
import kadumi.hrms.entities.concretes.Candidate;

public interface CandidateCheckService {
	
	boolean checkIfMailExist(Candidate candidate);
	boolean checkIfMailActivation();
	boolean checkIfIdentityExist(Candidate candidate);
	
	DataResult<List<Candidate>> findByEmail(String email);
	DataResult<List<Candidate>> findtByIdentityNo(String identityNo);

}
