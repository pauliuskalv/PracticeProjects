package tables;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import tables.Enums.CustomerStatus;

public class TimeTracker 
{
		
	public TimeTracker(Restaurant restaurant)
	{
		final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		
        executor.scheduleWithFixedDelay
        (
        		new Runnable() 
        		{
        			public void run() 
        			{
        				update(restaurant);
        			}
        		}, 0, 1, TimeUnit.SECONDS
        );
	}
	
	public void update(Restaurant restaurant)						// ran every second
	{
		for(Customer customer : restaurant.customers)
		{
			if(customer.status == CustomerStatus.WaitingForDelivery)
			{
				customer.waiting++;
			}
			if(customer.status == CustomerStatus.Consuming)
			{
				customer.consuming++;
			}
			if(customer.status == CustomerStatus.LookingToCheckout)
			{
				customer.checkout++;
			}
			
			customer.lateCheck();
			
		}
	}
}
