package datamanagement;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import tables.Day;

public class StatisticData
{
	String filename = "dayData";

	public Vector<Day> dayList;
	
	public void writeDay(Day day)
	{
		dayList.add(day);
	}
	
	public void save()
	{
		Utilities.saveDayVector(dayList, filename);
	}
	
	public void load()
	{
		this.dayList = Utilities.loadDayVector(filename);
	}
	
	
}
