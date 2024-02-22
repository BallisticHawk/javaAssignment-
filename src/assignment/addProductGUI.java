package assignment;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addProductGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField itemId;
	private JTextField name;
	private JTextField category;
	private JTextField price;
	private JTextField sellableStatus;
	private JTextField shortDesc;
	private JTextField designer;
	private JTextField depth;
	private JTextField height;
	private JTextField width;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addProductGUI frame = new addProductGUI();
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
	public addProductGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddProduct = new JLabel("Add Product");
		lblAddProduct.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAddProduct.setBounds(243, 11, 174, 48);
		contentPane.add(lblAddProduct);
		
		JLabel lblNewLabel = new JLabel("Item ID:");
		lblNewLabel.setBounds(109, 75, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(109, 100, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Category:");
		lblNewLabel_2.setBounds(95, 125, 57, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price:");
		lblNewLabel_3.setBounds(109, 150, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sellable Online:");
		lblNewLabel_4.setBounds(61, 175, 94, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Short Description:");
		lblNewLabel_5.setBounds(46, 200, 119, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Designer:");
		lblNewLabel_6.setBounds(95, 261, 60, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Depth:");
		lblNewLabel_7.setBounds(109, 286, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Height:");
		lblNewLabel_8.setBounds(109, 311, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Width:");
		lblNewLabel_9.setBounds(109, 335, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		itemId = new JTextField();
		itemId.setBounds(165, 70, 86, 20);
		contentPane.add(itemId);
		itemId.setColumns(10);
		
		name = new JTextField();
		name.setBounds(165, 97, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		category = new JTextField();
		category.setBounds(165, 122, 86, 20);
		contentPane.add(category);
		category.setColumns(10);
		
		price = new JTextField();
		price.setBounds(165, 147, 86, 20);
		contentPane.add(price);
		price.setColumns(10);
		
		sellableStatus = new JTextField();
		sellableStatus.setBounds(165, 172, 86, 20);
		contentPane.add(sellableStatus);
		sellableStatus.setColumns(10);
		
		shortDesc = new JTextField();
		shortDesc.setBounds(165, 197, 333, 54);
		contentPane.add(shortDesc);
		shortDesc.setColumns(10);
		
		designer = new JTextField();
		designer.setBounds(165, 258, 86, 20);
		contentPane.add(designer);
		designer.setColumns(10);
		
		depth = new JTextField();
		depth.setBounds(165, 283, 86, 20);
		contentPane.add(depth);
		depth.setColumns(10);
		
		height = new JTextField();
		height.setBounds(165, 308, 86, 20);
		contentPane.add(height);
		height.setColumns(10);
		
		width = new JTextField();
		width.setBounds(165, 332, 86, 20);
		contentPane.add(width);
		width.setColumns(10);
		
		JButton addProductButton = new JButton("Add Product");
		addProductButton.setBounds(277, 378, 105, 30);
		contentPane.add(addProductButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProductGUI A = new addProductGUI();
				A.setVisible(true);
			}
		});
		btnBack.setBounds(149, 378, 105, 30);
		contentPane.add(btnBack);
		
		
		addProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ItemId = itemId.getText();
				String Name = name.getText();
				String Category = category.getText();
				String Price = price.getText();
				String SellableOnline = sellableStatus.getText();
				String ShowDescription = shortDesc.getText();
				String Designer = designer.getText();
				String Depth = depth.getText();
				String Height = height.getText();
				String Width = width.getText();
				
				Validation validator = new Validation();
				boolean Name_b = validator.validate(Name,"name");
				if (Name_b == true) {
					addProduct obj1 = new addProduct (ItemId, Name, Category, Price, SellableOnline, ShowDescription,Designer, Depth, Height, Width);
					String result = obj1.writeProduct(ItemId, Name, Category, Price, SellableOnline, ShowDescription, Designer, Depth, Height, Width);

					
					if (result.equals("Success")) {
			            JOptionPane.showMessageDialog(null, "Product added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

			            // Clear text fields
			            itemId.setText("");
			            name.setText("");
			            category.setText("");
			            price.setText("");
			            sellableStatus.setText("");
			            shortDesc.setText("");
			            designer.setText("");
			            depth.setText("");
			            height.setText("");
			            width.setText("");
			        } else {
			            JOptionPane.showMessageDialog(null, "Error occurred while adding product.", "Error", JOptionPane.ERROR_MESSAGE);
			        }					
				}else {
		            JOptionPane.showMessageDialog(null, "Invalid name format.", "Error", JOptionPane.ERROR_MESSAGE);

				}

		    }
		});
	}
}
