package tables;

import java.util.Vector;

public class Restaurant 
{
	public Vector<Table> tables;
	public Vector<Customer> customers;
	
	public Day currentDay;

	public Restaurant()
	{
		this.tables = new Vector<Table>();
		this.customers = new Vector<Customer>();
	}
	
	public void newDay()
	{
		this.currentDay = new Day(this);
	}

	public void endDay()
	{
		this.currentDay.end();
		this.currentDay = null;
	}

	public void saveAllData()
	{
		ServiceData.saveServiceList()
		ServiceData.saveAttributeList();

		LayoutData.saveTableList();
		LayoutData.saveWallList();

		UserData.saveUserList;

		StatisticData.save();
	}

	public void loadAllData()
	{
		ServiceData.loadServiceList();
		ServiceData.loadAttributeList();

		LayoutData.loadTableList();
		LayoutData.loadWallList();

		UserData.loadUserList();

		StatisticData.load();
	}
	
}
