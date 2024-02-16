package assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OfficerDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OfficerDashboard frame = new OfficerDashboard();
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
	public OfficerDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Officer Dashboard");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(137, 10, 166, 53);
		contentPane.add(lblTitle);
		
		JButton btnLogout = new JButton("Log Out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login A = new Login();
				A.setVisible(true);
				dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.setBounds(56, 199, 111, 54);
		contentPane.add(btnLogout);
		
		JButton btnManageProfile = new JButton("Manage Profile");
		btnManageProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile A = new Profile();
				A.setVisible(true);
				dispose();
			}
		});
		btnManageProfile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnManageProfile.setBounds(42, 59, 195, 64);
		contentPane.add(btnManageProfile);
	}

}
