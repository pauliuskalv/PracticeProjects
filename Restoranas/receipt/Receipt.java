package receipt;

import java.util.Vector;

import dataManagement.*;

public class Receipt 
{
	double sum;
	String currency = "$";													// currency used when printing receipts (system administrator should be able to change it)
	
	Vector<Product> products = new Vector<Product>();
	Vector<Service> otherServices = new Vector<Service>();
	
	
	//-------------------------------------
	// methods
	
	public void order (Product product)
	{
		products.add(product);
	}
	
	public void print(Vector<Product> serviceVector) 
	{
		// print to graphical user interface when it is created
		// using console for now
		for(Product product : serviceVector)
		{
			System.out.println(product.name + " - " + product.price);
			sum += product.price;
		}
		System.out.println();
		System.out.println("Total: " + sum + currency);
	}
	
}
