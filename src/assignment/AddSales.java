package assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddSales extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtItem;
	private JTextField txtPrice;
	private JTextField txtQuantity;
	private JTextField txtDay;
	private JTextField txtMonth;
	private JTextField txtYear;
	private JTextField txtCustomerName;
	private JTextField txtCustomerAddress;
	private JTextField txtCustomerContact;
	private JButton btnAdd;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSales frame = new AddSales();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddSales() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddSales = new JLabel("Add Sales");
		lblAddSales.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddSales.setBounds(166, 10, 126, 49);
		contentPane.add(lblAddSales);
		
		txtItem = new JTextField();
		txtItem.setText("Item");
		txtItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtItem.setBounds(49, 62, 216, 25);
		contentPane.add(txtItem);
		txtItem.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setText("Price");
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPrice.setColumns(10);
		txtPrice.setBounds(49, 97, 216, 25);
		contentPane.add(txtPrice);
		
		txtQuantity = new JTextField();
		txtQuantity.setText("Quantity");
		txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(49, 132, 216, 25);
		contentPane.add(txtQuantity);
		
		txtDay = new JTextField();
		txtDay.setText("Day");
		txtDay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDay.setColumns(10);
		txtDay.setBounds(49, 167, 216, 25);
		contentPane.add(txtDay);
		
		txtMonth = new JTextField();
		txtMonth.setText("Month");
		txtMonth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMonth.setColumns(10);
		txtMonth.setBounds(49, 208, 216, 25);
		contentPane.add(txtMonth);
		
		txtYear = new JTextField();
		txtYear.setText("Year");
		txtYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtYear.setColumns(10);
		txtYear.setBounds(282, 62, 216, 25);
		contentPane.add(txtYear);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setText("Customer Name");
		txtCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCustomerName.setColumns(10);
		txtCustomerName.setBounds(282, 102, 216, 25);
		contentPane.add(txtCustomerName);
		
		txtCustomerAddress = new JTextField();
		txtCustomerAddress.setText("Customer Address");
		txtCustomerAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCustomerAddress.setColumns(10);
		txtCustomerAddress.setBounds(282, 137, 216, 25);
		contentPane.add(txtCustomerAddress);
		
		txtCustomerContact = new JTextField();
		txtCustomerContact.setText("Customer Contact");
		txtCustomerContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCustomerContact.setColumns(10);
		txtCustomerContact.setBounds(282, 172, 216, 25);
		contentPane.add(txtCustomerContact);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// take the textfield value;
				String name = txtItem.getText();
				String SP = Account.UID;
			    double price = Double.parseDouble(txtPrice.getText());
			    int quantity = Integer.parseInt(txtQuantity.getText());
			    int day = Integer.parseInt(txtDay.getText());
			    int month = Integer.parseInt(txtMonth.getText());
			    int year = Integer.parseInt(txtYear.getText());
			    String customerName = txtCustomerName.getText();
			    String customerAddress = txtCustomerAddress.getText();
			    String customerContact = txtCustomerContact.getText();

				Sales obj1 = new Sales(name,  SP,price, quantity, day,  month,  year,  customerName,  customerAddress,  customerContact); 
				Validation validator = new Validation();
				boolean itemname_b = validator.validate(name,"name");
				boolean customerName_b = validator.validate(customerName,"name");
				boolean customerContact_b = validator.validate(customerContact,"contact");
				if (itemname_b == true && customerName_b == true && customerContact_b == true) {
					String message = obj1.insertData();
	                JOptionPane.showMessageDialog(AddSales.this, message);
				}else {
	                JOptionPane.showMessageDialog(null, "Invalid itemname or customername or customercontact");

				}


			}

				
			
		});
		btnAdd.setBounds(66, 269, 85, 21);
		contentPane.add(btnAdd);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(220, 269, 85, 21);
		contentPane.add(btnClose);
	}
}
