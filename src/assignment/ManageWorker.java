package assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ManageWorker extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtSearch;
	private JTextField txtName;
	private JTextField txtEmail;
	private String[] info = new String[5];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageWorker frame = new ManageWorker();
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
	public ManageWorker() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		txtName = new JTextField();
		txtName.setBounds(45, 275, 135, 23);
		txtName.setText("Name");
		txtName.setColumns(10);
		contentPane.add(txtName);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(45, 313, 135, 23);
		txtEmail.setText("Email");
		txtEmail.setColumns(10);
		contentPane.add(txtEmail);		
		
		
		
		JComboBox cmbRole = new JComboBox();
		cmbRole.setBounds(201, 277, 166, 22);
		cmbRole.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "Admin", "Salesperson", "Officer", "Unassigned"}));
		cmbRole.setFont(new Font("Verdana", Font.PLAIN, 15));
		contentPane.add(cmbRole);
		JComboBox cmbID = new JComboBox();
		cmbID.setBounds(201, 229, 255, 30);
		cmbID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//put the value into the text field
				String ID = (String) cmbID.getSelectedItem();
				Admin obj1 = new Admin();
				info = obj1.viewProfile(ID);
				//Set the text field value to the user's information;
				txtName.setText(info[2]);
				txtEmail.setText(info[0]);
				
				//select the combo box
		        for (int i = 0; i < cmbRole.getItemCount(); i++) {
		            // Check if the current item matches the role
		            if (cmbRole.getItemAt(i).equals(info[4])) {
		                // Set the selected item to the matching role
		            	cmbRole.setSelectedIndex(i);
		                break; // Exit the loop once the role is found
		            }
		        }
				
			}
		});
		contentPane.add(cmbID);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 76, 576, 143);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Email", "Role", "Password"
			}
		));
		
		//Hide unused column like ID and password.

		table.getColumnModel().getColumn(4).setPreferredWidth(0);
		table.getColumnModel().getColumn(4).setMinWidth(0);
		table.getColumnModel().getColumn(4).setMaxWidth(0);
        Admin obj1 = new Admin();
        List<String[]> workerDetails = obj1.loadData();
        DefaultTableModel tblModel = (DefaultTableModel) table.getModel();    
           
        // using loop to display all booking details in the table.
        for(String[] workerDetail : workerDetails){
        	String[] rowData = new String[5];
        	//column (ID,name,email,role,password)
        	
        	rowData[0] = workerDetail[3];
        	rowData[1] = workerDetail[2];
        	rowData[2] = workerDetail[0];
        	rowData[3] = workerDetail[4];
        	rowData[4] = workerDetail[1];
            tblModel.addRow(rowData);
            cmbID.addItem(workerDetail[3]);

        }
		
		
		
		JLabel lblNewLabel = new JLabel("Worker Profile");
		lblNewLabel.setBounds(25, 25, 191, 23);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblNewLabel);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(466, 269, 135, 30);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//store updated information into an array 
		        String[] updatedData = info;

		        updatedData[0] = txtEmail.getText();
				updatedData[2] = txtName.getText();
			    updatedData[4] = (String) cmbRole.getSelectedItem();
		        Validation validator = new Validation();
		        boolean name_b = validator.validate(updatedData[2],"name");
		        boolean email_b = validator.validate(updatedData[0],"email");
		        
		        if (name_b == true && email_b == true) {

			        //make modification
			        Admin obj1 = new Admin();
			        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to save the changes? The action cannot be undo.", "Confirmation", JOptionPane.YES_NO_OPTION);
			        if (choice == JOptionPane.YES_OPTION) {
			        String message = obj1.editProfile(updatedData,info[3]);
		            JOptionPane.showMessageDialog(null,message,"Edit Profile",JOptionPane.INFORMATION_MESSAGE);
		            
		            //refresh the page.
		            ManageWorker A = new ManageWorker();
		            A.setVisible(true);
		            dispose();
			        }
			        
					
		        }else {
		            JOptionPane.showMessageDialog(null,"Invalid name or email","Edit Profile",JOptionPane.ERROR_MESSAGE);

		        }

		        
		        	
			}
		});
		contentPane.add(btnSave);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(226, 25, 135, 23);
		txtSearch.setText("Search");
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Enter");
		btnNewButton_1.setBounds(368, 27, 75, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(35, 229, 156, 30);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSignUp A = new AdminSignUp();
				A.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnCreate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(466, 229, 135, 30);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        String Password = JOptionPane.showInputDialog(null, "Enter your password to delete this account");
		        if (Password != null) {
		        	//check authorization before admin perform delete of account.
		        	Boolean authorization = obj1.authenticate(Password);
		        	if (authorization == true) {
						//delete the account.

						Admin obj1 = new Admin();
						obj1.deleteAccount(info[3]);
						ManageWorker A = new ManageWorker();
						A.setVisible(true);
						dispose();
		        	}else {
			            JOptionPane.showMessageDialog(null, "Incorrect password. Please try again.");

		        	}
		        }

				
				
			}
		});
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(35, 360, 156, 30);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboard A = new AdminDashboard();
				A.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnBack);
		

		

		

	}
}
