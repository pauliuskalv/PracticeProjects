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
	public Vector<Day> dayList;
	
	
	public void writeDay(Day day)
	{
		dayList.add(day);
	}
	
	public void save(Vector <Day> list) throws IOException
	{
		FileOutputStream fileStream = new FileOutputStream("stats.txt");
	    ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
	    
		objectStream.writeObject(list);
		
		fileStream.close();
		objectStream.close();
	}
	
	public void load() throws IOException, ClassNotFoundException
	{
		FileInputStream fileStream = new FileInputStream("stats.txt");
		ObjectInputStream objectStream = new ObjectInputStream(fileStream);
		Vector<Day> list = new Vector<Day>();
		
		this.dayList = (Vector<Day>)objectStream.readObject();
		
		objectStream.close();
		fileStream.close();
	}
	
	
}
