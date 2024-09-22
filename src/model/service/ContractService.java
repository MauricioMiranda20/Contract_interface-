package model.service;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService ops;
	
	public ContractService() {

	}
	
	//precisa do contruct ele nao returna null e para usar o paypalServer, futuramente trocar o onlinePaymentServer 
	public ContractService(OnlinePaymentService ops) {
		this.ops = ops;
	}

	public void processContract(Contract contract,Integer months) {
		double valorPar = contract.getTotalValue() / months;
		
		for(int i=1;i<=months;i++) {
			LocalDate monthParc = contract.getDate().plusMonths(i);
			double valores2 = ops.paymentFee(ops.interest(valorPar,i));
			contract.getInstallment().add(new Installment(monthParc, valores2));
			
		}
	}

}
