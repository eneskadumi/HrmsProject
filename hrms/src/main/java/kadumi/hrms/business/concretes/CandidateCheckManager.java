package kadumi.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kadumi.hrms.business.abstracts.CandidateCheckService;
import kadumi.hrms.business.constants.Message;
import kadumi.hrms.core.utilities.results.DataResult;
import kadumi.hrms.core.utilities.results.SuccessDataResult;
import kadumi.hrms.dataAcces.abstracts.CandidateDao;
import kadumi.hrms.entities.concretes.Candidate;

@Service 
public class CandidateCheckManager implements CandidateCheckService{

	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateCheckManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	
	
	@Override
	public boolean checkIfMailExist(Candidate candidate) {
		if(this.findByEmail(candidate.getEmail()).getData().size()!=0) {
			return false;
		}
		else {
			return true;
		}
	}

	
	
	@Override
	public boolean checkIfMailActivation() {
		return true;
	
	}

	@Override
	public boolean checkIfIdentityExist(Candidate candidate) {
		if(this.findtByIdentityNo(candidate.getIdentityNo()).getData().size()!=0) {
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public DataResult<List<Candidate>> findByEmail(String email) {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findByEmail(email), Message.candidateEmailListed);
		
	}

	@Override
	public DataResult<List<Candidate>> findtByIdentityNo(String identityNo) {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findByIdentityNo(identityNo), Message.candidateIdentityNoList);
	}

}
