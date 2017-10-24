package tables;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import tables.Enums.CustomerStatus;

public class TimeTracker 
{
		
	public TimeTracker()
	{
		final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		
        executor.scheduleWithFixedDelay
        (
        		new Runnable() 
        		{
        			public void run() 
        			{
        				update();
        			}
        		}, 0, 1, TimeUnit.SECONDS
        );
	}
	
	public void update()						// ran every second
	{
		for(Customer customer : Restaurant.customers)
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
