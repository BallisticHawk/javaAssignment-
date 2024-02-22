package assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
					Report frame = new Report(args);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param reportDetails 
	 */
	public Report(String[] reportDetails) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 770);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl0 = new JLabel("Title");
		lbl0.setBounds(361, 10, 184, 33);
		lbl0.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lbl0);
		
		JLabel lblNewLabel = new JLabel("Sales Status ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(34, 85, 155, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblProductStatus = new JLabel("Product Status");
		lblProductStatus.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblProductStatus.setBounds(34, 290, 129, 56);
		contentPane.add(lblProductStatus);
		
		JLabel lblNewLabel_1 = new JLabel("Pending");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(44, 128, 155, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Approved");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(44, 180, 155, 38);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Closed");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(44, 264, 155, 38);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Pending");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(44, 336, 155, 38);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("In Progress");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(44, 392, 155, 38);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Work Done");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_5.setBounds(44, 451, 155, 38);
		contentPane.add(lblNewLabel_1_5);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(198, 180, 1, 1);
		contentPane.add(verticalBox);
		
		JLabel lblNewLabel_2 = new JLabel("Total Sales:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(444, 542, 140, 69);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Total Number:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(444, 601, 171, 69);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblQuantity.setBounds(216, 85, 155, 33);
		contentPane.add(lblQuantity);
		
		JLabel lblNewLabel_3_1 = new JLabel("Sales");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3_1.setBounds(418, 85, 155, 33);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblQuantity_1 = new JLabel("Quantity");
		lblQuantity_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblQuantity_1.setBounds(216, 290, 129, 56);
		contentPane.add(lblQuantity_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Unapproved");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(44, 228, 155, 38);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lbl1 = new JLabel("x");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl1.setBounds(186, 128, 155, 38);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("x");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl2.setBounds(186, 180, 155, 38);
		contentPane.add(lbl2);
		
		JLabel lbl3 = new JLabel("x");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl3.setBounds(186, 228, 155, 38);
		contentPane.add(lbl3);
		
		JLabel lbl4 = new JLabel("x");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl4.setBounds(186, 264, 155, 38);
		contentPane.add(lbl4);
		
		JLabel lbl5 = new JLabel("x");
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl5.setBounds(173, 336, 155, 38);
		contentPane.add(lbl5);
		
		JLabel lbl6 = new JLabel("x");
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl6.setBounds(173, 392, 155, 38);
		contentPane.add(lbl6);
		
		JLabel lbl7 = new JLabel("x");
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		lbl7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl7.setBounds(173, 451, 155, 38);
		contentPane.add(lbl7);
		
		JLabel lbl8 = new JLabel("x");
		lbl8.setHorizontalAlignment(SwingConstants.CENTER);
		lbl8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl8.setBounds(361, 128, 155, 38);
		contentPane.add(lbl8);
		
		JLabel lbl9 = new JLabel("x");
		lbl9.setHorizontalAlignment(SwingConstants.CENTER);
		lbl9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl9.setBounds(361, 180, 155, 38);
		contentPane.add(lbl9);
		
		JLabel lbl10 = new JLabel("x");
		lbl10.setHorizontalAlignment(SwingConstants.CENTER);
		lbl10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl10.setBounds(361, 228, 155, 38);
		contentPane.add(lbl10);
		
		JLabel lbl11 = new JLabel("x");
		lbl11.setHorizontalAlignment(SwingConstants.CENTER);
		lbl11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl11.setBounds(361, 264, 155, 38);
		contentPane.add(lbl11);
		
		JLabel lbl12 = new JLabel("x");
		lbl12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl12.setBounds(587, 557, 155, 38);
		contentPane.add(lbl12);
		
		JLabel lbl13 = new JLabel("x");
		lbl13.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl13.setBounds(598, 616, 155, 38);
		contentPane.add(lbl13);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClose.setBounds(286, 670, 120, 53);
		contentPane.add(btnClose);
		
		
		//stored all the labels into an array
        JLabel[] labels = {lbl0, lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11,lbl12,lbl13};
		//customize the report

        for (int i = 0; i < labels.length; i++){
            labels[i].setText(reportDetails[i]);
        }

		
		
	}
}
