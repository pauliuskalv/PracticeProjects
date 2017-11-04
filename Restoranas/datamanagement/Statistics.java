package datamanagement;

import java.util.Vector;

import tables.Day;

public class Statistics
{
	// every method per 7 days
	// every method per 30 days
	// every method per 365 days
	// most profitable product/service list
	// most ordered product/service list
	// most common 2 product combinations list
	// average profits
	// most common product attribute list
	// average profit per customer
	
	
	//---------------------------------------
	
	public int getProductsSold(Day day)
	{
		return day.productsSold;
	}
	
	public int getProductsSold(Vector<Day> days)
	{
		int sold = 0;
		for(Day day : days)
		{
			sold += day.productsSold;
		}
		return sold;
	}

	public int getProductsSoldWeek(Vector<Day> days)
	{
		int sold = 0;
		for(int i = 0; i < 7; i++)
		{
			sold += days.get(days.size() - i).productsSold;
		}
		return sold;
	}
	
	//---------------------------------------
	
	public int getServicesSold(Day day)
	{
		return day.servicesSold;
	}
	
	public int getServicesSold(Vector<Day> days)
	{
		int sold = 0;
		for(Day day : days)
		{
			sold += day.servicesSold;
		}
		return sold;
	}
	
	//---------------------------------------
	
	public double getAverageProductsSold(Vector<Day> days)
	{
		int sum = 0;
		int amount = 0;
		
		for(Day day : days)
		{
			sum += day.productsSold;
			amount++;
		}
		return (double)sum/amount;
	}
	
	public double getAverageServicesSold(Vector<Day> days)
	{
		int sum = 0;
		int amount = 0;
		
		for(Day day : days)
		{
			sum += day.servicesSold;
			amount++;
		}
		return (double)sum/amount;
	}
	
	//---------------------------------------
	
	public Vector<Service> getMostProfitableServices(Vector<Day> days, ServiceData serviceData)
	{
		double[] sum;
		for(Day day : days)
		{
			for(int i = 0; i < serviceData.fullList.size(); i++)
			{
				sum[i] = serviceData.fullList.elementAt(i).price * day.amountOfEverySold[i];
			}
		}
		return sort(serviceData.fullList, sum);
	}
	

	//--------------------------------------

	public int getNumberOfCustomers(Vector<Day> days)
	{
		int number = 0;
		for(Day day : days)
		{
			number += day.tablesOccupied;
		}
		return number;
	}


	// utilities

	public Vector sort(Vector vector, double[] value)
	{
		Vector sorted = new Vector();
		while(sorted.size() < vector.size())
		{
			double max = 0;
			int maxIndex = 0;
			for(int i = 0; i < vector.size(); i++)
			{
				if(value[i] > max)
				{
					max = value[i];
					maxIndex = i;
				}	
			}
			sorted.add(vector.elementAt(maxIndex));
		}
		return sorted;
	}

	public Vector<Day> getWeek(Vector<Day> days)
	{
		Vector<Day> week = new Vector<Day>();
		if(days.size() > 7)
		{
			for(int i = days.size(); i > days.size() - 7; i--)
			{
				week.add(days.elementAt(i));
			}
		}
		else
		{
			week = days;
		}
		return week;
	}

	public Vector<Day> getMonth(Vector<Day> days)
	{
		Vector<Day> month = new Vector<Day>();
		if(days.size() > 30)
		{
			for(int i = days.size(); i > days.size() - 30; i--)
			{
				month.add(days.elementAt(i));
			}
		}
		else
		{
			month = days;
		}
		return month;
	}

	public Vector<Day> getYear(Vector<Day> days)
	{
		Vector<Day> year = new Vector<Day>();
		if(days.size() > 365)
		{
			for(int i = days.size(); i > days.size() - 365; i--)
			{
				year.add(days.elementAt(i));
			}
		}
		else
		{
			year = days;
		}
		return year;
	}

}



