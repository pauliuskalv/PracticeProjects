package dataManagement;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class Database 
{


	Vector<Attribute> attributes = new Vector<Attribute>();
	
	attributes.add(new Attribute("consumable"));			
	
    Product product = new Product("cookie", 2, 0, attributes);

}
