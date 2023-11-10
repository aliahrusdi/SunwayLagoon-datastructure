package test7;
/**
 * Program description : to demonstrate a GUI for payment method
 *
 * Name: Nuranis sabrina binti kamarul azlan
 * Date: 20/10/2023
 */
//import packages from the Java AWT 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Stack;
//driver method
public class paymentMethodFrame extends JFrame implements ActionListener 
{
    //declare private variables 
    private JButton payCash;
    private JButton payCard;
    private JButton payQr;
    private int counternumber;
    private JPanel panel;
    private Container cont;
    private Color pColor;
    private Color tColor;
    private JPanel top;
    private JLabel instruction;
    //constructor with parameter
    public paymentMethodFrame(int counternumber) 
    {
        //creates a window with the title
        super("PAYMENT METHOD");
        this.counternumber = counternumber;

        // get content pane and set its layout
        cont = getContentPane();
        getContentPane().setLayout(null);

        //create JPanel
        panel = new JPanel();
        panel.setLayout(null);
        // to custome panel color
        pColor = new Color(252, 106, 3); //orange
        // setBackground using JPanel
        panel.setBackground(pColor);
        panel.setBounds(0, 150, 900, 700);
        panel.setLayout(null);

        top = new JPanel();
        tColor = new Color(255,210,143); //gold
        //setBackground using JPanel
        top.setBackground(tColor);
        top.setBounds(0,0,900,150);

        //create instruction label
        instruction = new JLabel(" CHOOSE PAYMENT METHOD");
        instruction.setFont(new Font("October crow", Font.PLAIN, 30));
        instruction.setBounds(230,50,500,60);
        cont.add(instruction);

        // button
        payCash = new JButton("CASH");
        payCard = new JButton("CREDIT / DEBIT");
        payQr = new JButton("QR DUITNOW");

        // custom button
        payCash.setFont(new Font("Arial", Font.PLAIN, 18));
        payCard.setFont(new Font("Arial", Font.PLAIN, 18));
        payQr.setFont(new Font("Arial", Font.PLAIN, 18));

        // set bounds
        payCash.setBounds(330, 100, 200, 50);
        payCard.setBounds(330, 200, 200, 50);
        payQr.setBounds(330, 300, 200, 50);

        // add to panel
        panel.add(payCash);
        panel.add(payCard);
        panel.add(payQr);
        getContentPane().add(panel);
        getContentPane().add(top);

        // to register an action listener to the button component
        payCash.addActionListener(this);
        payCard.addActionListener(this);
        payQr.addActionListener(this);

        setSize(900, 700);
        // to make the frame visible on the screen
        setVisible(true);
        // set frame location to the center of the screen
        setLocationRelativeTo(null);
        // to terminate application and exit the program when the user closes the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//end of consturctor

    //override method
    //method to handle action events
    public void actionPerformed(ActionEvent e) 
    {
    	CounterGui.refreshTableCustomer();
		CounterGui.displayCountCustomer();
        if (e.getSource() == payCash) 
        {
            //aliah's part
            dispose();// close  current frame
            new Cash(counternumber);// new frame
        } 
        
        else if (e.getSource() == payCard)
        {
            //aliah's part
            dispose();//close current frame
            new Card(counternumber);//new frame
        } 
        
        else if (e.getSource() == payQr) 
        {
            dispose();//close current frame
            new Duitnow(counternumber);//new frame
        } 
        
        else 
        {
            dispose();
        }//end of if
    }//end of method
}