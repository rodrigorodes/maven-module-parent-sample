package pt.axians.loan.entity;

import java.math.BigDecimal;
import java.util.stream.Stream;

import pt.axians.loan.entity.vo.GuaranteeRule;

public class Modality {

	private String name;

	private String cpf;

	private int age;

	private String location;

	private BigDecimal income;

	public Modality(String name, String cpf, int age, String location, BigDecimal income) {
		this.name = name;
		this.cpf = cpf;
		this.age = age;
		this.location = location;
		this.income = income;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public int getAge() {
		return age;
	}

	public String getLocation() {
		return location;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public boolean isSalaryBiggerThan(int salary) {
		return income.compareTo(new BigDecimal(salary)) > 0;
	}

	public boolean isSalaryLessThan(int salary) {
		return income.compareTo(new BigDecimal(salary)) < 0;
	}

	public boolean isAgeLessThat(int age) {
		return this.age < age;
	}

	public boolean isLocationSP() {
		return this.location.equalsIgnoreCase("SP");
	}

	public boolean hasGuarantee() {
		return Stream.of(GuaranteeRule.values())
				.map(guarantee -> guarantee.getModalityFunction())
				.anyMatch(guaranteeFunction -> guaranteeFunction.apply(this));
	}
	
	public Boolean guaranteeRuleOne() {
		return isSalaryLessThan(3001) && isAgeLessThat(30) && isLocationSP();
	}
	
	public Boolean guaranteeRuleTwo() {
		return isSalaryBiggerThan(4999) && isAgeLessThat(30);
	}
	
	public Boolean guaranteeRuleThree() {
		return isSalaryBiggerThan(3000) && isSalaryLessThan(5001) && isLocationSP();
	}

	public boolean hasConsigned() {
		return isSalaryBiggerThan(4999);
	}

}
