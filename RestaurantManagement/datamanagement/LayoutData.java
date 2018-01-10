package datamanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import datamanagement.Utilities;

import tables.Table;

public class LayoutData
{
	Vector<Table> tableList;
	Vector<Wall> wallList;

	String tableDataName = "TableData";		// filenames
	String wallDataName = "WallData";

	public void save()
	{
		saveTables();
		saveWalls();
	}

	public void load()
	{
		loadTableList();
		loadWallList();
	}
	
	private void saveTables()
	{
		Utilities.saveTableVector(this.tableList, tableDataName);
	}

	private void saveWalls()
	{
		Utilities.saveWallVector(this.wallList, wallDataName);
	}
	
	private void loadTableList()
	{
		this.tableList = Utilities.loadTableVector(tableDataName);
	}
	
	private void loadWallList()
	{
		this.wallList = Utilities.loadWallVector(wallDataName);
	}
}
