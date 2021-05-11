package pt.axians.loan.usecase.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Named;

import pt.axians.loan.dataprovider.LoanTypeDataProvider;
import pt.axians.loan.entity.Modality;
import pt.axians.loan.usecase.LoanModalityUseCase;
import pt.axians.loan.usecase.request.LoanModalityRequest;
import pt.axians.loan.usecase.response.LoanModalityResponse;
import pt.axians.loan.usecase.response.LoanRateTypeResponse;

@Named
public class LoanModalityUseCaseImpl implements LoanModalityUseCase {

	private List<LoanTypeDataProvider> loanTypes;

	public LoanModalityUseCaseImpl(List<LoanTypeDataProvider> loanTypes) {
		this.loanTypes = loanTypes;
	}

	@Override
	public LoanModalityResponse execute(LoanModalityRequest request) {

		Modality modality = request.toModel();
		
		List<LoanRateTypeResponse> loanRateTypes = loanTypes
				.stream()
				.map(loanType -> loanType.apply(modality))
				.filter(Optional :: isPresent)
				.map(Optional :: get)
				.map(LoanRateTypeResponse :: new)
				.collect(Collectors.toList());
		
		return new LoanModalityResponse(modality.getName(), loanRateTypes);
	}

}
