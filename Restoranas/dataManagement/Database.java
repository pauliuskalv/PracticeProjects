package dataManagement;

import java.util.Vector;

public class Database
{
	Vector<Service> fullList = new Vector<Service>();
	
	public Service create(String name, double price)
	{
		Service service = new Service(name, price);
		fullList.add(service);
		return service;
	}
	public Product create(String name, double price, Vector<Attribute> attributes)
	{
		Product product = new Product(name, price, attributes);
		fullList.add(product);
		return product;
	}
	
	public void removeService(Service service)
	{
		fullList.remove(service);
	}
	
}
