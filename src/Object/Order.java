package Object;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;

public class Order extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPasswordField passwordField;
	private JTextField textField_3;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblContact;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton;
	private JButton btnEdit;
	private JButton btnSave;
	private JButton btnDelete;
	private JTextField textField_4;
	private JButton btnNewButton_1;
	private JLabel lblOrders;
	private JButton btnDelete_1;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order frame = new Order();
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
	public Order() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 649);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 504, 164);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"OrderID", "InvoiceID", "Item", "CustomerName", "Address", "Contact", "Status"
			}
		));
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(123, 431, 96, 20);
		contentPane.add(textField);
		
		lblNewLabel = new JLabel("OrderID");
		lblNewLabel.setBounds(10, 331, 103, 14);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(123, 331, 96, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(123, 356, 96, 20);
		contentPane.add(textField_2);
		
		lblNewLabel_1 = new JLabel("InvoiceID");
		lblNewLabel_1.setBounds(10, 356, 103, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Item");
		lblNewLabel_2.setBounds(10, 381, 103, 14);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(123, 381, 96, 20);
		contentPane.add(passwordField);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(123, 406, 96, 20);
		contentPane.add(textField_3);
		
		lblNewLabel_3 = new JLabel("Customer Name");
		lblNewLabel_3.setBounds(10, 406, 103, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(10, 431, 103, 14);
		contentPane.add(lblNewLabel_4);
		
		lblContact = new JLabel("Contact");
		lblContact.setBounds(10, 456, 103, 14);
		contentPane.add(lblContact);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(123, 456, 96, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(123, 481, 96, 20);
		contentPane.add(textField_6);
		
		lblNewLabel_6 = new JLabel("Status");
		lblNewLabel_6.setBounds(10, 481, 103, 14);
		contentPane.add(lblNewLabel_6);
		
		btnNewButton = new JButton("Create");
		btnNewButton.setBounds(10, 267, 89, 23);
		contentPane.add(btnNewButton);
		
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(109, 267, 89, 23);
		contentPane.add(btnEdit);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(206, 267, 89, 23);
		contentPane.add(btnSave);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(305, 267, 89, 23);
		contentPane.add(btnDelete);
		
		textField_4 = new JTextField();
		textField_4.setText("Search");
		textField_4.setColumns(10);
		textField_4.setBounds(298, 55, 96, 20);
		contentPane.add(textField_4);
		
		btnNewButton_1 = new JButton("Enter");
		btnNewButton_1.setBounds(401, 54, 61, 23);
		contentPane.add(btnNewButton_1);
		
		lblOrders = new JLabel("Orders");
		lblOrders.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblOrders.setBounds(10, 27, 140, 23);
		contentPane.add(lblOrders);
		
		btnDelete_1 = new JButton("View Report");
		btnDelete_1.setBounds(401, 267, 113, 23);
		contentPane.add(btnDelete_1);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(75, 521, 89, 23);
		contentPane.add(btnAdd);
	}
}
