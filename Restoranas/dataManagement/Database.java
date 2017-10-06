package dataManagement;

import java.util.Vector;

public class Database 	// store everything in vectors
{
	Vector<Service> fullList = new Vector<Service>();
	Vector<Service> serviceList = new Vector<Service>();
	Vector<Product> productList = new Vector<Product>();
	
	public Service createService(String name, double price)
	{
		Service service = new Service(name, price);
		fullList.add(service);
		serviceList.add(service);
		return service;
	}
	public Product createProduct(String name, double price, Vector<Attribute> attributes)
	{
		Product product = new Product(name, price, attributes);
		fullList.add(product);
		productList.add(product);
		return product;
	}
	
	public void removeService(Service service)
	{
		fullList.remove(service);					// as far as I remember there is no need to check if vector contains the item before removing it
		serviceList.remove(service);
	}
	public void removeProduct(Product product)
	{
		fullList.remove(product);
		productList.remove(product);
	}
	
}
