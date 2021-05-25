package kadumi.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kadumi.hrms.entities.concretes.Candidate;

@Service
public class MernisAdapter implements CheckIfRealPersonService{

	@Override
	public boolean checkIfReal(Candidate candidate) {
		if(candidate.getIdentityNo().length() !=11 ) {
			return false;
		}
		return true;
		
		
	}
	
	
	

}
