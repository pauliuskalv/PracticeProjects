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
	
	public void save(Vector<Table> tables, Vector<Wall> walls) throws IOException
	{
		// tables
		
		FileOutputStream fileStream = new FileOutputStream("tables.txt");
	    ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
	    
		objectStream.writeObject(tables);
		
		fileStream.close();
		objectStream.close();
		
		// walls
		
		fileStream = new FileOutputStream("walls.txt");
	    objectStream = new ObjectOutputStream(fileStream);
	    
		objectStream.writeObject(walls);
		
		fileStream.close();
		objectStream.close();
	}
	
	public void load() throws IOException, ClassNotFoundException
	{
		FileInputStream fileStream = new FileInputStream("tables.txt");
		ObjectInputStream objectStream = new ObjectInputStream(fileStream);
		
		
		this.tableList = (Vector<Table>)objectStream.readObject();
		
		objectStream.close();
		fileStream.close();
		
		fileStream = new FileInputStream("tables.txt");
		objectStream = new ObjectInputStream(fileStream);
		
		
		this.wallList = (Vector<Wall>)objectStream.readObject();
		
		objectStream.close();
		fileStream.close();
	}
	
}
