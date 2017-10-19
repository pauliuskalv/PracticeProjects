package dataManagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class ServiceData
{
	Vector<Service> fullList = new Vector<Service>();
	
	public void create(String name, double price)
	{
		Service service = new Service(name, price);
		fullList.add(service);
	}
	public void create(String name, double price, Vector<String> attributes, int time)
	{
		Product product = new Product(name, price, attributes, time);
		fullList.add(product);
	}
	
	public void remove(Service service)
	{
		fullList.remove(service);
	}
	
	public void save(Vector <Service> fullList) throws IOException
	{
		FileOutputStream fileStream = new FileOutputStream("data.txt");
	    ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
	    
		objectStream.writeObject(fullList);
		
		fileStream.close();
		objectStream.close();
	}
	
	public Vector<Service> loadDataList() throws IOException, ClassNotFoundException
	{
		FileInputStream fileStream = new FileInputStream("data.txt");
		ObjectInputStream objectStream = new ObjectInputStream(fileStream);
		Vector<Service> list = new Vector<Service>();
		
		list = (Vector<Service>)objectStream.readObject();
		
		objectStream.close();
		fileStream.close();
		return list;
	}
	
}
