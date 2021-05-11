package pt.axians.loan.usecase.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import pt.axians.loan.entity.Modality;

public class LoanModalityRequest {

	@NotBlank
	private String name;

	@NotBlank
	private String cpf;

	@Positive
	private int age;

	@NotBlank
	private String location;

	@NotNull
	private BigDecimal income;

	public LoanModalityRequest(
			@NotBlank String name, 
			@NotBlank String cpf, 
			@Positive int age,
			@NotBlank String location, 
			@NotBlank BigDecimal income) {
		this.name = name;
		this.cpf = cpf;
		this.age = age;
		this.location = location;
		this.income = income;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public Modality toModel() {
		return new Modality(name, cpf, age, location, income);
	}
}
