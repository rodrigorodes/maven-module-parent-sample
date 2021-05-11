package pt.axians.loan.dataprovider;

import java.util.Optional;

import org.springframework.stereotype.Component;

import pt.axians.loan.entity.Loan;
import pt.axians.loan.entity.Modality;
import pt.axians.loan.entity.vo.LoanRateType;

@Component
class LoanConsignedDataProvider implements LoanTypeDataProvider {

	@Override
	public Optional<Loan> apply(Modality modality) {
		return modality.hasConsigned()
				? Optional.of(new Loan(LoanRateType.CONSIGNED.getName(), LoanRateType.CONSIGNED.getRate()))
				: Optional.empty();
	}

}
