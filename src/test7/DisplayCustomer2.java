package test7;

/**
 * Program description : a GUI for display customer counter 2
 *
 * Name: Nuranis sabrina binti kamarul azlan
 * Date: 20/10/2023
 */
//import packages from the Java AWT
import java.awt.EventQueue;
import java.util.Iterator;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//driver method
public class DisplayCustomer2 extends JFrame{
    //private variables declaration
    private final JPanel panel = new JPanel();
    private static JTable table;
    private JScrollPane scrollPane;
    private JButton btnNewButton;
    //to set the display tablefor customer counter 2
    public DisplayCustomer2(String titleFrame, int counternumber) {
        initialize(titleFrame, counternumber);
    }

     //Initialize the contents of the frame.
    private void initialize(String titleFrame, int counternumber) {
        setBounds(100, 100, 615, 463);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        panel.setBounds(0, 0, 601, 426);
        getContentPane().add(panel);
        panel.setLayout(null);
        setTitle(titleFrame);

        scrollPane = new JScrollPane();// create scrollpanel
        scrollPane.setBounds(10, 10, 581, 248);
        panel.add(scrollPane);

        table = new JTable();//create table
        scrollPane.setViewportView(table);//viewable content within the scrollpane

        btnNewButton = new JButton("Pay");//create button
        btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //display a message if no customer
                    if(CounterGui.getQueueCounter2().size() < 1) {
                    	// no customer
                        JOptionPane.showMessageDialog(null, "No customer at the counter", "No customer", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    // to choose payment method every counter
                    if(counternumber == 1) {
                        new paymentMethodFrame(1);
                    } else if(counternumber == 2) {
                        new paymentMethodFrame(2);
                    } else if(counternumber == 3) {
                        new paymentMethodFrame(3);
                    }
                }
            });
        btnNewButton.setBounds(428, 360, 136, 21);
        panel.add(btnNewButton);

        displayCustomerTable(counternumber);
        setVisible(true);
    }

    public static void displayCustomerTable(int counternumber)
    {
        //create table model
        DefaultTableModel tableModel = new DefaultTableModel();
        String[] columnNames = {"CUSTOMER ID", "CUSTOMER NAME", "TICKET NAME", "TICKET PRICE"};
        for (String columnName : columnNames)
        {
            tableModel.addColumn(columnName);

        }

        if(counternumber == 1) {
            for (Iterator iterator = CounterGui.getQueueCounter1().iterator(); iterator.hasNext();) {
                CustomerInformation customer = (CustomerInformation) iterator.next();

                String customerId = customer.getCustId();
                String customerName = customer.getCustName();
                String ticketName = customer.getRideName();
                double ticketPrice = customer.getTicketPrice();

                Object[] rowData = {customerId, customerName, ticketName, ticketPrice};
                tableModel.addRow(rowData);

            }
        }else if(counternumber == 2) {
            for (Iterator iterator = CounterGui.getQueueCounter2().iterator(); iterator.hasNext();) {
                CustomerInformation customer = (CustomerInformation) iterator.next();

                String customerId = customer.getCustId();
                String customerName = customer.getCustName();
                String ticketName = customer.getRideName();
                double ticketPrice = customer.getTicketPrice();

                Object[] rowData = {customerId, customerName, ticketName, ticketPrice};
                tableModel.addRow(rowData);

            }
        }else if(counternumber == 3) {
            for (Iterator iterator = CounterGui.getQueueCounter3().iterator(); iterator.hasNext();) {
                CustomerInformation customer = (CustomerInformation) iterator.next();

                String customerId = customer.getCustId();
                String customerName = customer.getCustName();
                String ticketName = customer.getRideName();
                double ticketPrice = customer.getTicketPrice();

                Object[] rowData = {customerId, customerName, ticketName, ticketPrice};
                tableModel.addRow(rowData);

            }
        }//end of if 

        table.setModel(tableModel);
    }//end of method
}//end of method