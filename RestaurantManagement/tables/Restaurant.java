package tables;

import java.util.Vector;
import datamanagement.*;
import tables.*;

public class Restaurant 
{
	public Vector<Table> tables;
	public Vector<Customer> customers;
	public ServiceData serviceData;
	public LayoutData layoutData;
	public UserData userData;
	public StatisticData statisticData;

	public Day currentDay;

	public Restaurant()
	{
		this.tables = new Vector<Table>();
		this.customers = new Vector<Customer>();
		this.serviceData = new ServiceData();
		this.layoutData = new LayoutData();
		this.userData = new UserData();
		this.statisticData = new StatisticData();
	}
	
	public void newDay()
	{
		this.currentDay = new Day(this);
	}

	public void endDay()
	{
		this.currentDay.end(statisticData);
		this.currentDay = null;
	}

	public void saveAllData()
	{
		serviceData.save();
		layoutData.save();
		userData.save();
		statisticData.save();
	}

	public void loadAllData()
	{
		serviceData.load();
		layoutData.load();
		userData.load();
		statisticData.load();
	}
	
}
