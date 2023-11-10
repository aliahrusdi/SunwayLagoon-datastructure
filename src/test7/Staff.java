package test7;

/**
 * Program Description: Easy method class for staff members.
 *
 * Name: NUR IZZAH THAQIFFAH
 * Date: 22/10/2023
 */

public class Staff
{
    private String name, id;
    
    public Staff(String name, String id)
    {
        this.name = name;
        this.id = id;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setID(String id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getID()
    {
        return id;
    }
}