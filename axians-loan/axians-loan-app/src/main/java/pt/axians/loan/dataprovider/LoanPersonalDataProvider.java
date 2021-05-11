package pt.axians.loan.dataprovider;

import java.util.Optional;

import org.springframework.stereotype.Component;

import pt.axians.loan.entity.Loan;
import pt.axians.loan.entity.Modality;
import pt.axians.loan.entity.vo.LoanRateType;

@Component
class LoanPersonalDataProvider implements LoanTypeDataProvider {

	@Override
	public Optional<Loan> apply(Modality modality) {
		return Optional.of(new Loan(LoanRateType.PERSONAL.getName(), LoanRateType.PERSONAL.getRate()));
	}
}
