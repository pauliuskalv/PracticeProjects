package tables;

import java.util.Vector;

import datamanagement.Service;
import tables.TimeTracker;

public class Day 
{
	public int productsSold = 0;
	public int servicesSold = 0;
	
	public int tablesOccupied = 0;
	public Vector<Vector<Service>> sold = null;			// list of what each customer bought
	
	TimeTracker time;
	
	public void start(Restaurant restaurant)
	{
		this.time = new TimeTracker(restaurant);
	}
	
	
	public void end()
	{
		// write into file by using a method from data management package
		// statisticData.writeDay(this);
		this.time = null;
	}
	
}
