package datamanagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import tables.Day;

public class StatisticData 
{
	public Vector<Day> dailyStats;

	public void save()
	{
		FileOutputStream fileStream;
		try 
		{
			fileStream = new FileOutputStream("statistics.txt");
			ObjectOutputStream objectStream;
			try 
			{
				objectStream = new ObjectOutputStream(fileStream);
				objectStream.writeObject(this.dailyStats);
				objectStream.close();
				fileStream.close();
			}
			
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
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
