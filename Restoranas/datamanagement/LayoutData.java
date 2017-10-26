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
	
	Vector<Table> tables;
	
	public void save() throws IOException
	{
		FileOutputStream fileStream = new FileOutputStream("layout.txt");
	    ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
	    
		objectStream.writeObject(this.tables);
		
		fileStream.close();
		objectStream.close();
	}
	
	public void loadStatistics() throws IOException, ClassNotFoundException
	{
		FileInputStream fileStream = new FileInputStream("layout.txt");
		ObjectInputStream objectStream = new ObjectInputStream(fileStream);
		
		this.tables = (Vector<Table>)objectStream.readObject();
		
		objectStream.close();
		fileStream.close();
	}
}
