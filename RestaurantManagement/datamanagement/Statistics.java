package datamanagement;

import java.util.Vector;

import tables.Day;

public class Statistics
{

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
	
	public Vector<DataNode> getMostProfitableServices(Vector<Day> days, ServiceData serviceData)
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

	public Vector<DataNode> getMostOrderedServices(Vector<Day> days, ServiceData serviceData)
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

	public Vector<DataNode> getMostCommonAttrubutes(Vector<Day> days, ServiceData serviceData)
	{
		int[] amount = getAmountOfEverySold(days, serviceData);
		int[] attributeAmount = new int[serviceData.attributeList.size()];
		
		for(Service service : serviceData.fullList)
		{
			for(String attribute : service.attributes)
			{
				attributeAmount[serviceData.attributeList.indexOf(attribute)] += amount[serviceData.fullList.indexOf(service)];
			}
		}

		return sortAttributes(serviceData.attributeList, attributeAmount);
	}

	public Vector<DataNode> getMostProfitableAttributeList(Vector<Day> days, ServiceData serviceData)
	{
		int[] attributeProfit = new int[serviceData.attributeList.size()];

		for(String attribute : serviceData.attributeList)
		{
			for(Service service : serviceData.fullList)
			{
				if(service.attributes.contains(attribute))
				{
					attributeProfit[serviceData.attributeList.indexOf(attribute)] += service.price;
				}
			}
		}

		return sortAttributes(serviceData.attributeList, attributeProfit);
	}

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

	public int[] getAmountOfAttributeInstances(Vector<Day> days, ServiceData serviceData)
	{
		int[] amount = getAmountOfEverySold(days, serviceData);
		int[] attributeAmount = new int[serviceData.attributeList.size()];
		
		for(Service service : serviceData.fullList)
		{
			for(String attribute : service.attributes)
			{
				attributeAmount[serviceData.attributeList.indexOf(attribute)] += amount[serviceData.fullList.indexOf(service)];
			}
		}
		return attributeAmount;
	}

	// sort descending based on given value array
	public Vector<DataNode> sort(Vector<Service> vector, double[] value)
	{
		Vector<DataNode> sorted = new Vector<DataNode>();
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
			sorted.add(new DataNode(vector.elementAt(maxIndex).name, value[maxIndex]));
		}
		return sorted;
	}

	public Vector<DataNode> sortAttributes(Vector<String> vector, int[] value)
	{
		Vector<DataNode> sorted = new Vector<DataNode>();
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
			sorted.add(new DataNode(vector.elementAt(maxIndex), value[maxIndex]));
		}
		return sorted;
	}

	public Vector<DataNode> sort(Vector<Service> vector, int[] value)
	{
		Vector<DataNode> sorted = new Vector<DataNode>();
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
			sorted.add(new DataNode(vector.elementAt(maxIndex).name, value[maxIndex]));
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



