package test7;

/* Program Description: to store customer data after making a payment.
*
* @author (NUR ALIAH BINTI RUSDI)
* @date(20/10/2023)
*/

import java.awt.EventQueue;
import java.util.Iterator;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayCompleteStack extends JFrame {

	private final JPanel panel = new JPanel();
	private static JTable table;

	public DisplayCompleteStack() {
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 615, 463);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		panel.setBounds(0, 0, 601, 426);
		getContentPane().add(panel);
		panel.setLayout(null);
		setTitle("completeStack");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 581, 405);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		displayCustomerTable();
		setVisible(true);
	}

	public static void displayCustomerTable() {
		// create table model
		DefaultTableModel tableModel = new DefaultTableModel();
		String[] columnNames = { "CUSTOMER ID", "CUSTOMER NAME", "TICKET NAME"};
		for (String columnName : columnNames) {
			tableModel.addColumn(columnName);

		}

		for (Iterator iterator = CounterGui.getCompleteStack().iterator(); iterator.hasNext();) {
			CustomerInformation customer = (CustomerInformation) iterator.next();

			String customerId = customer.getCustId();
			String customerName = customer.getCustName();
			String ticketName = customer.getRideName();

			Object[] rowData = { customerId, customerName, ticketName };
			tableModel.addRow(rowData);

		}

		table.setModel(tableModel);
	}
}