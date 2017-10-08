package dataManagement;

import java.util.Vector;

public class Database
{
	Vector<Service> fullList = new Vector<Service>();
	
	public void create(String name, double price)
	{
		Service service = new Service(name, price);
		fullList.add(service);
	}
	public void create(String name, double price, Vector<Attribute> attributes)
	{
		Product product = new Product(name, price, attributes);
		fullList.add(product);
	}
	
	public void remove(Service service)
	{
		fullList.remove(service);
	}
	
}
