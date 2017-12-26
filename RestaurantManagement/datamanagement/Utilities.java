package datamanagement;

import tables.*;

import java.io.*;
import java.util.Vector;

public class Utilities
{
        // this class contains saving and loading methods for data
        // there is a problem if filename is changed
        // also file names may be encrypted
        // especially data itself

        public static String fileExtension = ".txt";          // can be changed into an enumeration later if need arises

        public static void saveServiceVector(Vector<Service> object, String filename)
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

    public static void saveStringVector(Vector<String> object, String filename)
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

    public static void saveDayVector(Vector<Day> object, String filename)
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

    public static void saveWallVector(Vector<Wall> object, String filename)
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

    public static void saveTableVector(Vector<Table> object, String filename)
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

        //--------------------------------------------------------------
        // load methods

        public static Vector<Service> loadServiceVector(String filename)
        {
            filename += fileExtension;
            Vector<Service> returnable = null;
            Vector<Service> read;
            try
            {
                FileInputStream fileStream = new FileInputStream(filename);
                try
                {
                    ObjectInputStream objectStream = new ObjectInputStream(fileStream);

                    read = (Vector)objectStream.readObject();
                    returnable = read;

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

            return returnable;
        }

    public static Vector<String> loadStringVector(String filename)
    {
        filename += fileExtension;
        Vector<String> returnable = null;
        Vector<String> read;
        try
        {
            FileInputStream fileStream = new FileInputStream(filename);
            try
            {
                ObjectInputStream objectStream = new ObjectInputStream(fileStream);

                read = (Vector)objectStream.readObject();
                returnable = read;

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

        return returnable;
    }

    public static Vector<Day> loadDayVector(String filename)
    {
        filename += fileExtension;
        Vector<Day> returnable = null;
        Vector<Day> read;
        try
        {
            FileInputStream fileStream = new FileInputStream(filename);
            try
            {
                ObjectInputStream objectStream = new ObjectInputStream(fileStream);

                read = (Vector)objectStream.readObject();
                returnable = read;

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

        return returnable;
    }

    public static Vector<Wall> loadWallVector(String filename)
    {
        filename += fileExtension;
        Vector<Wall> returnable = null;
        Vector<Wall> read;
        try
        {
            FileInputStream fileStream = new FileInputStream(filename);
            try
            {
                ObjectInputStream objectStream = new ObjectInputStream(fileStream);

                read = (Vector)objectStream.readObject();
                returnable = read;

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

        return returnable;
    }

    public static Vector<Table> loadTableVector(String filename)
    {
        filename += fileExtension;
        Vector<Table> returnable = null;
        Vector<Table> read;
        try
        {
            FileInputStream fileStream = new FileInputStream(filename);
            try
            {
                ObjectInputStream objectStream = new ObjectInputStream(fileStream);

                read = (Vector)objectStream.readObject();
                returnable = read;

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

        return returnable;
    }
}
