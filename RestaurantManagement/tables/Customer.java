package tables;

import java.util.Vector;

import dataManagement.Service;

public class Customer 
{
	// time variables
	int waiting;			// time spent waiting for delivery of food
	int consuming;			// time spent consuming a product for a sense of when to bring receipt
	int estimate;
	
	boolean late = false;

	Vector<Service> orders;
	
	public Customer(Vector<Service> orders)
	{
		this.orders = orders;
	}
	
	public int getTimeToWait(Vector<Service> orders)					// approximate wait time for order
	{
		int max = 0;
		
		for(Service order : orders)
		{	
			if(order.getTime() > max)
			{
				max = order.getTime();
			}
		}
		
		return max;
	}
	
	public void lateCheck(int waiting, int estimate)
	{
		if(waiting > estimate)
		{
			this.late = true;
		}
	}
	
	
}
