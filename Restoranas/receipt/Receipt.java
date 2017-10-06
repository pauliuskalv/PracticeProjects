package receipt;

import java.util.Vector;

import dataManagement.*;

public class Receipt 														// create new receipt for every customer
{
	double sum;
	
	double waitersFee = 0;													// percentage of what waiter gets of the total (system administrator should be able to change it)
	String currency = "$";													// currency used when printing receipts (system administrator should be able to change it)
	
	Vector<Product> products = new Vector<Product>();
	Vector<Service> services = new Vector<Service>();
	
	
	//-------------------------------------
	// methods
	
	public void orderService (Service service)
	{
		services.add(service);
	}
	
	public void orderProduct (Product product)
	{
		products.add(product);
	}
	
	public void print(Vector<Product> products, Vector<Service> services) 
	{
		// print to graphical user interface when it is created
		// using console for now
		for(Product product : products)
		{
			System.out.println(product.name + " - " + product.price);
			sum += product.price;
		}
		System.out.println("Services:");
		for(Service service : services)
		{
			System.out.println(service.name + " - " + service.price);
			sum += service.price;
		}
		System.out.println();
		
		if(waitersFee != 0)
		{
			System.out.println("Waiter`s fee: " + waitersFee + "%");
			sum = sum + (sum * (waitersFee / 100));
			System.out.println();
		}
		
		System.out.println("Total: " + sum + currency);
	}
	
}
