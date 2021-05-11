package pt.axians.loan.entity.vo;

public enum LoanRateType {

	CONSIGNED(2, "Consigned"),
	PERSONAL(4, "Personal"),
	GUARANTEE(3, "Guarantee");
	
	private int rate;
	private String name;
	
	private LoanRateType(int rate, String name) {
		this.rate = rate;
		this.name = name;
	}
	
	public int getRate() {
		return rate;
	}
	
	public String getName() {
		return name;
	}
}
