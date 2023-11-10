package test7;

/**
 * Program Description: to demonstrate a GUI for payment by Duitnow.
 *
 * @author (NURANIS SABRINA BINTI KAMARUL AZLAN)
 * @date(20/10/2023)
 */
//import packages from the java awt 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//driver method
public class Duitnow extends JFrame implements ActionListener
{
    //private variables declaration
    private ImageIcon sunway;
    private ImageIcon qr;
    private ImageIcon duitnow;
    private JLabel instructionLabel;
    private JLabel sunwayLabel;
    private JLabel qrLabel;
    private JLabel duit;
    private JButton success;
    private JButton change;
    private Color sColor;
    private Color cColor;
    private JPanel panel;
    private Color pColor;
    private Container cont;
    private JPanel topPanel;
    private Color tColor;
    private int counternumber;
    private JLabel lblNewLabel;
    //constructor without parameter
    public Duitnow(int counternumber)
    {
        //to create and and declared a window named payment by Duitnow using the JFrame constructor
        super(" PAYMENT BY DUITNOW ");
        this.counternumber = counternumber;

        // get content pane and set its layout
        cont = getContentPane();
        getContentPane().setLayout(null);

        //set up a instruction label
        instructionLabel = new JLabel(" SCAN THE QR IN THE BELOW TO PAY ");

        //to set up an icon 
        //sunway lagoon logo
        sunway = new ImageIcon("C:SunwayLagoon.png");
        //Qr code to pay by scan it 
        qr = new ImageIcon("C:qr.png");
        //duitnow logo
        duitnow = new ImageIcon("C:Duitnow.png");

        //to set up JLabel with the imageicon
        //sunway
        sunwayLabel = new JLabel(new ImageIcon(Duitnow.class.getResource("/pic/SunwayLagoon.png")));
        //qr
        qrLabel = new JLabel(new ImageIcon(Duitnow.class.getResource("/pic/qr.png")));
        //duitnow
        duit = new JLabel(new ImageIcon(Duitnow.class.getResource("/pic/Duitnow.png")));

        //create JButton
        //successful paymentbutton
        success = new JButton("PRINT RECEIPT");
        //change payment method button
        change = new JButton(" CHANGE PAYMENT METHOD ");

        //to custom all button
        sColor = new Color(0,197,23); //green grass
        cColor = new Color(65,105,225); //royal blue

        //to set up setBackground 
        success.setBackground(sColor);
        change.setBackground(cColor);

        //create panel
        panel = new JPanel();
        //to custome panel color 
        pColor = new Color (241, 115, 31);//blue sky
        //setBackground using JPanel
        panel.setBackground(pColor);

        //set up top panel
        topPanel = new JPanel();
        //topPanel color
        tColor = new Color(255, 210, 143); //yellow sun
        //setBackground using JPanel
        topPanel.setBackground(tColor);

        //using setBounds to  specify the component's position and size
        qrLabel.setBounds(230,140,420,420);
        sunwayLabel.setBounds(20,1,100,100);
        duit.setBounds(100,1,100,100);
        success.setBounds(520,480,200,30);
        change.setBounds(150,480,200,30);
        instructionLabel.setBounds(330,30,300,40);
        topPanel.setBounds(0,0,900,100);
        panel.setBounds(0,100,900,700);
        panel.setLayout(null);

        //to add the components to the container or frame 
        getContentPane().add(qrLabel);
        getContentPane().add(sunwayLabel);
        getContentPane().add(duit);
        getContentPane().add(panel);
        cont.add(instructionLabel);
        panel.add(success);
        panel.add(change);

        //create a new label
        lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(321, 54, 45, 13);
        panel.add(lblNewLabel);
        getContentPane().add(topPanel);
        topPanel.setLayout(null);

        // to register an action listener to the button component
        success.addActionListener(this);
        change.addActionListener(this);

        //set frame size 
        setSize(900,700);
        //to make the frame visible on the screen 
        setVisible(true);
        //set frame location to the center of the screen 
        setLocationRelativeTo(null);
        //to terminate application and exit the program when the user closes the frame
        setDefaultCloseOperation (EXIT_ON_CLOSE);        
    }//end of constructor
    //method to handle action events
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == success) 
        {
            dispose();
            CounterGui.refreshTableCustomer();
            CounterGui.displayCountCustomer();
            // replace the current frame to the new one 
            String paymentMethod = "Duitnow QR";
            try {
                //using if method for each counter 
                //for counter 1
                if (counternumber == 1) {
                    CustomerInformation customerInformation = CounterGui.getQueueCounter1().remove();
                    new Receipt(customerInformation.getCustId(),
                        customerInformation.getCustName(),
                        customerInformation.getRideName(),
                        customerInformation.getTicketPrice(),
                        customerInformation.getQuantity(),
                        customerInformation.getDate(), paymentMethod); // the new frame
                    CounterGui.getCompleteStack().add(customerInformation);
                } 
                //for counter 2
                else if (counternumber == 2) {
                    CustomerInformation customerInformation = CounterGui.getQueueCounter2().remove();
                    new Receipt(customerInformation.getCustId(),
                        customerInformation.getCustName(),
                        customerInformation.getRideName(),
                        customerInformation.getTicketPrice(),
                        customerInformation.getQuantity(),
                        customerInformation.getDate(), paymentMethod); // the new frame
                    CounterGui.getCompleteStack().add(customerInformation);
                    // CounterGui.getQueueCounter2().remove();
                } 
                //for counter 3
                else if (counternumber == 3) {
                    CustomerInformation customerInformation = CounterGui.getQueueCounter3().remove();
                    new Receipt(customerInformation.getCustId(),
                        customerInformation.getCustName(),
                        customerInformation.getRideName(),
                        customerInformation.getTicketPrice(),
                        customerInformation.getQuantity(),
                        customerInformation.getDate(), paymentMethod); // the new frame
                    CounterGui.getCompleteStack().add(customerInformation);
                    // CounterGui.getQueueCounter3().remove();
                }

                CounterGui.refreshTableCustomer();
                CounterGui.displayCountCustomer();
            } catch (Exception e2) {
                //display a message if no customer
                JOptionPane.showMessageDialog(null, "No customer at the counter", "No customer",
                    JOptionPane.INFORMATION_MESSAGE);
                e2.printStackTrace();
            }
            CounterGui.refreshTableCustomer();
            CounterGui.displayCountCustomer();
        }
        else if (e.getSource() == change)
        {
            //to change payment method 
            //close the current frame
            dispose();
        }
        else 
        {
            //close the current frame
            dispose();
        }//end of if
    }//end of method
}