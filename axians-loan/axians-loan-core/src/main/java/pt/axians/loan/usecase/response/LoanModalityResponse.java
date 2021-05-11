package pt.axians.loan.usecase.response;

import java.util.ArrayList;
import java.util.List;

public class LoanModalityResponse {

	private String customer;

	private List<LoanRateTypeResponse> loans = new ArrayList<>();

	public LoanModalityResponse(String customer, List<LoanRateTypeResponse> loans) {
		this.customer = customer;
		this.loans = loans;
	}

	public String getCustomer() {
		return customer;
	}

	public List<LoanRateTypeResponse> getLoans() {
		return loans;
	}

}
