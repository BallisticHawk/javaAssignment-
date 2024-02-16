package assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class EditProfile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditProfile frame = new EditProfile();
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
	public EditProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Edit Profile");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(159, 10, 208, 38);
		contentPane.add(lblTitle);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(28, 58, 150, 38);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(28, 106, 150, 38);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(28, 154, 150, 38);
		contentPane.add(lblPassword);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile A = new Profile();
				A.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(74, 202, 122, 58);
		contentPane.add(btnBack);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				
				Account obj1 = new Account();
				String[] info = obj1.viewProfile();

				
				//prompt user for old password to edit their profile.
		        String oldPassword = JOptionPane.showInputDialog(null, "Enter your old password to make changes:");
		        if(oldPassword.equals(info[1])) {
					//get the new information and stored it into array and passed it into the method editProfile.

					info[0] = textEmail.getText();
					info[1] = String.valueOf(txtPassword.getPassword());
					info[2] = txtName.getText();
					String message = obj1.editProfile(info);
		            JOptionPane.showMessageDialog(null,message,"Edit Profile",JOptionPane.INFORMATION_MESSAGE);

		        }else {
		            JOptionPane.showMessageDialog(null, "Incorrect old password. Please try again.");

		        }
				
				
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEdit.setBounds(276, 202, 122, 58);
		contentPane.add(btnEdit);
		
		//Set the text field value to the user's information;

		Account obj1 = new Account();
		String[] info = obj1.viewProfile();
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.setBounds(154, 70, 272, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);
		txtName.setText(info[2]);
		
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setBounds(154, 166, 272, 26);
		txtPassword.setBounds(154, 166, 272, 26);
		txtPassword.setText(info[1]);

		contentPane.add(txtPassword);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textEmail.setColumns(10);
		textEmail.setBounds(154, 118, 272, 26);
		textEmail.setText(info[0]);
		contentPane.add(textEmail);
	}

}
