package assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JTextField txtEmail;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(68, 67, 82, 44);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(68, 144, 115, 34);
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(205, 144, 200, 32);
		contentPane.add(txtPassword);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(205, 82, 200, 29);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = txtEmail.getText();
		        String password = String.valueOf(txtPassword.getPassword());
				Account obj1 = new Account();
				String[] login = obj1.authenticateLogin(email, password);
				if(login[0].equals("success")) {
		            JOptionPane.showMessageDialog(null,login[1],"Login",JOptionPane.INFORMATION_MESSAGE);
		            if(login[2].equals("Officer")) {
		            	OfficerDashboard A = new OfficerDashboard();
		            	A.setVisible(true);

		            	
		            }
		            else if(login[2].equals("Admin")) {
		            	AdminDashboard A = new AdminDashboard();
		            	A.setVisible(true);
		            	
		            }else {
		            	SalepersonDashboard A = new SalepersonDashboard();
		            	A.setVisible(true);
		            }
		            dispose();
		            
		            
				}else {
		            JOptionPane.showMessageDialog(null,login[1],"Login",JOptionPane.INFORMATION_MESSAGE);

				}

				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(230, 205, 149, 36);
		contentPane.add(btnLogin);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        Index A = new Index();
		        A.setVisible(true);
		        dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(68, 205, 149, 36);
		contentPane.add(btnBack);
	}
}
