package dataManagement;

import java.util.Vector;

public class Product extends Service
{
	
	Vector<Attribute> attributes = new Vector<Attribute>();
	
	public Product(String name, double price, Vector<Attribute> attributes) 
	{
		super(name, price);
		this.attributes = attributes;
	}
}
