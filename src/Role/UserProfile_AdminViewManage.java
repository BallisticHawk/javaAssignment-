package Role;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class UserProfile_AdminViewManage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserProfile_AdminViewManage frame = new UserProfile_AdminViewManage();
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
	public UserProfile_AdminViewManage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 76, 353, 129);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Email", "Role"
			}
		));
		
		JLabel lblNewLabel = new JLabel("Users Profile");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(25, 25, 140, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(289, 229, 89, 23);
		contentPane.add(btnNewButton);
		
		txtSearch = new JTextField();
		txtSearch.setText("Search");
		txtSearch.setBounds(214, 26, 96, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Enter");
		btnNewButton_1.setBounds(317, 25, 61, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Create");
		btnNewButton_2.setBounds(25, 229, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
