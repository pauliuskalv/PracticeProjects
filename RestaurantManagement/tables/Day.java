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

	public int[] amountOfEverySold;			// this may need to be initialised
	
	TimeTracker time;
	int timeElapsed;
	
	public Day(Restaurant restaurant)
	{
		this.time = new TimeTracker(restaurant);
		this.timeElapsed = 0;					// initialisation
		amountOfEverySold = new int[];
	}
	
	public void end(StatisticData statistics)
	{
		statistics.writeDay(this);
		this.time = null;
	}
	
}
