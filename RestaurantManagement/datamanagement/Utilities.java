package datamanagement;

public class Utiliites
{
    // there is a problem if filename is changed
    // also file names may be encrypted
    // especially data itself

    String fileExtension = ".txt";          // can be changed into an enumeration later if need arises

    public void saveObject(Object object, String filename)
    {
        filename += fileExtension;
        try
        {
                FileOutputStream fileStream = new FileOutputStream(filename);
                try
                {
                    ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
    
                    objectStream.writeObject(object);
                    
                    objectStream.close();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
    
                fileStream.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
    }

    public Object loadObject(String filename)
    {
        filename += fileExtension;
        Object returnable = null;
        Object read;
        try
		{
			FileInputStream fileStream = new FileInputStream(filename);
			try
			{
				ObjectInputStream objectStream = new ObjectInputStream(fileStream);
                
                read = objectStream.readObject();
                returnable = (read.type)read;
				
				objectStream.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

        fileStream.close();
        return returnable;
	}
    }

}