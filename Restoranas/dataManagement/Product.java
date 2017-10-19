package dataManagement;

import java.util.Vector;

public class Product extends Service
{
	Vector<String> attributes = new Vector<String>();
	int time;											// how much time it takes to prepare the product
	
	public Product(String name, double price, Vector<String> attributes, int time) 
	{
		super(name, price);
		this.attributes = attributes;
		this.time = time;
	}

	public int getTime() 
	{
		return time;
	}
	
	
}
