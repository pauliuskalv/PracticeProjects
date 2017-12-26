package datamanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class UserData
{
	public Vector<String> users;
	
	String userDataName = "UserData";

    public UserData()
    {
        this.users  = new Vector<String>();
    }

    public void save()
	{
		Utilities.saveStringVector(this.users, userDataName);
	}
	
	public void load()
	{
		this.users = Utilities.loadStringVector(userDataName);
    }
    
}