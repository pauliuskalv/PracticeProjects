package datamanagement;

import java.util.Vector;

public class Service
{
	public String name;
	public double price;
	public Vector<String> attributes = new Vector<String>();
	
	public Service(String name, double price) 
	{
		this.name = name;
		this.price = price;
	}
	
	public int getTime() 
	{
		return 0;
	}
	
}
