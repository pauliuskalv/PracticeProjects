package receipt;

import java.util.Vector;
import dataManagement.*;

public class OrderedServices 
{
	Vector<Product> services = new Vector<Product>();
	
	public void order (Product product)		// placing customer order
	{
		services.add(product);
	}
}
