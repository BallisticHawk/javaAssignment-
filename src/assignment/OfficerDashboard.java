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
		setBounds(100, 100, 525, 312);
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
		btnLogout.setBounds(208, 211, 111, 54);
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
		
		JButton btnProcessSales = new JButton("Manage Sales");
		btnProcessSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OfficerManageOrder A = new OfficerManageOrder();
				A.setVisible(true);
				dispose();
			}
		});
		btnProcessSales.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnProcessSales.setBounds(247, 59, 195, 64);
		contentPane.add(btnProcessSales);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportSelection A = new ReportSelection();
				A.setVisible(true);
				dispose();
			}
		});
		btnGenerateReport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGenerateReport.setBounds(42, 133, 195, 64);
		contentPane.add(btnGenerateReport);
	}

}
