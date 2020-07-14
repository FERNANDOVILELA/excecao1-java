package applivation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.reservas;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do Quarto: ");
		int numero = sc.nextInt();
		System.out.print("Date de CheckIn: ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Date de CheckOut: ");
		Date checkout = sdf.parse(sc.next());
		
		if (!checkout.after(checkin)) {
			System.out.println("Erro na Reserva! a data de checkIn é superior ao CheckOut.");
		}
		else {
			reservas reserva = new reservas(numero, checkin, checkout);
			System.out.println("Reverva: " + reserva);
			
			System.out.println();
			System.out.println("== Entre com a Nova Data de reseva == ");
			System.out.print("Date de CheckIn: ");
			checkin = sdf.parse(sc.next());
			System.out.print("Date de CheckOut: ");
			checkout = sdf.parse(sc.next());
			
			reserva.updateDates(checkin, checkout);
			System.out.println("Reverva: " + reserva);
		}
		
		sc.close();
	}

}
