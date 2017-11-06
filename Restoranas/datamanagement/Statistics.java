package datamanagement;

import java.util.Vector;

import tables.Day;

public class Statistics
{
	// every method per 7 days				+
	// every method per 30 days				+
	// every method per 365 days			+
	// most profitable product/service list	+
	// most ordered product/service list	+
	// most common 2 product combinations list	-???
	// average profits per day				+
	// most common product attribute list	-
	// most profitable product attribute list-
	// average profit per customer			-???
	


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
	
	//---------------------------------------
	
	public int getProductsSold(Vector<Day> days)
	{
		int sold = 0;
		for(Day day : days)
		{
			sold += day.productsSold;
		}
		return sold;
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
		double[] sum = new double[serviceData.fullList.size()];
		for(Day day : days)
		{
			for(int i = 0; i < serviceData.fullList.size(); i++)
			{
				sum[i] += serviceData.fullList.elementAt(i).price * day.amountOfEverySold[i];
			}
		}
		return sort(serviceData.fullList, sum);
	}

	//--------------------------------------

	public Vector<Service> getMostOrderedServices(Vector<Day> days, ServiceData serviceData)
	{
		int[] amount = getAmountOfEverySold(days, serviceData);
		
		return sort(serviceData.fullList, amount);
	}

	//--------------------------------------

	public double getProfits(Vector<Day> days, ServiceData serviceData)
	{
		double sum = 0;
		int[] amount = getAmountOfEverySold(days, serviceData);

		int i = 0;
		
		for(Service service : serviceData.fullList)
		{
			sum += service.price * amount[i];
		}

		return sum;
	}


	public double getAverageProfits(Vector<Day> days, ServiceData serviceData)
	{

		double sum = 0;
		int[] amount = getAmountOfEverySold(days, serviceData);

		int i = 0;
		
		for(Service service : serviceData.fullList)
		{
			sum += service.price * amount[i];
			i++;
		}

		return sum/days.size();
	}

	//-------------------------------------
/*
	public Vector<String> getMostCommonAttrubutes(Vector<Day> days, ServiceData serviceData)
	{
		int[] amount = getAmountOfEverySold(days, serviceData);
		
		for(Service service : serviceData.fullList)
		{
			//service.attributeList
			
		}
		
		
	}
*/
	//--------------------------------------
	// utilities
	//--------------------------------------

	// calculates how many units of every service has been sold
	public int[] getAmountOfEverySold(Vector<Day> days, ServiceData serviceData)
	{
		int[] amount = new int[serviceData.fullList.size()];

		for(Day day : days)
		{
			for(int i = 0; i < serviceData.fullList.size(); i++)
			{
				amount[i] += day.amountOfEverySold[i];
			}
		}

		return amount;
	}

	// sort descending based on given value array
	public Vector<Service> sort(Vector<Service> vector, double[] value)
	{
		Vector<Service> sorted = new Vector<Service>();
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

	public Vector<Service> sort(Vector<Service> vector, int[] value)
	{
		Vector<Service> sorted = new Vector<Service>();
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



