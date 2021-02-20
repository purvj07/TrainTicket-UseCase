package trainTicketApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Scanner;

public class TrainDAO 

{

	String driverClass="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/traininfo?autoReconnect=true&useSSL=false";
	String userName="root";
	String password="root";
	public Train findTrain(int trainNumber)
	{




		int id = trainNumber;
		Train train = null;
		try
		{
			//step 1 for database connectivity
			Class.forName(driverClass);
			System.out.println("class found");


			Connection con = DriverManager.getConnection(url,userName,password);
			System.out.println("connected");

			PreparedStatement ps = con.prepareStatement("select * from trains where Train_No = ?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();


			while(rs.next())
			{

				train = new Train(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}

			con.close();


		}
		catch (Exception e) 
		{
			System.out.print(e);
		}
		return train;
	}
}
