package assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OfficerManageOrder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JComboBox cmbID;
	private JComboBox cmbSale;
	private JLabel lblSaleStatus;
	private JLabel lblProductStatus;
	private JComboBox cmbProduct;
	private JButton btnSearch;
	private JLabel lblOrders;
	private JButton btnViewReport;
	private JButton btnEditProductStatus;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OfficerManageOrder frame = new OfficerManageOrder();
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
	public OfficerManageOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1187, 742);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		cmbSale = new JComboBox();
		cmbSale.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "pending", "approval", "closed"}));
		cmbSale.setBounds(123, 356, 96, 20);
		contentPane.add(cmbSale);
		
		cmbProduct = new JComboBox();
		cmbProduct.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "pending", "work done", "in progress"}));
		cmbProduct.setBounds(123, 381, 96, 20);
		contentPane.add(cmbProduct);
		
		
		cmbID = new JComboBox();
		cmbID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//get orderID
                	String OrderID = (String) cmbID.getSelectedItem();

                	
                	Sales obj1 = new Sales();
			        String[] info = obj1.searchSales(OrderID);
			        
			        //select the current sale status of that orderID
			        for (int i = 0; i < cmbSale.getItemCount(); i++) {
			            // Check if the current item matches the role
			            if (cmbSale.getItemAt(i).equals(info[8])) {
			                // Set the selected item to the matching role
			            	cmbSale.setSelectedIndex(i);
			                break; // Exit the loop once the role is found
			            }
			        }
			        //select the current product status of that orderID

			        for (int i = 0; i < cmbProduct.getItemCount(); i++) {
			            // Check if the current item matches the role
			            if (cmbProduct.getItemAt(i).equals(info[9])) {
			                // Set the selected item to the matching role
			            	cmbProduct.setSelectedIndex(i);
			                break; // Exit the loop once the role is found
			            }
			        }			        
			        

			}
		});
		cmbID.setBounds(123, 331, 96, 20);
		contentPane.add(cmbID);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 1071, 191);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"OrderID", "Item", "Salesperson", "Quantity", "Date", "Sales", "Product", "Name", "Address", "Contact"
			}
		));
		
		//load the sales info from textfile .
        Sales obj1 = new Sales();
 
        List<String[]> salesInfo = obj1.viewSales();
        DefaultTableModel tblModel = (DefaultTableModel) table.getModel();    
           
        // using loop to display all sales details in the table.
        for(String[] sale : salesInfo){
        	String[] rowData = new String[10];
        	//column ( orderID, item, salesperson, quantity, date, sales, product, name, address, contact)
        	
        	rowData[0] = sale[0];
        	rowData[1] = sale[1];
        	rowData[2] = sale[2];
        	rowData[3] = sale[4];
        	rowData[4] = sale[5];
        	rowData[5] = sale[8];
        	rowData[6] = sale[9];
        	rowData[7] = sale[10];
        	rowData[8] = sale[11];
        	rowData[9] = sale[12];

            tblModel.addRow(rowData);
            cmbID.addItem(rowData[0]);

        }
		lblNewLabel = new JLabel("OrderID");
		lblNewLabel.setBounds(10, 331, 103, 14);
		contentPane.add(lblNewLabel);
		


		lblSaleStatus = new JLabel("Sale Status");
		lblSaleStatus.setBounds(10, 356, 103, 14);
		contentPane.add(lblSaleStatus);
		
		lblProductStatus = new JLabel("Product Status");
		lblProductStatus.setBounds(10, 381, 103, 14);
		contentPane.add(lblProductStatus);
		

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String OrderID = (String) cmbID.getSelectedItem();
            	Sales obj1 = new Sales();				
	
                String[] searchedSales = obj1.searchSales(OrderID);
                
                //use the array and pass it to another form
                SearchSales A = new SearchSales(searchedSales);
                A.setVisible(true);
				
			}
		});
		btnSearch.setBounds(236, 330, 89, 21);
		contentPane.add(btnSearch);
		
		lblOrders = new JLabel("Orders");
		lblOrders.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblOrders.setBounds(10, 27, 140, 23);
		contentPane.add(lblOrders);
		
		btnViewReport = new JButton("View Report");
		btnViewReport.setBounds(411, 285, 113, 23);
		contentPane.add(btnViewReport);
		
		JButton btnEditSaleStatus = new JButton("Edit");
		btnEditSaleStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//grab the value of the orderID and sales status that need to be modify.
                String saleStatus = (String) cmbSale.getSelectedItem();
                String OrderID = (String) cmbID.getSelectedItem();

				
				Sales obj1 = new Sales();
				
				//load Data
				List<String[]> salesList = obj1.loadData();
				Officer obj2 = new Officer();
				
				//modify and overwrite to the text file.
				List<String[]> updatedSalesList = obj2.modifySales(salesList, OrderID, saleStatus);
				
				obj1.overwriteData(updatedSalesList);
				
				//refresh windows
				OfficerManageOrder A = new OfficerManageOrder();
				A.setVisible(true);
				dispose();
				
			}
		});
		btnEditSaleStatus.setBounds(236, 354, 89, 23);
		contentPane.add(btnEditSaleStatus);
		
		JButton btnIssueInvoice = new JButton("Issue Invoice");
		btnIssueInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String OrderID = (String) cmbID.getSelectedItem();
            	Officer obj1 = new Officer();
				
				//generate invoice details
                String[] InvoiceDetails = obj1.generateInvoice(OrderID);
                Invoice A = new Invoice(InvoiceDetails);
                A.setVisible(true);
                
			}
		});
		btnIssueInvoice.setBounds(82, 427, 160, 23);
		contentPane.add(btnIssueInvoice);
		
		btnEditProductStatus = new JButton("Edit");
		btnEditProductStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//grab the value of the orderID and sales status that need to be modify.
                String saleStatus = (String) cmbSale.getSelectedItem();
                String OrderID = (String) cmbID.getSelectedItem();
                String productStatus = (String) cmbProduct.getSelectedItem();

				
				Sales obj1 = new Sales();
				
				//load Data
				List<String[]> salesList = obj1.loadData();
				Officer obj2 = new Officer();
				
				//modify and overwrite to the text file.
				
				if(saleStatus.equals("approval")) {
					List<String[]> updatedSalesList = obj2.modifySales(salesList, OrderID, saleStatus,productStatus);
					
					obj1.overwriteData(updatedSalesList);
					
					//refresh windows
					OfficerManageOrder A = new OfficerManageOrder();
					A.setVisible(true);
					dispose();
				}else {
		            JOptionPane.showMessageDialog(null,"Sales status must be approval to edit the product status","Edit Product Status",JOptionPane.INFORMATION_MESSAGE);

				}

			
			
			}
		});
		btnEditProductStatus.setBounds(236, 378, 89, 23);
		contentPane.add(btnEditProductStatus);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboard A = new AdminDashboard();
				A.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(263, 286, 113, 23);
		contentPane.add(btnBack);
	}
}
