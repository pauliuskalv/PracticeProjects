package datamanagement;

import java.util.Vector;

import datamanagement.*;
import tables.Day;

public class Statistics
{
	// every method per week
	// every method per month
	// every method per year
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
	// per week, per month, per year	
	
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
	
	
	
	
}



