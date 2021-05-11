package pt.axians.loan.entity;

public class Loan {

	private String type;
	private int taxes;

	public Loan(String type, int taxes) {
		this.type = type;
		this.taxes = taxes;
	}

	public String getType() {
		return type;
	}

	public int getTaxes() {
		return taxes;
	}

}
