package test7;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Queue;

public class CounterGui extends JFrame 
{
    private static JLabel lblCustomerCount;
    private static JLabel lblCounter1;
    private static JLabel lblCounter2;
    private static JLabel lblCounter3;
    private JButton btnAdd;
    private JButton btnNext;
    private JButton btnDispComplete;
    private static Container cont;

    //Anis's part
    private static DisplayCustomer dispObj1 = null;
    private static DisplayCustomer2 dispObj2 = null;
    private static DisplayCustomer3 dispObj3 = null;
    private static int customersComplete = 0;

    private static LinkedList<CustomerInformation> customerList;
    private static Queue<CustomerInformation> counter1Queue;
    private static Queue<CustomerInformation> counter2Queue;
    private static Queue<CustomerInformation> counter3Queue;

    //Aliah's part
    Stack<CustomerInformation> customerStack = new Stack<>();
    private static Stack<CustomerInformation> completeStack = new Stack<>();

    public static Stack<CustomerInformation> getCompleteStack() {
        return completeStack;
    }

    public static Queue<CustomerInformation> getQueueCounter1() {
        return counter1Queue;
    }

    public static Queue<CustomerInformation> getQueueCounter2() {
        return counter2Queue;
    }

    public static Queue<CustomerInformation> getQueueCounter3() {
        return counter3Queue;
    }

    //Izzah's part
    public CounterGui() 
    {
        super("Counter");

        cont = getContentPane();
        cont.setLayout(new GridBagLayout());
        cont.setBackground(Color.WHITE);

        customerList = generateCustomerList();
        counter1Queue = new LinkedList<>();
        counter2Queue = new LinkedList<>();
        counter3Queue = new LinkedList<>();

        lblCustomerCount = new JLabel("Customers: " + customerList.size());

        lblCounter1 = new JLabel("Counter 1: 0 customers");
        lblCounter2 = new JLabel("Counter 2: 0 customers");
        lblCounter3 = new JLabel("Counter 3: 0 customers");

        btnAdd = new JButton("Add");
        btnNext = new JButton("Next");
        btnDispComplete = new JButton("Completed Customer");

        btnAdd.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    counterLimit();
                }
            });

        //aliah's part
        // guna static variable
        // jadi semua frame access kat situ  dapat kira semua ada data yang sama
        btnDispComplete.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                {
                    new DisplayCompleteStack();
                }
            });
        //anis's part
        btnNext.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                	displayCountCustomer();
                    if (counter1Queue.size() > 0 || counter2Queue.size() > 0 || counter3Queue.size() > 0) {
                        // Anis's part
                        if (dispObj1 == null) {
                            dispObj1 = new DisplayCustomer("Counter 1", 1);
                            dispObj1.setVisible(true);
                        } else {
                            dispObj1.setVisible(true);
                        }

                        if (dispObj2 == null) {
                            dispObj2 = new DisplayCustomer2("Counter 2", 2);
                            dispObj2.setVisible(true);
                        } else {
                            dispObj2.setVisible(true);
                        }

                        if (dispObj3 == null) {
                            dispObj3 = new DisplayCustomer3("Counter 3", 3);
                            dispObj3.setVisible(true);
                        } else {
                            dispObj3.setVisible(true);
                        }

                        refreshTableCustomer();
                    } else {
                        JOptionPane.showMessageDialog(cont, "There are no customer in the counter!", "No Customer",
                            JOptionPane.WARNING_MESSAGE);
                    }
                }
            });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        cont.add(lblCustomerCount, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        cont.add(lblCounter1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        cont.add(lblCounter2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        cont.add(lblCounter3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        cont.add(btnAdd, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        cont.add(btnNext, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        cont.add(btnDispComplete, gbc);

        setSize(400, 350);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // function untuk update berapa lagi customer yang tinggal untuk setiap frame 3 counter
    public static void refreshTableCustomer() 
    {
        DisplayCustomer.displayCustomerTable(1);
        DisplayCustomer2.displayCustomerTable(2);
        DisplayCustomer3.displayCustomerTable(3);
    }

    //Generates a list of customers from the input file
    private LinkedList<CustomerInformation> generateCustomerList() 
    {
        LinkedList<CustomerInformation> customerList = new LinkedList<>();

        try 
        {
            //Create a BufferedReader to read the customer data from the file
            BufferedReader reader = new BufferedReader(new FileReader("customerList.txt"));
            String data;

            //Create a map to store customers using their IDs
            Map<String, CustomerInformation> customerMap = new HashMap<>();

            int no = 1;
            while ((data = reader.readLine()) != null) 
            {
                no++;
                String[] parts = data.split(";");

                if (parts.length == 6) 
                {
                    //Extract customer information from the parts
                    String custId = parts[0];
                    String custName = parts[1];
                    String rideName = parts[2];
                    int ticketPrice = Integer.parseInt(parts[3]);
                    int quantity = Integer.parseInt(parts[4]);
                    String purchaseDate = parts[5];

                    //Check if the customer already exists in the map
                    CustomerInformation customer = customerMap.get(custId);
                    if (customer == null) 
                    {
                        //If the customer doesn't exist, create a new CustomerInformation object
                        customer = new CustomerInformation(custId, custName, rideName, ticketPrice, quantity, purchaseDate);

                        //Add the customer to the customer map and the customer list
                        customerMap.put(custId, customer);
                        customerList.add(customer);
                    }
                } else {
                    //errors for data that arent in format
                    System.out.println("ERROR IN TXT FILE AT LINE: " + no);
                }
            }

            reader.close();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        // Return the list of customer information
        return customerList;
    }

    String line;
    BufferedReader reader = new BufferedReader(readCustomer());

    private FileReader readCustomer() 
    {
        try {
            return new FileReader("customerList.txt");
        } catch (Exception e) {
            return null;
        }
    }

    //A method that assigns customers to counters
    private void counterLimit() 
    {
        int customersToAssign = 5;

        //Check if there are enough customers to assign
        if (customerList.size() < customersToAssign) 
        {
            JOptionPane.showMessageDialog(cont, "There are not enough customers to assign to the counters!",
                "Insufficient Customers", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //Check if any counters are already serving customers
        if (counter1Queue.size() > 0 || counter2Queue.size() > 0 || counter3Queue.size() > 0) 
        {
            JOptionPane.showMessageDialog(cont, "Please finish serving the previous customers before proceeding!",
                "Counter Full!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //Create a map to count how many times each customer ID has appeared
        Map<String, Integer> customerIdCount = new HashMap<>();

        try 
        {
            int customersAssigned = 0;
            //Read lines from the customer data file and assign customers to counters
            while ((line = reader.readLine()) != null && customersAssigned < customersToAssign * 3) 
            {
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    String custId = parts[0];
                    String custName = parts[1];
                    String rideName = parts[2];
                    int ticketPrice = Integer.parseInt(parts[3]);
                    int quantity = Integer.parseInt(parts[4]);
                    String purchaseDate = parts[5];

                    //Count how many times each customer ID has appeared
                    int idCount = customerIdCount.getOrDefault(custId, 0);

                    if (quantity > 5)
                    {
                        //More than 5, assign to Counter 3 
                        if (counter3Queue.size() < 5) 
                        {
                            counter3Queue.offer(new CustomerInformation(custId, custName, rideName, ticketPrice,
                                    quantity, purchaseDate));
                            customersAssigned++;
                            customersComplete++;
                        }
                    } 
                    else
                    {
                        //Less than or equal to 5, assign to Counter 1 and 2
                        if (counter1Queue.size() < 5) 
                        {
                            counter1Queue.offer(new CustomerInformation(custId, custName, rideName, ticketPrice,
                                    quantity, purchaseDate));
                            customersAssigned++;
                            customersComplete++;
                        } else if (counter2Queue.size() < 5)
                        {
                            counter2Queue.offer(new CustomerInformation(custId, custName, rideName, ticketPrice,
                                    quantity, purchaseDate));
                            customersAssigned++;
                            customersComplete++;
                        }
                    }

                    //Update the customer ID count
                    customerIdCount.put(custId, idCount + 1);
                }
            }
            //Call the method to update the counter display
            displayCountCustomer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayCountCustomer() 
    {
        lblCounter1.setText("Counter 1: " + counter1Queue.size() + " customers");
        lblCounter2.setText("Counter 2: " + counter2Queue.size() + " customers");
        lblCounter3.setText("Counter 3: " + counter3Queue.size() + " customers");
        lblCustomerCount.setText("Customers: " + (customerList.size() - customersComplete));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CounterGui());
    }
}