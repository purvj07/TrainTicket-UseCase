package trainTicketApp;

import java.time.LocalDate;
import java.util.Date;
import java.util.TreeMap;

public class Ticket 
{
	private  int counter = 100;
	private String pnr;
	private Date travelDate;
	private Train train;
	private TreeMap<Passenger, Integer> passengers;


	
	public Ticket() {
		super();
	}


	public Ticket(Date travelDate, Train train)
	{
		super();
		this.travelDate = travelDate;
		this.train = train;
	}


	public  int getCounter() {
		return counter;
	}


	public  void setCounter(int counter) {
		this.counter = counter;
	}


	public String getPnr() {
		return pnr;
	}


	public void setPnr(String pnr) {
		this.pnr = pnr;
	}


	public Date getTravelDate() {
		return travelDate;
	}


	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}


	public Train getTrain() {
		return train;
	}


	public void setTrain(Train train) {
		this.train = train;
	}
	public String generatePNR()
	{
		
		String s1 = String.valueOf(train.getSource().charAt(0));
		String d1 = String.valueOf(train.getDestination().charAt(0));
	
		String pnr = s1+d1+" "+LocalDate.now()+" "+counter++;
		return pnr;
		}


	public TreeMap<Passenger, Integer> getPassengers() {
		return passengers;
	}


	public void setPassengers(TreeMap<Passenger, Integer> passengers) {
		this.passengers = passengers;
	}


	@Override
	public String toString() {
		return "Ticket [ pnr=" + pnr + ", travelDate=" + travelDate + ", train=" + train
				+ ", passengers=" + passengers + "]";
	}

	
	public double calcPassengerFare(Passenger passenger)
	{
		double ticketFare=0;
		
		if(passenger.getAge()<=12)
		{
			ticketFare=train.getTicketprice()-0.50*(train.getTicketprice());
		}
		else if(passenger.getAge()>=60)
		{
			ticketFare = train.getTicketprice()-0.60*(train.getTicketprice());
		}
		else if(passenger.getGender()=='F'|| passenger.getGender()=='f')
		{
			ticketFare= train.getTicketprice()-0.25*(train.getTicketprice());
		}
		else
		{
			ticketFare = train.getTicketprice();
		}
		
		return ticketFare;
		
	}
	




}
