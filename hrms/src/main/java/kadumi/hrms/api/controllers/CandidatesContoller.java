package kadumi.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kadumi.hrms.business.abstracts.CandidateService;
import kadumi.hrms.core.utilities.results.DataResult;
import kadumi.hrms.core.utilities.results.Result;
import kadumi.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("api/candidates")
public class CandidatesContoller {
	
	private CandidateService candidateService;

	
	@Autowired
	public CandidatesContoller(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	
	
	@GetMapping("/getall")
	
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate ) {
		return this.candidateService.add(candidate);
	}

}
