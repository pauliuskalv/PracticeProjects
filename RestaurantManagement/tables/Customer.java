package tables;

import java.util.Vector;

import datamanagement.Service;
import datamanagement.ServiceData;
import tables.Enums.CustomerStatus;

public class Customer 
{
	// time variables
  
	int waiting;			// time spent waiting for delivery
	int consuming;			// time spent consuming a product for a sense of when to bring receipt
	int checkout;			// time spent waiting for receipt
	
	int estimate;			// estimated time to deliver a product
	
	CustomerStatus status;

	boolean late = false;

	Vector<Service> orders;
	
	//---------------------------
	
	public Customer(Vector<Service> orders, ServiceData data, Day day)
	{
		this.status = CustomerStatus.WaitingForDelivery;
		order(orders, data, day);
	}
	
	//----------------------------
	
	public void order(Vector<Service> orders, ServiceData data, Day day)
	{
		this.orders = orders;
		this.estimate = getTimeToWait(orders);
		for(Service order : orders)
		{
			for(Service fromMenu : data.fullList)
			{
				if(order.equals(fromMenu))
				{
					day.amountOfEverySold[data.fullList.indexOf(fromMenu)]++;
				}
			}
		}
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
	
	public void lateCheck()
	{
		if(this.waiting > this.estimate)

		{
			this.late = true;
		}
	}
	
	public void delivered()				// has product
	{
		this.status = CustomerStatus.Consuming;
		this.late = false;
	}
	
	public void waitingToLeave(Restaurant restaurant)
	{
		this.status = CustomerStatus.LookingToCheckout;
		Receipt receipt = new Receipt(this.orders);
		
		// write statistics
		for(Service service : orders)
		{
			restaurant.currentDay.servicesSold++;
			if(service.getTime() != 0)					// a way to differentiate product
			{
				restaurant.currentDay.productsSold++;
			}
		}
	}
}
