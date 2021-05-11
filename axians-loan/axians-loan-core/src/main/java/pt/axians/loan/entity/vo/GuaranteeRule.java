package pt.axians.loan.entity.vo;

import java.util.function.Function;

import pt.axians.loan.entity.Modality;

public enum GuaranteeRule {

	RULE_ONE(Modality::guaranteeRuleOne), 
	RULE_TWO(Modality::guaranteeRuleTwo), 
	RULE_THREE(Modality::guaranteeRuleThree);

	private Function<Modality, Boolean> modalityFunction;

	private GuaranteeRule(Function<Modality, Boolean> modalityFunction) {
		this.modalityFunction = modalityFunction;
	}

	public Function<Modality, Boolean> getModalityFunction() {
		return modalityFunction;
	}
}
