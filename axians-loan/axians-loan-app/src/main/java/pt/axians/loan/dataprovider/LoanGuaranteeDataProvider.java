package pt.axians.loan.dataprovider;

import java.util.Optional;

import org.springframework.stereotype.Component;

import pt.axians.loan.entity.Loan;
import pt.axians.loan.entity.Modality;
import pt.axians.loan.entity.vo.LoanRateType;

@Component
class LoanGuaranteeDataProvider implements LoanTypeDataProvider {
	
	@Override
	public Optional<Loan> apply(Modality modality) {
		return modality.hasGuarantee()
				? Optional.of(new Loan(LoanRateType.GUARANTEE.getName(), LoanRateType.GUARANTEE.getRate()))
				: Optional.empty();
	}

}
