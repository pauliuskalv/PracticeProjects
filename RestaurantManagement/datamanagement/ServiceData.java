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

	String serviceDataName = "ServiceList";
	String attributeDataName = "AttributeData";
	
	public void create(String name, double price)
	{
		Service service = new Service(name, price);
		fullList.add(service);
	}

	public void create(String name, double price, Vector<String> attributes, int time)	// could be optimised to use this
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

	public void saveServiceList()
	{
		Utilites.saveObject(this.fullList, this.ServiceDataName);
	}

	public void saveAttributes()
	{
		Utilities.saveObject(this.attributeList, this.attributeDataName);
	}
	
	public void loadServiceList()
	{
		this.fullList = Utilites.loadObject(ServiceDataName);
	}

	public void loadAttributeList()
	{
		this attributeList = Utilities.loadObject(attributeDataName);
	}
}
