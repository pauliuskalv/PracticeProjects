package tables;

import java.util.Vector;

public class Restaurant 
{
	public Vector<Table> tables = new Vector<Table>();
	public Vector<Customer> customers = new Vector<Customer>();
	
	public Day currentDay;

	public Restaurant()
	{
		this.currentDay = new Day(this);
	}
	
	
}
