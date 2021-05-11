package pt.axians.loan.entrypoiny;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.axians.loan.usecase.LoanModalityUseCase;
import pt.axians.loan.usecase.request.LoanModalityRequest;
import pt.axians.loan.usecase.response.LoanModalityResponse;

@RestController
@RequestMapping("api/v1/loan")
class LoanController {
	
	private LoanModalityUseCase loanModalityUseCase;
	
	public LoanController(LoanModalityUseCase loanModalityUseCase) {
		this.loanModalityUseCase = loanModalityUseCase;
	}
	
	@PostMapping(value = "/modalities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoanModalityResponse> loanModality(@Valid @RequestBody LoanModalityRequest request){
		LoanModalityResponse loanModalityResponse = loanModalityUseCase.execute(request);
		return ResponseEntity.ok(loanModalityResponse);
	}
 
}
