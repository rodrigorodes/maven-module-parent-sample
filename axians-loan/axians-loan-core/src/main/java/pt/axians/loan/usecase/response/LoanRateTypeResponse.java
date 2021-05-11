package pt.axians.loan.usecase.response;

import pt.axians.loan.entity.Loan;

public class LoanRateTypeResponse {

	private String type;
	private int taxes;

	public LoanRateTypeResponse(Loan loan) {
		this.type = loan.getType();
		this.taxes = loan.getTaxes();
	}

	public String getType() {
		return type;
	}

	public int getTaxes() {
		return taxes;
	}

}
