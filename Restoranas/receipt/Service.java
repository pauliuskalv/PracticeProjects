package receipt;

import java.util.Vector;

import dataManagement.Product;

public class Service 
{
	Vector serviceVector = new Vector<Product>();
	double sum;
	
	public Service(Vector<Product> serviceVector) 
	{
		this.serviceVector = serviceVector;
		for(Product x : serviceVector)
		{
			this.sum += x.price;
		}
	}
	
	
	
}
