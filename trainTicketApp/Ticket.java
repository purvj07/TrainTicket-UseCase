package trainTicketApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.TreeMap;

public class Ticket 
{
	
	
	public Ticket(LocalDate travelDate, Train train) {
		super();
		this.travelDate = travelDate;
		this.train = train;
	}


	private  int counter=100;
	private String pnr;
	private LocalDate travelDate;
	private Train train;
	private TreeMap<Passenger, Double> passengers=new TreeMap();
//	public Ticket(int counter, String pnr, LocalDate travelDate, Train train, TreeMap<Passenger, Double> passengers) {
//		super();
//		this.counter = counter;
//		this.pnr = pnr;
//		this.travelDate = travelDate;
//		this.train = train;
//		this.passengers = passengers;
//	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
//	public TreeMap<Passenger, Double> getPassengers() {
//		return passengers;
//	}
//	public void setPassengers(TreeMap<Passenger, Double> passengers) {
//		this.passengers = passengers;
//	}
	
	
	@Override
	public String toString() {
		return "Ticket [counter=" + counter + ", pnr=" + pnr + ", travelDate=" + travelDate + ", train=" + train
				+ ", passengers=" + passengers + "]";
	}
	
	
	public String generatePNR()
	{
		String source=String.valueOf(train.getSource().charAt(0));
		String destination=String.valueOf(train.getDestination().charAt(0));
		String date=travelDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		pnr = source+destination+"_"+date+"_"+counter;
		counter++;
		return pnr;
		
		
		
	 }
	double calcPassengerFare(Passenger passenger) {
		
		if(passenger.getAge()<=12)
		
			return (0.5)*(train.getTicketprice());
		else if(passenger.getAge()>=60)
			return (0.60) *(train.getTicketprice());
		else if(passenger.getGender()=='F'||passenger.getGender()=='f')
			return (0.25)*(train.getTicketprice());
		else
			return train.getTicketprice();
		
	}
	
	public void addPassenger(String name,int age,char gender)
	{
		Double fare = calcPassengerFare(new Passenger(name,age,gender));
		passengers.put(new Passenger(name,age,gender),fare);
		
	
	}
	double calculateTotalTicketPrice()
	{
		Double totalPrice=0.0;
		for(Double values:passengers.values())
		{
			totalPrice = totalPrice+values;
			
		}
		return totalPrice;
			
	}
	
	StringBuilder generateTicket()
	{
		Collection<Passenger> entrySet=passengers.keySet();
		StringBuilder sb=new StringBuilder();
		
		sb.append("PNR   :"+generatePNR()).append("\n")
		.append("TrainNo :"+train.getTrainNo()).append("\n")
		.append("Train Name :"+train.getTrainName()).append("\n")
		.append("from :"+train.getSource()).append("\n")
		.append("to :"+train.getDestination()).append("\n")
		.append("travelDate :"+travelDate).append("\n")
		.append("\n").append("\n").append("Passengers :")
		.append("\n").append("Name    \t").append("     Age\t")
		.append("    Gender").append("\tFare").append("\n");
		 for(Passenger Key:entrySet)
		 {
			sb.append(Key+"    "+passengers.get(Key));
			sb.append("\n");
		 }
		 sb.append("\n")
		.append("totalPrice: "+calculateTotalTicketPrice());
		return sb;

	}

	public  void writeTicket() throws IOException
	{
		FileWriter f=new FileWriter(generatePNR()+".txt");
		BufferedWriter bw=new BufferedWriter(f);
		 bw.append(generateTicket());
		 bw.flush();
		 bw.close();

	
	
	}
	}
