package kadumi.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kadumi.hrms.business.abstracts.EmployerCheckService;
import kadumi.hrms.business.abstracts.EmployerService;
import kadumi.hrms.business.constants.Message;
import kadumi.hrms.core.utilities.results.DataResult;
import kadumi.hrms.core.utilities.results.ErrorResult;
import kadumi.hrms.core.utilities.results.Result;
import kadumi.hrms.core.utilities.results.SuccessDataResult;
import kadumi.hrms.core.utilities.results.SuccessResult;
import kadumi.hrms.dataAcces.abstracts.EmployerDao;
import kadumi.hrms.entities.concretes.Employer;


@Service 
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmployerCheckService employerCheckService;

	public EmployerManager(EmployerDao employerDao,
			EmployerCheckService employerCheckService) {
		super();
		this.employerDao = employerDao;
		this.employerCheckService = employerCheckService;
	}

	
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),Message.employersListed);
	}

	@Override
	public Result add(Employer employer) {
		if(!this.employerCheckService.checkIfMailExist(employer)) {
			return new ErrorResult(Message.employerMailExist);
		}
		else if(this.employerCheckService.checkMailActivation()) {
			return new ErrorResult(Message.employerNotMailActivation);
		}
		
		else if(this.employerCheckService.checkIfMailDomain(employer)) {
			return new ErrorResult(Message.mailDomainRequired);
		}
		else {
			this.employerDao.save(employer);
			return new SuccessResult(Message.employerAdded);
		}
	}
	


}
