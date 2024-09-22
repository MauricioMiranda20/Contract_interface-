package model.service;

public interface OnlinePaymentService {

	public double paymentFee(double amount);
	public double interest(double amount,Integer months);
	
}
