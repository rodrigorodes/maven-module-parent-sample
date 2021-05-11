package pt.axians.loan.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pt.axians.loan.dataprovider.LoanConsignedDataProviderTest;
import pt.axians.loan.dataprovider.LoanGuaranteeDataProviderTest;
import pt.axians.loan.dataprovider.LoanPersonalDataProviderTest;
import pt.axians.loan.usecase.impl.LoanModalityUseCaseImpl;
import pt.axians.loan.usecase.request.LoanModalityRequest;
import pt.axians.loan.usecase.response.LoanModalityResponse;

public class LoanModalityUseCaseImplTest {
	
	private LoanModalityUseCase loanModalityUseCase = new LoanModalityUseCaseImpl(
			List.of(new LoanConsignedDataProviderTest(),
					new LoanGuaranteeDataProviderTest(), 
					new LoanPersonalDataProviderTest()));

	@Test
	@DisplayName("Emprestimo Pessoal, Salário menor que 3000")
	public void test1() {
		
		LoanModalityRequest request = new LoanModalityRequest("Erikaya", "292.426.230-59", 30, "SP", new BigDecimal(3000));
		
		LoanModalityResponse loanModalityResponse = loanModalityUseCase.execute(request);
		
		assertEquals(loanModalityResponse.getCustomer(), request.getName());
		
	}
	
	@Test
	@DisplayName("Emprestimo Pessoal, Salário maior que 3000")
	public void test2() {
		
		LoanModalityRequest request = new LoanModalityRequest("Erikaya", "292.426.230-59", 30, "SP", new BigDecimal(3001));
		
		LoanModalityResponse loanModalityResponse = loanModalityUseCase.execute(request);
		
		assertEquals(loanModalityResponse.getCustomer(), request.getName());
	}	
	
	@Test
	@DisplayName("Emprestimo Consignado, Salário maior que 5000")
	public void test3() {
		
		LoanModalityRequest request = new LoanModalityRequest("Erikaya", "292.426.230-59", 30, "SP", new BigDecimal(5001));
		
		LoanModalityResponse loanModalityResponse = loanModalityUseCase.execute(request);
		
		assertTrue(loanModalityResponse.getLoans().size() == 2);
	}
	
	
	@Test
	@DisplayName("Emprestimo Consignado, Salário menor que 5000")
	public void test4() {
		
		LoanModalityRequest request = new LoanModalityRequest("Erikaya", "292.426.230-59", 31, "SP", new BigDecimal(4999));
		
		LoanModalityResponse loanModalityResponse = loanModalityUseCase.execute(request);
		
		assertTrue(loanModalityResponse.getLoans().size() == 2);
	}
	
	@Test
	@DisplayName("Emprestimo com garantia, Salário menor ou igual que 3000 e Clientes com menos de 30 anos que residem em SP")
	public void test5() {
		
		LoanModalityRequest request = new LoanModalityRequest("Erikaya", "292.426.230-59", 29, "SP", new BigDecimal(3000));
		
		LoanModalityResponse loanModalityResponse = loanModalityUseCase.execute(request);
		
		assertTrue(loanModalityResponse.getLoans().size() == 2);
	}	
	
	@Test
	@DisplayName("Emprestimo com garantia, Salário maior que 3000 e menor ou igual 5000 e Clientes que residem em SP")
	public void test6() {
		
		LoanModalityRequest request = new LoanModalityRequest("Erikaya", "292.426.230-59", 35, "SP", new BigDecimal(3001));
		
		LoanModalityResponse loanModalityResponse = loanModalityUseCase.execute(request);
		
		assertTrue(loanModalityResponse.getLoans().size() == 2);
	}
	
	@Test
	@DisplayName("Emprestimo com garantia, Salário maior ou igual 5000 e Clientes com menos de 30 anos")
	public void test7() {
		
		LoanModalityRequest request = new LoanModalityRequest("Erikaya", "292.426.230-59", 29, "SP", new BigDecimal(5000));
		
		LoanModalityResponse loanModalityResponse = loanModalityUseCase.execute(request);
		
		assertTrue(loanModalityResponse.getLoans().size() == 3);
	}	
	
}
