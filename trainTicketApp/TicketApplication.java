package trainTicketApp;

import java.util.Scanner;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TicketApplication {

	public static void main(String[] args) throws IOException {
		
		System.out.println("=====================TicketApp====================");
		
		TrainDAO trainDao = new TrainDAO();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the train_No to get details");
		
		
		Train train = trainDao.findTrain(scanner.nextInt());
		System.out.println(train.getTicketprice());
		System.out.println("enter travel date ");
		String travelDate = scanner.next();
		LocalDate date = LocalDate.parse(travelDate, df);
		
		Ticket ticket = new Ticket(date, train);
		
		System.out.println("travel Date "+ date );
		
		System.out.println("No of passengers: ");
		int numberOfPassengers = scanner.nextInt();
		
		System.out.println("\n");
		for(int i=1;i<=numberOfPassengers;i++)
		{
			System.out.println("Enter Passenger name: ");
			String name = scanner.next();
			System.out.println("Enter Passenger Age: ");
			int age =  scanner.nextInt();
			System.out.println("Enter passenger Gender");
			String gend = scanner.next();
			char gender = gend.charAt(0);
			
			ticket.addPassenger(name,age,gender);
			
		}
		
		System.out.println("Ticket booked with pnr: " +ticket.generatePNR());
		ticket.writeTicket();
		
		
		
	
	}

}
