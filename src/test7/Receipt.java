package test7;

/* Program Description: to demonstrate a GUI for receipt after customer making the payment.
*
* @author (NUR ALIAH BINTI RUSDI)
* @date(20/10/2023)
*/

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Receipt {

	private JFrame frmReceipt;
	private String custId;
    private String custName;
    private String rideName;
    private int ticketPrice;
    private int quantity;
    private String purchaseDate;
    private String paymentMethod;
	/**
	 * Create the application.
	 */
	public Receipt(String custId, String custName, String rideName, int ticketPrice, int quantity, String purchaseDate, String paymentMethod ) {
		this.custId = custId;
        this.custName = custName;
        this.rideName = rideName;
        this.ticketPrice = ticketPrice;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.paymentMethod = paymentMethod;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// frame title
		frmReceipt = new JFrame();
		frmReceipt.setTitle("Receipt");
		frmReceipt.setBounds(100, 100, 510, 650);
		frmReceipt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmReceipt.getContentPane().setLayout(null);
		
		// top colour
		JPanel tColor = new JPanel();
		tColor.setBackground(new Color(255, 210, 143));
		tColor.setBounds(0, 0, 496, 93);
		frmReceipt.getContentPane().add(tColor);
		tColor.setLayout(null);
		
		// tajuk
		JLabel treceipt = new JLabel("RECEIPT");
		treceipt.setFont(new Font("Impact", Font.PLAIN, 27));
		treceipt.setBounds(205, 58, 94, 25);
		tColor.add(treceipt);
		
		// set time / date ikut waktu sekarang
		LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timePattern = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedDate = myDateObj.format(datePattern);
        String formattedTime = myDateObj.format(timePattern);
		
        // date sekarang
		JLabel date = new JLabel("Date : " + formattedDate);
		date.setBounds(347, 48, 99, 13);
		tColor.add(date);
		
		// time sekarang
		JLabel time = new JLabel("Time : " + formattedTime );
		time.setBounds(347, 71, 84, 13);
		tColor.add(time);
		
		// gambar logo
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Receipt.class.getResource("/pic/SunwayLagoon.png")));
		logo.setBounds(10, 5, 214, 78);
		tColor.add(logo);
		
		// bottom colour
		JPanel bColor = new JPanel();
		bColor.setBackground(new Color(241, 115, 31));
		bColor.setBounds(0, 93, 496, 520);
		frmReceipt.getContentPane().add(bColor);
		bColor.setLayout(null);
		
		// tekan button close
		JButton nextCust = new JButton("CLOSE");
		nextCust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// receipt dispose
				frmReceipt.dispose();
			}
		});
		// button close
		nextCust.setBackground(new Color(240, 230, 140));
		nextCust.setBounds(289, 463, 177, 21);
		bColor.add(nextCust);
		
		// cust id
		JLabel id = new JLabel("Customer Id : " + this.custId);
		id.setBounds(10, 65, 456, 13);
		bColor.add(id);
		
		// cust name
		JLabel name = new JLabel("Customer Name :" + this.custName);
		name.setBounds(10, 88, 456, 13);
		bColor.add(name);
		
		// purchase date
		JLabel pdate = new JLabel("Purchase Date :" + this.purchaseDate);
		pdate.setBounds(10, 111, 456, 13);
		bColor.add(pdate);
		
		// separator
		JPanel secpanel = new JPanel();
		secpanel.setBackground(new Color(255, 218, 185));
		secpanel.setBounds(10, 134, 456, 4);
		bColor.add(secpanel);
		
		// panel 2
		JPanel tPanel = new JPanel();
		tPanel.setBackground(new Color(255, 218, 185));
		tPanel.setBounds(10, 51, 456, 4);
		bColor.add(tPanel);
		
		// ride name
		JLabel rname = new JLabel("Ride Name :" + this.rideName);
		rname.setBounds(10, 148, 456, 13);
		bColor.add(rname);
		
		// quantity
		JLabel rquantity = new JLabel("Quantity :" + this.quantity);
		rquantity.setBounds(10, 171, 456, 13);
		bColor.add(rquantity);
		
		// price
		JLabel rprice = new JLabel("Price Ride :" + this.ticketPrice);
		rprice.setBounds(10, 194, 456, 13);
		bColor.add(rprice);
		
		// payment method
		JLabel rpayment = new JLabel("Payment Method :" + this.paymentMethod);
		rpayment.setBounds(10, 217, 456, 13);
		bColor.add(rpayment);
		
		// 3 panel
		JPanel thpanel = new JPanel();
		thpanel.setBackground(new Color(255, 218, 185));
		thpanel.setBounds(10, 240, 456, 4);
		bColor.add(thpanel);
		
		// dapatkan subtotal
		double subtotalvalue = quantity * ticketPrice;
		JLabel SubTotal = new JLabel("Subtotal :" + subtotalvalue);
		SubTotal.setBounds(10, 254, 456, 13);
		bColor.add(SubTotal);
		
		// dapatkan tax = sub * 0.6
		double taxvalue = subtotalvalue * 0.6;
		JLabel Tax = new JLabel("Tax :" + taxvalue);
		Tax.setBounds(10, 277, 456, 13);
		bColor.add(Tax);
		
		// final amount = tax + sub
		double totalwithtax = subtotalvalue + taxvalue;
		JLabel TotalAmount = new JLabel("Total Amount :" + totalwithtax);
		TotalAmount.setBounds(10, 300, 456, 13);
		bColor.add(TotalAmount);
		
		// 4 panel
		JPanel fpanel = new JPanel();
		fpanel.setBackground(new Color(255, 218, 185));
		fpanel.setBounds(10, 323, 456, 4);
		bColor.add(fpanel);
		
		// thank you label
		JLabel tenks = new JLabel("Thank you for your visit at Sunway Lagoon !");
		tenks.setBounds(121, 341, 345, 13);
		bColor.add(tenks);
		
		// another label
		JLabel come = new JLabel("Please come again");
		come.setBounds(188, 364, 278, 13);
		bColor.add(come);
		
		// 5 panel
		JPanel fifpanel = new JPanel();
		fifpanel.setBackground(new Color(255, 218, 185));
		fifpanel.setBounds(10, 387, 456, 4);
		bColor.add(fifpanel);
		frmReceipt.setVisible(true);
		
	}
}