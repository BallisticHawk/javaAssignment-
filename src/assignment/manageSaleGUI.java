package assignment;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class manageSaleGUI extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private modifyData editSalesData;
    private final int[] nonEditableColumns = {3, 9, 10};

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    manageSaleGUI frame = new manageSaleGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public manageSaleGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1115, 630);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 85, 1071, 300);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        scrollPane.setViewportView(table);

        //load personal sales
        Salesperson obj2 = new Salesperson();
        
        DefaultTableModel model = obj2.viewPersonalSales(Account.UID);
        table.setModel(model);

        JLabel lblNewLabel = new JLabel("Sales List");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel.setBounds(511, 26, 215, 37);
        contentPane.add(lblNewLabel);

        JButton btnBack = new JButton("Go Back ");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SalepersonDashboard A = new SalepersonDashboard();
        		A.setVisible(true);
        		dispose();
                
        	}
        });
        btnBack.setBounds(37, 406, 89, 23);
        contentPane.add(btnBack);
        
        JComboBox cmbID = new JComboBox();
        cmbID.setBounds(150, 450, 96, 20);
        contentPane.add(cmbID);
        for (int i = 0; i < model.getRowCount(); i++) {
            // Get the value from the first column of the current row
            Object value = model.getValueAt(i, 0); // Assuming the first column index is 0
            
            // Add the value to the combo box
            cmbID.addItem(value);
        }
        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                List<String[]> tableData = new ArrayList<>();
                for (int i = 0; i < model.getRowCount(); i++) {
                    String[] rowData = new String[model.getColumnCount()];
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        rowData[j] = String.valueOf(model.getValueAt(i, j));
                    }
                    tableData.add(rowData);

                }


                modifyData.updateSalesData(tableData);
                
             
                JOptionPane.showMessageDialog(manageSaleGUI.this, "Data updated successfully!");
            }
        });

        btnUpdate.setBounds(140, 406, 89, 23);
        contentPane.add(btnUpdate);
        
        JButton btnDelete = new JButton("Refresh");
        btnDelete.setBounds(253, 406, 99, 23);
        contentPane.add(btnDelete);
        
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	manageSaleGUI A = new manageSaleGUI();
            	A.setVisible(true);
            	dispose();
            }
        });
        
        JButton btnAdd = new JButton("Add Sales");
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AddSales A = new AddSales();
        		A.setVisible(true);
                
        		
        	}
        });
        btnAdd.setBounds(378, 406, 99, 23);
        contentPane.add(btnAdd);

        JLabel lblNewLabel_1 = new JLabel("OrderID");
        lblNewLabel_1.setBounds(37, 450, 103, 14);
        contentPane.add(lblNewLabel_1);
        
        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                String OrderID = (String) cmbID.getSelectedItem();
            	Sales obj1 = new Sales();				
	
                String[] searchedSales = obj1.searchSales(OrderID);
                
                //use the array and pass it to another form
                SalespersonSearchSales A = new SalespersonSearchSales(searchedSales);
                A.setVisible(true);
        		
        	}
        });
        btnSearch.setBounds(263, 449, 89, 21);
        contentPane.add(btnSearch);
    
    }
}
