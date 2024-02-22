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

public class SalepersonDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalepersonDashboard frame = new SalepersonDashboard();
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
	public SalepersonDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Salesperson Dashboard");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(150, 0, 311, 75);
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
		btnLogout.setBounds(203, 245, 111, 54);
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
		btnManageProfile.setBounds(34, 73, 195, 64);
		contentPane.add(btnManageProfile);
		
		JButton btnManageSales = new JButton("Manage Sales");
		btnManageSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageSaleGUI A = new manageSaleGUI();
				A.setVisible(true);
				dispose();
			}
		});
		btnManageSales.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnManageSales.setBounds(266, 73, 195, 64);
		contentPane.add(btnManageSales);
		
		JButton btnViewProduct = new JButton("View Product");
		btnViewProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalespersonViewProduct A = new SalespersonViewProduct();
				A.setVisible(true);
			}
		});
		btnViewProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewProduct.setBounds(34, 151, 195, 64);
		contentPane.add(btnViewProduct);
	}
}
