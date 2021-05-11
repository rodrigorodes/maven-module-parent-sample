package pt.axians.loan.dataprovider;

import java.util.Optional;

import pt.axians.loan.entity.Loan;
import pt.axians.loan.entity.Modality;

@FunctionalInterface
public interface LoanTypeDataProvider {
	
	Optional<Loan> apply(Modality modality);
}
