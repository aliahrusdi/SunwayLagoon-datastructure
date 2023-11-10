package test7;

	/**
	 * Program Description: A class that holds and stores information about customers and tickets.
	 *
	 * Name: NUR IZZAH THAQIFFAH
	 * Date: 21/10/2023
	 */

	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.LinkedList;
	import java.util.StringTokenizer;

	public class CustomerInformation 
	{
	    private String custId;
	    private String custName;
	    private String rideName;
	    private int ticketPrice;
	    private int quantity;
	    private String purchaseDate;

	    public CustomerInformation(String custId, String custName, String rideName, int ticketPrice, int quantity, String purchaseDate) {
	        this.custId = custId;
	        this.custName = custName;
	        this.rideName = rideName;
	        this.ticketPrice = ticketPrice;
	        this.quantity = quantity;
	        this.purchaseDate = purchaseDate;
	    }

	    public String getCustId() 
	    {
	        return custId;
	    }

	    public String getCustName()
	    {
	        return custName;
	    }

	    public String getRideName() 
	    {
	        return rideName;
	    }

	    public int getTicketPrice() 
	    {
	        return ticketPrice;
	    }
	    
	    public int getQuantity()
	    {
	        return quantity;
	    }

	    public String getDate()
	    {
	        return purchaseDate;
	    }

	    public static LinkedList<CustomerInformation> readCustomerList() 
	    {
	        LinkedList<CustomerInformation> customerList = new LinkedList<>();

	        try 
	        {
	            BufferedReader customerReader = new BufferedReader(new FileReader("customerList.txt"));
	            String customerData;

	            while ((customerData = customerReader.readLine()) != null) {
	                StringTokenizer st = new StringTokenizer(customerData, ";");
	                String custId = st.nextToken();
	                String custName = st.nextToken();
	                String rideName = st.nextToken();
	                int ticketPrice = Integer.parseInt(st.nextToken());
	                int quantity = Integer.parseInt(st.nextToken());
	                String purchaseDate = st.nextToken();

	                CustomerInformation customer = new CustomerInformation(custId, custName,rideName, ticketPrice, quantity, purchaseDate);

	                customerList.add(customer);
	            }

	            customerReader.close();
	        } catch (IOException e) 
	        {
	            e.printStackTrace();
	        }

	        return customerList;
	    }
	}
