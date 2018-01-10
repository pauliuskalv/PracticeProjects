package tables;

import java.util.Vector;

import datamanagement.Service;
import datamanagement.ServiceData;

public class Table 
{
	Customer customer;
	boolean occupied;
	
	int x;					// assuming that user interface will use coordinate system
	int y;
	
	public Table(Restaurant restaurant, int x, int y)
	{
		restaurant.tables.add(this);
		this.x = x;
		this.y = y;
	}
	
	public void newCustomer(Restaurant restaurant, Vector<Service> orders, ServiceData serviceData, Day day)
	{
		this.customer = new Customer(orders, serviceData, day);
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
