package tables;

import java.util.Vector;
import dataManagement.Service;

public class Table 
{
	
	Customer customer;
	
	boolean occupied;
	
	public void newCustomer(Vector<Service> orders)
	{
		this.customer = new Customer(orders);
	}
	
	public void customerQuit()
	{
		this.customer = null;
	}
	// finalize
	
	
	
}
