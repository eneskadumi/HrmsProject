package kadumi.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kadumi.hrms.business.abstracts.CandidateCheckService;
import kadumi.hrms.business.abstracts.CandidateService;
import kadumi.hrms.business.constants.Message;
import kadumi.hrms.core.adapters.CheckIfRealPersonService;
import kadumi.hrms.core.utilities.results.DataResult;
import kadumi.hrms.core.utilities.results.ErrorResult;
import kadumi.hrms.core.utilities.results.Result;
import kadumi.hrms.core.utilities.results.SuccessDataResult;
import kadumi.hrms.core.utilities.results.SuccessResult;
import kadumi.hrms.dataAcces.abstracts.CandidateDao;
import kadumi.hrms.entities.concretes.Candidate;


@Service 
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private CandidateCheckService candidateCheckService;
	private CheckIfRealPersonService checkIfRealPersonService;
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,
			CandidateCheckService candidateCheckService,
			CheckIfRealPersonService checkIfRealPersonService) {
		super();
		this.candidateDao = candidateDao;
		this.candidateCheckService = candidateCheckService;
		this.checkIfRealPersonService = checkIfRealPersonService;
	}

	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), Message.candidateListed);
	}

	@Override
	public Result add(Candidate candidate) {
		if(!this.checkIfRealPersonService.checkIfReal(candidate)) {
			return new ErrorResult(Message.notRealPerson);
		}
		else if(!this.candidateCheckService.checkIfIdentityExist(candidate)) {
			return new ErrorResult(Message.idNoExist);
		}
		else if(!this.candidateCheckService.checkIfMailExist(candidate)) {
			return new ErrorResult(Message.emailExist);
		}			
		else if(!this.candidateCheckService.checkIfMailActivation()) {
			return new ErrorResult(Message.notActivationMail);
		}
		else {
			this.candidateDao.save(candidate);
			return new SuccessResult(Message.candidateAdded);
		}
	}

}
