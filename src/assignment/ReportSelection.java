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

public class ReportSelection extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtYear;

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
		
		JButton btnMonthly = new JButton("Monthly Report");
		btnMonthly.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMonthly.setBounds(40, 181, 164, 27);
		contentPane.add(btnMonthly);
		
		JButton btnAnnualReport = new JButton("Annual Report");
		btnAnnualReport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAnnualReport.setBounds(236, 181, 164, 27);
		contentPane.add(btnAnnualReport);
		
		txtYear = new JTextField();
		txtYear.setText("Year");
		txtYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtYear.setBounds(236, 114, 130, 19);
		contentPane.add(txtYear);
		txtYear.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox.setBounds(40, 143, 130, 19);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Report Type");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(167, 10, 165, 37);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1.setBounds(236, 143, 130, 19);
		contentPane.add(comboBox_1);
	}
}
