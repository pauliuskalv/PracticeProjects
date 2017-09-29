package dataManagement;

import java.util.Vector;

public class Product 
{
	String name;
	double price;
	int id;
	
	Vector attributes = new Vector<Attribute>();

	public Product(String name, double price, int id, Vector attributes) 
	{
		this.name = name;
		this.price = price;
		this.id = id;
		this.attributes = attributes;
	}
	
	
	
}
