package tables;

import java.util.Vector;

import datamanagement.Service;

public class Table 
{
	Customer customer;
	boolean occupied;
	
	public Table()
	{
		Restaurant.tables.add(this);
	}
	
	
	public void newCustomer(Vector<Service> orders)
	{
		this.customer = new Customer(orders);
		Restaurant.customers.add(this.customer);
		this.occupied = true;
	}
	
	public void customerQuit()
	{
		Restaurant.customers.remove(this.customer);
		this.customer = null;
		this.occupied = false;
	}
	// finalize
	
	
	
}
