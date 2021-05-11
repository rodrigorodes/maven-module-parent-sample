package pt.axians.loan.dataprovider;

import java.util.Optional;

import pt.axians.loan.entity.Loan;
import pt.axians.loan.entity.Modality;
import pt.axians.loan.entity.vo.LoanRateType;

public class LoanGuaranteeDataProviderTest implements LoanTypeDataProvider {

	@Override
	public Optional<Loan> apply(Modality modality) {
	
		if(modality.hasGuarantee()) {
			return Optional.of(new Loan(LoanRateType.GUARANTEE.getName(), LoanRateType.GUARANTEE.getRate()));
		}
		
		return Optional.empty();
	}

}
