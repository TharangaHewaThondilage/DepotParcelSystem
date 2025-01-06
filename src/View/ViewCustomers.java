package view;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Customer;
import java.util.logging.*;

public class ViewCustomers extends javax.swing.JPanel {

    public ViewCustomers() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_cus = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cus = new javax.swing.JTable();
        btn_laodQueue = new javax.swing.JButton();
        btn_addCus = new javax.swing.JButton();
        btn_dlt_cus = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 255, 255));
        setPreferredSize(new java.awt.Dimension(630, 380));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_cus.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("View Customers");

        javax.swing.GroupLayout lbl_cusLayout = new javax.swing.GroupLayout(lbl_cus);
        lbl_cus.setLayout(lbl_cusLayout);
        lbl_cusLayout.setHorizontalGroup(
            lbl_cusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbl_cusLayout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(jLabel1)
                .addContainerGap(276, Short.MAX_VALUE))
        );
        lbl_cusLayout.setVerticalGroup(
            lbl_cusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbl_cusLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        add(lbl_cus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 30));

        tbl_cus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "ParcelID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_cus);
        if (tbl_cus.getColumnModel().getColumnCount() > 0) {
            tbl_cus.getColumnModel().getColumn(0).setResizable(false);
            tbl_cus.getColumnModel().getColumn(0).setPreferredWidth(20);
            tbl_cus.getColumnModel().getColumn(1).setResizable(false);
            tbl_cus.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbl_cus.getColumnModel().getColumn(2).setResizable(false);
            tbl_cus.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 340));

        btn_laodQueue.setBackground(new java.awt.Color(0, 51, 102));
        btn_laodQueue.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_laodQueue.setForeground(new java.awt.Color(255, 255, 255));
        btn_laodQueue.setText("Load Queue");
        btn_laodQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laodQueueActionPerformed(evt);
            }
        });
        add(btn_laodQueue, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 130, 30));

        btn_addCus.setBackground(new java.awt.Color(0, 51, 102));
        btn_addCus.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_addCus.setForeground(new java.awt.Color(255, 255, 255));
        btn_addCus.setText("Add Customer");
        btn_addCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addCusActionPerformed(evt);
            }
        });
        add(btn_addCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 130, 30));

        btn_dlt_cus.setBackground(new java.awt.Color(204, 0, 0));
        btn_dlt_cus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_dlt_cus.setForeground(new java.awt.Color(255, 255, 255));
        btn_dlt_cus.setText("Delete Customer");
        btn_dlt_cus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dlt_cusActionPerformed(evt);
            }
        });
        add(btn_dlt_cus, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 343, 130, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_laodQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laodQueueActionPerformed
      
        DefaultTableModel model = (DefaultTableModel) tbl_cus.getModel();
        model.setRowCount(0);

        // Load data from customers.csv
        File csvFile = new File("data/customers.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                
                String[] data = line.split(",");
                model.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading parcels from file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_laodQueueActionPerformed

    private void btn_addCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addCusActionPerformed
         AddCustomersDialog dialog = new AddCustomersDialog((JFrame) SwingUtilities.getWindowAncestor(this), true);
         dialog.setLocationRelativeTo(this); 
        dialog.setVisible(true); 
    }//GEN-LAST:event_btn_addCusActionPerformed

    private void btn_dlt_cusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dlt_cusActionPerformed
  int selectedRow = tbl_cus.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a customer to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String customerID = tbl_cus.getValueAt(selectedRow, 0).toString(); // Assuming Customer ID is in the first column

    List<Customer> customers = new ArrayList<>();
    
    File inputFile = new File("data/customers.csv");
    File tempFile = new File("data/customers_temp.csv");

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

        String line;
        boolean found = false;

        while ((line = reader.readLine()) != null) {
            String[] columns = line.split(",");
            if (columns.length == 3) {
                Customer customer = new Customer(columns[0], columns[1], columns[2]); // Customer ID, Parcel ID, Name
                if (customer.getCustomerId().equals(customerID)) {
                    found = true; 
                    // Log deletion
                    AppLogger.logger.info("Deleted customer: " + customer.toCSV());
                    continue;
                }
                customers.add(customer);
                writer.write(customer.toCSV());
                writer.newLine();
            }
        }

        if (found) {
            JOptionPane.showMessageDialog(this, "Customer deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Customer not found in the file.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error updating file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    
    if (inputFile.delete() && tempFile.renameTo(inputFile)) {
      
        ((javax.swing.table.DefaultTableModel) tbl_cus.getModel()).removeRow(selectedRow);
    } else {
        JOptionPane.showMessageDialog(this, "Error replacing the original file.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btn_dlt_cusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addCus;
    private javax.swing.JButton btn_dlt_cus;
    private javax.swing.JButton btn_laodQueue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel lbl_cus;
    private javax.swing.JTable tbl_cus;
    // End of variables declaration//GEN-END:variables



public class AppLogger {
    public static Logger logger = Logger.getLogger(AppLogger.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("logs/application.log", true); // Append mode
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false); // Disable console output
        } catch (IOException e) {
            System.err.println("Failed to set up logger: " + e.getMessage());
        }
    }
}

}
