package assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReportSelection extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtYear;
	private JTextField txtYear1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportSelection frame = new ReportSelection();
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
	public ReportSelection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		


		txtYear = new JTextField();
		txtYear.setText("Year");
		txtYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtYear.setBounds(236, 114, 130, 19);
		contentPane.add(txtYear);
		txtYear.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Report Type");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(167, 10, 165, 37);
		contentPane.add(lblNewLabel);
		
		JComboBox cmb_month_year = new JComboBox();
		cmb_month_year.setModel(new DefaultComboBoxModel(new String[] {"Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cmb_month_year.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmb_month_year.setBounds(236, 143, 130, 19);
		contentPane.add(cmb_month_year);
		
		JButton btnMonthly = new JButton("Annual Report");
		btnMonthly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String year = txtYear1.getText();
				Sales obj1 = new Sales();
				String[] reportDetails = obj1.generateReport(year);
				Report A = new Report(reportDetails);
				A.setVisible(true);
			}
		});
		btnMonthly.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMonthly.setBounds(40, 181, 164, 27);
		contentPane.add(btnMonthly);
		
		JButton btnMonthlyReport = new JButton("MonthlyReport");
		btnMonthlyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String year = txtYear.getText();
		        String month = (String) cmb_month_year.getSelectedItem();
				Sales obj1 = new Sales();

				String[] reportDetails = obj1.generateReport(month,year);
				
				Report A = new Report(reportDetails);
				A.setVisible(true);

			}
		});
		btnMonthlyReport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMonthlyReport.setBounds(236, 181, 164, 27);
		contentPane.add(btnMonthlyReport);
		
		txtYear1 = new JTextField();
		txtYear1.setText("Year");
		txtYear1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtYear1.setColumns(10);
		txtYear1.setBounds(40, 116, 130, 19);
		contentPane.add(txtYear1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
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

				}
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(51, 232, 85, 21);
		contentPane.add(btnNewButton);
		
	}
}
