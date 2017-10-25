package tables;

import java.util.Vector;

import datamanagement.Service;

public class Table 
{
	Customer customer;
	boolean occupied;
	
	public Table(Restaurant restaurant)
	{
		restaurant.tables.add(this);
	}
	
	
	public void newCustomer(Restaurant restaurant, Vector<Service> orders)
	{
		this.customer = new Customer(orders);
		restaurant.customers.add(this.customer);
		this.occupied = true;
		restaurant.currentDay.tablesOccupied++;
	}
	
	public void customerQuit(Restaurant restaurant)
	{
		restaurant.customers.remove(this.customer);
		this.customer = null;
		this.occupied = false;
	}
}
