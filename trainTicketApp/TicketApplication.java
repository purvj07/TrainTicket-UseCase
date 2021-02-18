package trainTicketApp;

import java.util.Scanner;
import java.util.Date;

public class TicketApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Source : ");
		String source = sc.next();
		
		System.out.println("Enter Destination : ");
		String destination = sc.next();
		
		Train train = new Train();
		
		train.setSource(source);
		train.setDestination(destination);
		
			
		Ticket ticket = new Ticket();
		
		
	
	}

}
