package kadumi.hrms.core.adapters;

import kadumi.hrms.entities.concretes.Candidate;

public interface CheckIfRealPersonService {
	
	boolean checkIfReal(Candidate candidate);

}
