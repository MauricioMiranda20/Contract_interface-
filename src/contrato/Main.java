package contrato;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PaypalService;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		Locale.setDefault(Locale.US);
		DateTimeFormatter stf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato: ");
		
		System.out.print("Numero: ");
		int number = sc.nextInt();
		
		System.out.print("Data (dd/mm/yyyy): ");
		LocalDate data = LocalDate.parse(sc.next(),stf);
		
		System.out.print("Valor do contrato: ");
		double parcela = sc.nextDouble();
		
		Contract contract = new Contract(number, data, parcela);
		
		ContractService cs = new ContractService(new PaypalService());
		
		System.out.print("Enter com o numero de parcelas:");
		int mes = sc.nextInt();
		
		cs.processContract(contract,mes);
		
		for(Installment installment: contract.getInstallment()) {
			System.out.println(installment);
		}

		
		sc.close();

	}

}
