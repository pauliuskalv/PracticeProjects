package dataManagement;

public class Service 
{
	public String name;
	public double price;
	int id;							// id should be set automatically
	
	public Service(String name, double price, int id) 
	{
		this.name = name;
		this.price = price;
		this.id = id;
	}
}
