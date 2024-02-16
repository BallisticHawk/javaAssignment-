package Object;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Report extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report frame = new Report();
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
	public Report() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("OrderID");
		lblNewLabel.setBounds(10, 77, 103, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("InvoiceID");
		lblNewLabel_1.setBounds(10, 102, 103, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Customer Name");
		lblNewLabel_3.setBounds(10, 127, 103, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(10, 152, 103, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(10, 177, 103, 14);
		contentPane.add(lblContact);
		
		JLabel lblNewLabel_5 = new JLabel("OrderID");
		lblNewLabel_5.setBounds(139, 77, 103, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("InvoiceID");
		lblNewLabel_1_1.setBounds(139, 102, 103, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Customer Name");
		lblNewLabel_3_1.setBounds(139, 127, 103, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Address");
		lblNewLabel_4_1.setBounds(139, 152, 103, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblContact_1 = new JLabel("Contact");
		lblContact_1.setBounds(139, 177, 103, 14);
		contentPane.add(lblContact_1);
		
		JLabel lblNewLabel_2 = new JLabel("Item");
		lblNewLabel_2.setBounds(10, 202, 103, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Item");
		lblNewLabel_2_1.setBounds(139, 202, 103, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblReport = new JLabel("Report");
		lblReport.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblReport.setBounds(10, 23, 140, 23);
		contentPane.add(lblReport);
	}

}
