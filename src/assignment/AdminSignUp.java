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

public class AdminSignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JButton btnBack;
	private JButton btnSignUp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSignUp frame = new AdminSignUp();
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
	public AdminSignUp() {
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
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(77, 163, 83, 28);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblPassword);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.setBounds(173, 68, 166, 28);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBounds(173, 117, 166, 28);
		contentPane.add(txtEmail);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setBounds(173, 163, 166, 26);
		contentPane.add(txtPassword);
		
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
		lblRole.setBounds(77, 201, 83, 28);
		contentPane.add(lblRole);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "Admin", "Salesperson", "Officer"}));
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 15));
		comboBox.setBounds(173, 207, 166, 22);
		
		contentPane.add(comboBox);
		btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String email = txtEmail.getText();
		        String password = String.valueOf(txtPassword.getPassword());
		        String role = (String) comboBox.getSelectedItem();
				Admin obj1 = new Admin(name,password,email,role);

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
	}
}
