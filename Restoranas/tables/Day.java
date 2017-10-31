package tables;

import java.util.Vector;

import datamanagement.Service;
import tables.TimeTracker;
import datamanagement.StatisticData;


public class Day 
{
	public int productsSold = 0;
	public int servicesSold = 0;
	
	public int tablesOccupied = 0;
	public Vector<Vector<Service>> sold = null;			// list of what each customer bought
	
	TimeTracker time;
	
	public Day(Restaurant restaurant)
	{
		this.time = new TimeTracker(restaurant);
	}
	
	
	public void end(StatisticData statistics)
	{
		statistics.writeDay(this);
		this.time = null;
	}
	
}
