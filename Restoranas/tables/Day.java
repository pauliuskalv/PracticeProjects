package tables;

import tables.TimeTracker;

public class Day 
{
	public int productsSold = 0;			// write statistics into file
	public int servicesSold = 0;
	
	public int tablesOccupied = 0;
	
	TimeTracker time;
	
	public void start()
	{
		// start time tracking
		this.time = new TimeTracker();
	}
	
	
	public void end()
	{
		// write into file by using a method from data management package
		this.time = null;
	}
	
}
