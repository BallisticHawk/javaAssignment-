package assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard frame = new AdminDashboard();
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
	public AdminDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Admin Dashboard");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(229, 21, 195, 37);
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
		btnLogout.setBounds(174, 338, 111, 54);
		contentPane.add(btnLogout);
		
		JButton btnManageProfile = new JButton("Manage Profile");
		btnManageProfile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnManageProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile A = new Profile();
				A.setVisible(true);
				dispose();
			}
		});
		btnManageProfile.setBounds(78, 67, 195, 64);
		contentPane.add(btnManageProfile);
		
		JButton btnManageWorkerProfile = new JButton("Manage Worker Profile");
		btnManageWorkerProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageWorker A = new ManageWorker();
				A.setVisible(true);
				dispose();
			}
		});
		btnManageWorkerProfile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnManageWorkerProfile.setBounds(78, 150, 195, 64);
		contentPane.add(btnManageWorkerProfile);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGenerateReport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGenerateReport.setBounds(316, 150, 195, 64);
		contentPane.add(btnGenerateReport);
		
		JButton btnManageProduct = new JButton("Manage Product");
		btnManageProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminManageProduct A = new adminManageProduct();
				A.setVisible(true);
				dispose();
			}
		});
		btnManageProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnManageProduct.setBounds(316, 67, 195, 64);
		contentPane.add(btnManageProduct);
	}
}
