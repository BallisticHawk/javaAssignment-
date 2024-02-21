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

public class SearchSales extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField OrderID;
	private JTextField Item;
	private JTextField SalesID;
	private JTextField Quantity;
	private JTextField Date;
	private JTextField SaleStatus;
	private JTextField ProductStatus;
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
					SearchSales frame = new SearchSales(args);
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
	public SearchSales(String[] searchedSales) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOrders = new JLabel("Orders");
		lblOrders.setBounds(288, 0, 133, 33);
		lblOrders.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblOrders);
		
		JLabel lblSales = new JLabel("OrderID");
		lblSales.setBounds(41, 43, 85, 19);
		lblSales.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblSales);
		
		JLabel lblItem = new JLabel("Item");
		lblItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblItem.setBounds(41, 74, 39, 19);
		contentPane.add(lblItem);
		
		JLabel lblSalespersonId = new JLabel("Salesperson ID");
		lblSalespersonId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSalespersonId.setBounds(41, 103, 124, 29);
		contentPane.add(lblSalespersonId);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(41, 171, 85, 19);
		contentPane.add(lblQuantity);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setBounds(41, 202, 85, 19);
		contentPane.add(lblDate);
		
		JLabel lblSalesstatus = new JLabel("Sales Status");
		lblSalesstatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSalesstatus.setBounds(41, 231, 85, 19);
		contentPane.add(lblSalesstatus);
		
		JLabel lblProductstatus = new JLabel("Product Status");
		lblProductstatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductstatus.setBounds(41, 270, 203, 19);
		contentPane.add(lblProductstatus);
		
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
		
		OrderID = new JTextField();
		OrderID.setEditable(false);
		OrderID.setBounds(200, 45, 311, 19);
		contentPane.add(OrderID);
		OrderID.setColumns(10);
		OrderID.setText(searchedSales[0]);
		

		
		Item = new JTextField();
		Item.setEditable(false);
		Item.setColumns(10);
		Item.setBounds(200, 76, 311, 19);
		contentPane.add(Item);
		Item.setText(searchedSales[1]);
		
		SalesID = new JTextField();
		SalesID.setEditable(false);
		SalesID.setColumns(10);
		SalesID.setBounds(200, 110, 311, 19);
		contentPane.add(SalesID);
		SalesID.setText(searchedSales[2]);

		
		
		Quantity = new JTextField();
		Quantity.setEditable(false);
		Quantity.setColumns(10);
		Quantity.setBounds(200, 173, 311, 19);
		contentPane.add(Quantity);
		Quantity.setText(searchedSales[4]);

		Date = new JTextField();
		Date.setEditable(false);
		Date.setColumns(10);
		Date.setBounds(200, 204, 311, 19);
		contentPane.add(Date);
		Date.setText(searchedSales[5]);

		SaleStatus = new JTextField();
		SaleStatus.setEditable(false);
		SaleStatus.setColumns(10);
		SaleStatus.setBounds(200, 233, 311, 19);
		contentPane.add(SaleStatus);
		SaleStatus.setText(searchedSales[8]);

		ProductStatus = new JTextField();
		ProductStatus.setEditable(false);
		ProductStatus.setColumns(10);
		ProductStatus.setBounds(200, 272, 311, 19);
		contentPane.add(ProductStatus);
		ProductStatus.setText(searchedSales[9]);

		Name = new JTextField();
		Name.setEditable(false);
		Name.setColumns(10);
		Name.setBounds(200, 312, 311, 19);
		contentPane.add(Name);
		Name.setText(searchedSales[10]);

		Address = new JTextField();
		Address.setEditable(false);
		Address.setColumns(10);
		Address.setBounds(200, 358, 311, 19);
		contentPane.add(Address);
		Address.setText(searchedSales[11]);

		Contact = new JTextField();
		Contact.setEditable(false);
		Contact.setColumns(10);
		Contact.setBounds(200, 403, 311, 19);
		Contact.setText(searchedSales[12]);

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
		Price.setText(searchedSales[3]);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(257, 447, 85, 21);
		contentPane.add(btnClose);

	}
}
