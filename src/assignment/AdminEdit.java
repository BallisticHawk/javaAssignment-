package assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AdminEdit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtEmail;
	private JButton btnBack;
	private JButton btnSignUp;
	private JLabel lblUid;
	private JTextField txtID;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminEdit frame = new AdminEdit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param uID 
	 */
	public AdminEdit(String uID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(77, 68, 83, 28);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(77, 116, 83, 28);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblEmail);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.setBounds(173, 68, 262, 28);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBounds(173, 117, 262, 22);
		contentPane.add(txtEmail);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        ManageWorker A = new ManageWorker();
		        A.setVisible(true);
		        dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(53, 272, 139, 33);
		contentPane.add(btnBack);
		
		
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRole.setBounds(77, 159, 83, 28);
		contentPane.add(lblRole);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "Admin", "Salesperson", "Officer"}));
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 15));
		comboBox.setBounds(173, 162, 262, 22);
		
		contentPane.add(comboBox);
		btnSignUp = new JButton("Edit");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String email = txtEmail.getText();
		        String role = (String) comboBox.getSelectedItem();
		        Admin obj1 = new Admin(name,name,email,role);

				String signup = obj1.insertData();
				if(signup.equals("Account have been registered.")) {
		            JOptionPane.showMessageDialog(null,signup,"Sign Up",JOptionPane.INFORMATION_MESSAGE);
			        ManageWorker A = new ManageWorker();
			        A.setVisible(true);
			        dispose();
				}else {
		            JOptionPane.showMessageDialog(null,signup,"Sign Up",JOptionPane.INFORMATION_MESSAGE);

				}
				
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSignUp.setBounds(236, 270, 127, 37);
		contentPane.add(btnSignUp);		
		
		lblUid = new JLabel("UID");
		lblUid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUid.setBounds(77, 26, 83, 28);
		contentPane.add(lblUid);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtID.setColumns(10);
		txtID.setBounds(173, 26, 262, 28);
		contentPane.add(txtID);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(384, 268, 127, 37);
		contentPane.add(btnDelete);
		
		Admin obj1 = new Admin();
		String[] info = obj1.viewProfile(uID);
		//Set the text field value to the user's information;
		txtID.setText(info[3]);
		txtName.setText(info[2]);
		txtEmail.setText(info[0]);

		

		
	}

	public AdminEdit() {
		// TODO Auto-generated constructor stub
	}
}
