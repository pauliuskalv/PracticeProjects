package datamanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import tables.Day;

public class StatisticData 
{
	public Vector<Day> dailyStats;
	
	// catch exceptions
	
	
	public void save() throws IOException
	{
		FileOutputStream fileStream = new FileOutputStream("statistics.txt");
	    ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
	    
		objectStream.writeObject(this.dailyStats);
		
		fileStream.close();
		objectStream.close();
	}
	
	public void loadStatistics() throws IOException, ClassNotFoundException
	{
		FileInputStream fileStream = new FileInputStream("statistics.txt");
		ObjectInputStream objectStream = new ObjectInputStream(fileStream);
		
		this.dailyStats = (Vector<Day>)objectStream.readObject();
		
		objectStream.close();
		fileStream.close();
	}
	
	
	
}
