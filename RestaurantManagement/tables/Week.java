package tables;

import java.util.Vector;

import datamanagement.Service;
import tables.TimeTracker;
import datamanagement.StatisticData;


public class Week 
{
    Vector<Day> week;

    public Week(Vector<Day> days)
    {
        for(int i = 0; i < 7; i++)
        {   
            this.week.add(days.get(days.size() - i));
        }
    }

}