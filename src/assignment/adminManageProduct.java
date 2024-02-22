package assignment;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class adminManageProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminManageProduct frame = new adminManageProduct();
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
	public adminManageProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1115, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 1071, 300);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		
		  
		dataReader obj2 = new dataReader();
        DefaultTableModel model = obj2.displayProduct();
        table.setModel(model);
        
        JButton btnBack = new JButton("Back ");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AdminDashboard A = new AdminDashboard();
        		A.setVisible(true);
        		dispose();
        	}
        });
        btnBack.setBounds(37, 406, 89, 23);
        contentPane.add(btnBack);
        
        JLabel lblNewLabel = new JLabel("Product List");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel.setBounds(471, 11, 195, 63);
        contentPane.add(lblNewLabel);
        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	modifyData editProductData = new modifyData();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                editProductData.updateProductData(model);
                
                JOptionPane.showMessageDialog(adminManageProduct.this, "Data updated successfully!");
            }
        });
        
        btnUpdate.setBounds(140, 406, 89, 23);
        contentPane.add(btnUpdate);
        
        JButton btnDelete = new JButton("Delete Row");
        btnDelete.setBounds(239, 406, 99, 23);
        contentPane.add(btnDelete);
        
        JButton btnAddProduct = new JButton("Add Product");
        btnAddProduct.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnAddProduct.setBounds(348, 406, 114, 23);
        contentPane.add(btnAddProduct);
        
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modifyData updateProductData = new modifyData(); // Initialize modifyData object
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Delete the row
                    updateProductData.deleteProductRow((DefaultTableModel)table.getModel(), selectedRow);
                    JOptionPane.showMessageDialog(adminManageProduct.this, "Row deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(adminManageProduct.this, "Please select a row to delete!");
                }
            }
        });
	    
        
	         
	}
}
