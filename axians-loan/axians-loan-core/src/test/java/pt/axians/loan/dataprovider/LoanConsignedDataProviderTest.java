package pt.axians.loan.dataprovider;

import java.util.Optional;

import pt.axians.loan.entity.Loan;
import pt.axians.loan.entity.Modality;
import pt.axians.loan.entity.vo.LoanRateType;

public class LoanConsignedDataProviderTest implements LoanTypeDataProvider {

	@Override
	public Optional<Loan> apply(Modality modality) {
		
		if (modality.hasConsigned()) {
			return Optional.of(new Loan(LoanRateType.CONSIGNED.getName(), LoanRateType.CONSIGNED.getRate()));
		}

		return Optional.empty();
	}

}
