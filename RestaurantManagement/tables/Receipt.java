package tables;

import java.util.Vector;

import datamanagement.*;

public class Receipt 														// create new receipt for every customer
{
	double waitersFee = 0;													// percentage of what waiter gets of the total (system administrator should be able to change it)
	String currency = "$";													// currency used when printing receipts (system administrator should be able to change it)
	
	Vector<Service> orders = new Vector<Service>();
	
	public Receipt(Vector<Service> orders) 
	{
		this.orders = orders;
	}
	
	//-------------------------------------
	// methods
	
	public String getReceipt(Vector<Service> services) 
	{
		double sum = 0;
		String receipt = "";
		for(Service service : services)
		{
			receipt += service.name + " - " + service.price + "/n";
			sum += service.price;
		}
		
		if(waitersFee != 0)
		{
			receipt += "Waiter`s fee: " + waitersFee + "%" + "/n";
			sum = sum + (sum * (waitersFee / 100));
		}
		receipt += "Total: " + sum + currency;
		return receipt;
	}
	
}
