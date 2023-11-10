package test7;
/**
 * Program Description: to demonstrate a GUI for payment by cash.
 *
 * @author (NUR ALIAH BINTI RUSDI)
 * @date(20/10/2023)
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;

public class Cash implements ActionListener
{
    private JFrame PaymentCash;
    private JButton proceed;
    private JButton change;
    private JTextField textField;
    private int counternumber;
    private double totalwithtax;

    /**
     * Create the application.
     */
    public Cash(int counternumber) 
    {
    	this.counternumber = counternumber;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    // untuk dapatkan subtotal dari setiap counter
 	// total customer dengan quantity
    private double getSubTotalValue(int counternumber) {
		double subtotalvalue = 0;
		switch (counternumber) {
		case 1:
			subtotalvalue = CounterGui.getQueueCounter1().peek().getQuantity()
					* CounterGui.getQueueCounter1().peek().getTicketPrice();
			break;
		case 2:
			subtotalvalue = CounterGui.getQueueCounter2().peek().getQuantity()
					* CounterGui.getQueueCounter2().peek().getTicketPrice();
			break;
		case 3:
			subtotalvalue = CounterGui.getQueueCounter3().peek().getQuantity()
					* CounterGui.getQueueCounter3().peek().getTicketPrice();
			break;
		default:
			break;
		}
		return subtotalvalue;
	}
    
    private void initialize() 
    {
        //frame title
        PaymentCash = new JFrame();
        PaymentCash.setTitle("Cash");
        PaymentCash.setBounds(100, 100, 692, 354);
        PaymentCash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PaymentCash.getContentPane().setLayout(null);
        
        // top panel colour
        JPanel tColor = new JPanel();
        tColor.setBackground(new Color(255, 210, 143)); // colour nanti tukar - background
        tColor.setBounds(0, 0, 678, 64);
        PaymentCash.getContentPane().add(tColor);
        tColor.setLayout(null);
        
        // total amount display label
        JLabel titleLabel = new JLabel("- CASH PAYMENT -");
        titleLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 21));
        titleLabel.setBounds(313, 20, 230, 34);
        tColor.add(titleLabel);
        
        // logo
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Cash.class.getResource("/pic/SunwayLagoon.png")));
        lblNewLabel_1.setBounds(10, 0, 211, 67);
        tColor.add(lblNewLabel_1);
        
        // bottom colour
        JPanel bColor = new JPanel();
        bColor.setBackground(new Color(241, 115, 31)); // colour nanti tukar - background
        bColor.setBounds(0, 62, 678, 255);
        PaymentCash.getContentPane().add(bColor);
        bColor.setLayout(null);
        
        // next button
        proceed = new JButton("NEXT");
        proceed.setBackground(new Color(255, 210, 143)); // colour nanti tukar - button
        proceed.setBounds(524, 208, 144, 21);
        bColor.add(proceed);
        
        // change payment method button
        change = new JButton("CHANGE PAYMENT METHOD");
        change.setBackground(new Color(255, 210, 143)); // colour nanti tukar - button 
        change.setBounds(10, 208, 214, 21);
        bColor.add(change);
        
        // kira subtotal 
        double subtotalvalue = getSubTotalValue(counternumber);
        JLabel subtotal = new JLabel("Subtotal : RM" + subtotalvalue);
        subtotal.setBounds(52, 28, 576, 13);
        bColor.add(subtotal);
        
        // kira tax = sub * 0.6
        double taxvalue = subtotalvalue * 0.6;
        JLabel taxAmount = new JLabel("Tax : " + taxvalue);
        taxAmount.setBounds(52, 51, 576, 13);
        bColor.add(taxAmount);
        
        // separator
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 210, 143));
        panel.setBounds(26, 104, 629, 10);
        bColor.add(panel);
        
        // kira total amount
        double totalwithtax = subtotalvalue + taxvalue;
        this.totalwithtax = totalwithtax;
        JLabel totAmount = new JLabel("Total Amount : RM " + totalwithtax);
        totAmount.setBounds(52, 81, 576, 13);
        bColor.add(totAmount);
        
        // masukkan nilai berapa cust bagi
        textField = new JTextField();
        textField.setBounds(52, 167, 172, 19);
        bColor.add(textField);
        textField.setColumns(10);
        
        // instruction label1
        JLabel instruc1 = new JLabel("PLEASE ENTER THE AMOUNT");
        instruc1.setBounds(52, 144, 603, 13);
        bColor.add(instruc1);
        
        // to register an action listener to the button component
        proceed.addActionListener(this);
        change.addActionListener(this);
        
        //to make the frame visible on the screen 
        PaymentCash.setVisible(true);
        
        //set frame location to the center of the screen 
        PaymentCash.setLocationRelativeTo(null);
    }
    
    //method to handle action events
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == proceed) 
        {
        	try {
        		double enteredamount = Double.parseDouble(textField.getText());
            	if(enteredamount < totalwithtax) {
            		// kalau bagi lagi sikit dari total amount
            		JOptionPane.showMessageDialog(null, "Entered amount is below than total",
        					"Insufficient Amount", JOptionPane.WARNING_MESSAGE);
            		return;
            	}
            	// kalau ada balance / cust bagi lebih
            	JOptionPane.showMessageDialog(null, "Balance : RM" + (enteredamount - totalwithtax),
    					"Balance", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e2) {
				// kalau patut tulis no tapi tulis huruf
				JOptionPane.showMessageDialog(null, e2.getMessage(),
    					"ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
        	
            PaymentCash.dispose();
            
            // kalau tekan print receipt
            CounterGui.refreshTableCustomer();
			CounterGui.displayCountCustomer();
            String paymentMethod = "Cash";
            try {
				if (counternumber == 1) {
					CustomerInformation customerInformation = CounterGui.getQueueCounter1().remove();
					new Receipt(customerInformation.getCustId(),
							customerInformation.getCustName(),
							customerInformation.getRideName(),
							customerInformation.getTicketPrice(),
							customerInformation.getQuantity(),
							customerInformation.getDate(), paymentMethod); // the new frame
					CounterGui.getCompleteStack().add(customerInformation);
				} else if (counternumber == 2) {
					CustomerInformation customerInformation = CounterGui.getQueueCounter2().remove();
					new Receipt(customerInformation.getCustId(),
							customerInformation.getCustName(),
							customerInformation.getRideName(),
							customerInformation.getTicketPrice(),
							customerInformation.getQuantity(),
							customerInformation.getDate(), paymentMethod); // the new frame
					CounterGui.getCompleteStack().add(customerInformation);
					// CounterGui.getQueueCounter2().remove();
				} else if (counternumber == 3) {
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
				// kalau counter kosong = kena add
				JOptionPane.showMessageDialog(null, "No customer at the counter", "No customer",
						JOptionPane.INFORMATION_MESSAGE);
			}
            CounterGui.refreshTableCustomer();
			CounterGui.displayCountCustomer();
        }
        
        
        else if (e.getSource() == change)
        {
            PaymentCash.dispose();
            //paymentMethodFrame paymentFrame = new paymentMethodFrame();
            //paymentFrame.setVisible(true);
        }
        

        else 
        {
            PaymentCash.dispose();
        }//end of if
    }//end of method
}
