package datamanagement;


public class DataNode
{
    public String name;
    public Double value;

    public DataNode(String name, double value)
    {
        this.name = name;
        this.value = value;
    }


    public DataNode(Service service, Integer value)
    {
        this.name = service.name;
        this.value.parseDouble(value.toString());
    }

}
