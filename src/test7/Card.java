package test7;

/**
 * Program Description: to demonstrate a GUI for payment by card.
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

public class Card implements ActionListener {
	private JFrame cardPayment;
	private JButton ppayment;
	private JButton change;
	private int counternumber;

	/**
	 * Create the application.
	 */
	public Card(int counternumber) {
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

	private void initialize() {
		// frame title
		cardPayment = new JFrame();
		cardPayment.setTitle("Card Payment");
		cardPayment.setBounds(100, 100, 650, 352);
		cardPayment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cardPayment.getContentPane().setLayout(null);

		// set top panel colour
		JPanel tColor = new JPanel();
		tColor.setBackground(new Color(255, 210, 143)); // yellow sun
		tColor.setBounds(0, 0, 734, 77);
		cardPayment.getContentPane().add(tColor);
		tColor.setLayout(null);

		// total amount label
		JLabel titleLabel = new JLabel("- CARD PAYMENT -");
		titleLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 21));
		titleLabel.setBounds(286, 24, 240, 43);
		tColor.add(titleLabel);
		
		// logo
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Card.class.getResource("/pic/SunwayLagoon.png")));
		lblNewLabel_2.setBounds(10, 0, 266, 67);
		tColor.add(lblNewLabel_2);

		// set bottom panel colour
		JPanel bColor = new JPanel();
		bColor.setBackground(new Color(241, 115, 31)); // blue sky
		bColor.setBounds(0, 73, 734, 242);
		cardPayment.getContentPane().add(bColor);
		bColor.setLayout(null);

		// button change payment method
		change = new JButton("CHANGE PAYMENT METHOD");
		change.setForeground(new Color(0, 0, 0));
		change.setBackground(new Color(255, 210, 143)); // green grass
		change.setBounds(34, 184, 207, 21);
		bColor.add(change);

		// button proceed payment method
		ppayment = new JButton("PRINT RECEIPT");
		ppayment.setBackground(new Color(255, 210, 143)); // royal blue
		ppayment.setBounds(452, 184, 150, 21);
		bColor.add(ppayment);

		// subtotal 
		double subtotalvalue = getSubTotalValue(counternumber);
		JLabel subtot = new JLabel("Subtotal : RM " + subtotalvalue);
		subtot.setBounds(34, 27, 568, 13);
		bColor.add(subtot);

		// tax = subtotal * 0.6
		double taxvalue = subtotalvalue * 0.6;
		JLabel tax = new JLabel("Tax :" + taxvalue);
		tax.setBounds(34, 50, 568, 13);
		bColor.add(tax);

		// final amount = subtotal + tax
		double totalwithtax = subtotalvalue + taxvalue;
		JLabel total = new JLabel("Total Amount : RM " + totalwithtax);
		total.setBounds(34, 73, 568, 13);
		bColor.add(total);
		
		// separator
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 250, 210));
		panel.setBounds(34, 96, 568, 4);
		bColor.add(panel);

		// instruction label 1
		JLabel instruc1 = new JLabel("- PLEASE PAY USING CREDIT OR DEBIT CARD ONLY");
		instruc1.setBounds(34, 116, 568, 13);
		bColor.add(instruc1);

		// instruction label 2
		JLabel instruc2 = new JLabel("- PLEASE WAVE YOUR CARD OR ENTER THE PIN");
		instruc2.setBounds(34, 139, 568, 13);
		bColor.add(instruc2);

		// to register an action listener to the button component
		ppayment.addActionListener(this);
		change.addActionListener(this);

		// to make the frame visible on the screen
		cardPayment.setVisible(true);

		// set frame location to the center of the screen
		cardPayment.setLocationRelativeTo(null);
	}

	// method to handle action events
	// display receipt ikut customer -> tambah customer dalam completeStack
	public void actionPerformed(ActionEvent e) {
		// kalau tekan print receipt
		if (e.getSource() == ppayment) {
			cardPayment.dispose();
			// receipPage(); //the new frame
			CounterGui.refreshTableCustomer();
			CounterGui.displayCountCustomer();
			String paymentMethod = "Card";
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
				JOptionPane.showMessageDialog(null, "No customer at the counter", "No customer",
						JOptionPane.INFORMATION_MESSAGE);
			}
			CounterGui.refreshTableCustomer();
			CounterGui.displayCountCustomer();

		}

		else if (e.getSource() == change) {
			// kalau tekan change payment method
			cardPayment.dispose();
			paymentMethodFrame paymentFrame = new paymentMethodFrame(counternumber);
			paymentFrame.setVisible(true);

		}

		else {
			cardPayment.dispose();
		} // end of if
	}// end of method
}
