package assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
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
	public Profile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account obj1 = new Account();
				String[] info = obj1.viewProfile();
				
				//back to their respective dashboard based on their role.
				if(info[4].equals("Admin")) {
					
					AdminDashboard A = new AdminDashboard();
					A.setVisible(true);

				}else if(info[4].equals("Officer")) {
					OfficerDashboard A = new OfficerDashboard();
					A.setVisible(true);

				}else {
					SalepersonDashboard A = new SalepersonDashboard();
					A.setVisible(true);

				}
				dispose();

			}
		});
		btnBack.setBounds(97, 316, 135, 71);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnBack);
		
		JButton btnEdit = new JButton("Edit Profile");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditProfile A = new EditProfile();
				A.setVisible(true);
				dispose();
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEdit.setBounds(297, 316, 135, 71);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete Account");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the account? The action cannot be undo.", "Confirmation", JOptionPane.YES_NO_OPTION);
		        if (choice == JOptionPane.YES_OPTION) {
		            Account obj1 = new Account();
		            obj1.deleteAccount();
		            
		            Index A = new Index();
		            A.setVisible(true);
		            dispose();
		        }
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(478, 316, 135, 71);
		contentPane.add(btnDelete);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(131, 73, 101, 34);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(131, 125, 101, 34);
		contentPane.add(lblEmail);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRole.setBounds(131, 180, 101, 34);
		contentPane.add(lblRole);
		
		JLabel lblUid = new JLabel("UID");
		lblUid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUid.setBounds(131, 228, 101, 34);
		contentPane.add(lblUid);
		
		
		Account obj1 = new Account();
		String[] info = obj1.viewProfile();
		//Set the label value to the user's information;
		
		
		JLabel lblName_1 = new JLabel(info[2]);
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName_1.setBounds(272, 73, 408, 34);
		contentPane.add(lblName_1);
		
		JLabel lblEmail_1 = new JLabel(info[0]);
		lblEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail_1.setBounds(272, 125, 377, 34);
		contentPane.add(lblEmail_1);
		
		JLabel lblRole_1 = new JLabel(info[4]);
		lblRole_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRole_1.setBounds(272, 180, 365, 34);
		contentPane.add(lblRole_1);
		
		JLabel lblUid_1 = new JLabel(info[3]);
		lblUid_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUid_1.setBounds(272, 228, 377, 34);
		contentPane.add(lblUid_1);
		
		JLabel lblNewLabel = new JLabel("Profile");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(324, 10, 230, 53);
		contentPane.add(lblNewLabel);
	}

}
