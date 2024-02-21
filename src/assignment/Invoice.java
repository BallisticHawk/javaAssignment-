package assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Invoice extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField InvoiceID;
	private JTextField Item;
	private JTextField Quantity;
	private JTextField Date;
	private JTextField Total;
	private JTextField Name;
	private JTextField Address;
	private JTextField Contact;
	private JTextField Price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoice frame = new Invoice(args);
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
	public Invoice(String[] InvoiceDetails) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInvoice = new JLabel("Invoice");
		lblInvoice.setBounds(288, 0, 133, 33);
		lblInvoice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblInvoice);
		
		JLabel lblnvoice = new JLabel("Invoice");
		lblnvoice.setBounds(41, 43, 85, 19);
		lblnvoice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblnvoice);
		
		JLabel lblItem = new JLabel("Item");
		lblItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblItem.setBounds(41, 74, 39, 19);
		contentPane.add(lblItem);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(41, 171, 85, 19);
		contentPane.add(lblQuantity);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setBounds(41, 202, 85, 19);
		contentPane.add(lblDate);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotal.setBounds(41, 270, 203, 19);
		contentPane.add(lblTotal);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerName.setBounds(41, 310, 158, 19);
		contentPane.add(lblCustomerName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(41, 356, 85, 19);
		contentPane.add(lblAddress);
		
		JLabel lblSales_5_1 = new JLabel("Contact");
		lblSales_5_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSales_5_1.setBounds(41, 401, 85, 19);
		contentPane.add(lblSales_5_1);
		//Set the text field value to the sales's information;
		
		InvoiceID = new JTextField();
		InvoiceID.setEditable(false);
		InvoiceID.setBounds(200, 45, 311, 19);
		contentPane.add(InvoiceID);
		InvoiceID.setColumns(10);
		InvoiceID.setText(InvoiceDetails[0]);
		

		
		Item = new JTextField();
		Item.setEditable(false);
		Item.setColumns(10);
		Item.setBounds(200, 76, 311, 19);
		contentPane.add(Item);
		Item.setText(InvoiceDetails[1]);

		
		
		Quantity = new JTextField();
		Quantity.setEditable(false);
		Quantity.setColumns(10);
		Quantity.setBounds(200, 173, 311, 19);
		contentPane.add(Quantity);
		Quantity.setText(InvoiceDetails[4]);

		Date = new JTextField();
		Date.setEditable(false);
		Date.setColumns(10);
		Date.setBounds(200, 204, 311, 19);
		contentPane.add(Date);
		Date.setText(InvoiceDetails[5]);

		Total = new JTextField();
		Total.setEditable(false);
		Total.setColumns(10);
		Total.setBounds(200, 272, 311, 19);
		contentPane.add(Total);
		Total.setText(InvoiceDetails[6]);

		Name = new JTextField();
		Name.setEditable(false);
		Name.setColumns(10);
		Name.setBounds(200, 312, 311, 19);
		contentPane.add(Name);
		Name.setText(InvoiceDetails[10]);

		Address = new JTextField();
		Address.setEditable(false);
		Address.setColumns(10);
		Address.setBounds(200, 358, 311, 19);
		contentPane.add(Address);
		Address.setText(InvoiceDetails[11]);

		Contact = new JTextField();
		Contact.setEditable(false);
		Contact.setColumns(10);
		Contact.setBounds(200, 403, 311, 19);
		Contact.setText(InvoiceDetails[12]);

		contentPane.add(Contact);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(41, 140, 85, 19);
		contentPane.add(lblPrice);
		
		Price = new JTextField();
		Price.setText((String) null);
		Price.setEditable(false);
		Price.setColumns(10);
		Price.setBounds(200, 142, 311, 19);
		contentPane.add(Price);
		Price.setText(InvoiceDetails[3]);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(257, 447, 85, 21);
		contentPane.add(btnClose);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPrint.setBounds(362, 447, 85, 21);
		contentPane.add(btnPrint);

	}
}
