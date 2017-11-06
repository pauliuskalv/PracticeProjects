package datamanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class ServiceData
{
	public Vector<Service> fullList = new Vector<Service>();		// product and service list
	public Vector<String> attributeList = new Vector<String>();		// list of all used attributes
	
	public void create(String name, double price)
	{
		Service service = new Service(name, price);
		fullList.add(service);
	}

	public void create(String name, double price, Vector<String> attributes, int time)
	{
		Product product = new Product(name, price, attributes, time);
		
		for(String newAttribute : attributes)
		{
			int same = 0;
			for(String alreadyUsed : attributeList)
			{
				// if attribute is not the same, add plus one
				if(!alreadyUsed.equals(newAttribute))
				{
					same++;
				}
			}
			// if attribute isnt the same as every other in the already used attribute list
			if(same == attributeList.size())
			{
				attributeList.add(newAttribute);
			}
		}
		fullList.add(product);
	}
	
	public void remove(Service service)
	{
		fullList.remove(service);
	}
	
	// TODO: save and load attribute list
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
