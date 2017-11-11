package datamanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserData
{
    public int maxUsers = 100;
    public String[] users;

    public UserData()
    {
        this.users  = new String[maxUsers];
    }


    public void save(String[] users) throws IOException
	{
		
		FileOutputStream fileStream = new FileOutputStream("users.txt");
	    ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
	    
		objectStream.writeObject(users);
		
		fileStream.close();
		objectStream.close();
	
	}
	
	public void load() throws IOException, ClassNotFoundException
	{
		FileInputStream fileStream = new FileInputStream("users.txt");
		ObjectInputStream objectStream = new ObjectInputStream(fileStream);

		this.users = (String[])objectStream.readObject();
		
		objectStream.close();
		fileStream.close();
    }
    
}