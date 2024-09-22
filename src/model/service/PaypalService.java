package model.service;

public class PaypalService implements OnlinePaymentService{
	
	public double paymentFee(double amount) {
		return (amount*0.02) + amount;
	}

	public double interest(double amount,Integer months) {
		return (months*0.01) * amount + amount;
	}
}
