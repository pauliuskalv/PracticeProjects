package datamanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import tables.Table;

public class LayoutData
{
	Vector<Table> tableList;
	Vector<Wall> wallList;

	String tableDataName = "TableData";		// filenames
	String wallDataName = "WallData";
	
	public void saveTables()
	{
		Utilities.saveObject(this.tableList, TableDataName);
	}

	public void saveWalls()
	{
		Utilities.saveObject(this.wallList, WallDataName);
	}
	
	public void loadTableList()
	{
		this.tableList = Utilities.loadObject(this.tableList, tableDataName);
	}
	
	public void loadWallList()
	{
		this.tableList = Utilities.loadObject(this.wallList, wallDataName);
	}
}
