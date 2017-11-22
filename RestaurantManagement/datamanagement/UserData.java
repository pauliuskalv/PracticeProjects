package datamanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserData
{
    public int maxUsers = 100;
	public String[] users;a
	
	String userDataName = "UserData";

    public UserData()
    {
        this.users  = new String[maxUsers];
    }


    public void save()
	{
		Utilities.saveObject(this.users, userDataName);
	}
	
	public void load()
	{
		this.users = Utilities.loadObject(userDataName);
    }
    
}