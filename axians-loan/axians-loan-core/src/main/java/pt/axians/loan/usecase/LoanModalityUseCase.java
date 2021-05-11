package pt.axians.loan.usecase;

import pt.axians.loan.usecase.request.LoanModalityRequest;
import pt.axians.loan.usecase.response.LoanModalityResponse;

@FunctionalInterface
public interface LoanModalityUseCase {

	LoanModalityResponse execute(LoanModalityRequest request);
}
