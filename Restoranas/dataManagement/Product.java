package dataManagement;

import java.util.Vector;

public class Product extends Service
{
	
	Vector<Attribute> attributes = new Vector<Attribute>();
	
	public Product(String name, double price, int id, Vector<Attribute> attributes) 
	{
		super(name, price, id);
		this.attributes = attributes;
	}
}
