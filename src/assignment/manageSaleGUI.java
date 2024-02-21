package assignment;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class manageSaleGUI extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private modifyData editSalesData;

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
    	
		//String UID = Account.UID;
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1115, 490);
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

        dataReader obj2 = new dataReader();
        DefaultTableModel model = obj2.displaySales();
        table.setModel(model);

        JLabel lblNewLabel = new JLabel("Sales List");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel.setBounds(511, 26, 215, 37);
        contentPane.add(lblNewLabel);

        JButton btnBack = new JButton("Go Back ");
        btnBack.setBounds(37, 406, 89, 23);
        contentPane.add(btnBack);
        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	editSalesData = new modifyData();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                editSalesData.updateSalesData(model);
                
                JOptionPane.showMessageDialog(manageSaleGUI.this, "Data updated successfully!");
            }
        });
        
        btnUpdate.setBounds(140, 406, 89, 23);
        contentPane.add(btnUpdate);
        
        JButton btnDelete = new JButton("Delete Row");
        btnDelete.setBounds(339, 406, 99, 23);
        contentPane.add(btnDelete);
        
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modifyData editSalesData = new modifyData(); // Initialize modifyData object
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Delete the row
                    editSalesData.deleteRow((DefaultTableModel)table.getModel(), selectedRow);
                    JOptionPane.showMessageDialog(manageSaleGUI.this, "Row deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(manageSaleGUI.this, "Please select a row to delete!");
                }
            }
        });
        
        JButton btnAddRow = new JButton("Add Row");
        btnAddRow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[model.getColumnCount()]);
            }
        });
        btnAddRow.setBounds(240, 406, 89, 23);
        contentPane.add(btnAddRow);
    
    }
}
