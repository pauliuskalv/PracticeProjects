package datamanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class ServiceData
{
	public Vector<Service> fullList;			// product and service list
	public Vector<String> attributeList;		// list of all used attributes

	private String serviceDataName;
	private String attributeDataName;

	public ServiceData()
	{
		fullList = new Vector<Service>();
		attributeList = new Vector<String>();
		serviceDataName = "ServiceList";
		attributeDataName = "AttributeData";
	}
	
	public void create(String name, double price) 			// creates new service and adds it to the list
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
			// if attribute isn`t the same as every other in the already used attribute list
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

	// saving and loading
	public void save()
	{
		saveServiceList();
		saveAttributes();
	}

	public void load()
	{
		loadServiceList();
		loadAttributeList();
	}

	private void saveServiceList()
	{
		Utilities.saveServiceVector(this.fullList, this.serviceDataName);
	}

	private void saveAttributes()
	{
		Utilities.saveStringVector(this.attributeList, this.attributeDataName);
	}

	private void loadServiceList()
	{
		this.fullList = Utilities.loadServiceVector(serviceDataName);
	}

	private void loadAttributeList()
	{
		this.attributeList = Utilities.loadStringVector(attributeDataName);
	}
}
