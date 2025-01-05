package View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class CustomerQueuePanel extends javax.swing.JPanel {

   
    public CustomerQueuePanel() {
        initComponents();
        SwingUtilities.invokeLater(() -> loadCusDataToTable());
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_customer = new javax.swing.JTable();
        btn_addCus = new javax.swing.JButton();
        btn_RefreshCus = new javax.swing.JButton();
        dlt_cus = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CustomerID", "Cutomer Name", "ParcelID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_customer);
        if (tbl_customer.getColumnModel().getColumnCount() > 0) {
            tbl_customer.getColumnModel().getColumn(0).setResizable(false);
            tbl_customer.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbl_customer.getColumnModel().getColumn(1).setResizable(false);
            tbl_customer.getColumnModel().getColumn(2).setResizable(false);
            tbl_customer.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 303, 340));

        btn_addCus.setText("ADD");
        btn_addCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addCusActionPerformed(evt);
            }
        });
        add(btn_addCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        btn_RefreshCus.setText("Refresh");
        btn_RefreshCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RefreshCusActionPerformed(evt);
            }
        });
        add(btn_RefreshCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, -1, -1));

        dlt_cus.setText("Delete");
        dlt_cus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlt_cusActionPerformed(evt);
            }
        });
        add(dlt_cus, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addCusActionPerformed
       addCustomerDetails dialog = new  addCustomerDetails((JFrame) SwingUtilities.getWindowAncestor(this), true);
       dialog.setLocationRelativeTo(this);
       dialog.setVisible(true);
    }//GEN-LAST:event_btn_addCusActionPerformed

    private void dlt_cusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlt_cusActionPerformed
        // Get the selected row from the table
    int selectedRow = tbl_customer.getSelectedRow();

    if (selectedRow == -1) {
        // If no row is selected, show an error message
        JOptionPane.showMessageDialog(this, "Please select a customer to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Get the Parcel ID of the selected row (assuming Parcel ID is in column 0)
    String customerN = tbl_customer.getValueAt(selectedRow, 1).toString();

    // Confirm deletion
    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete customer " + customerN + "?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.NO_OPTION) {
        return; // If user clicks 'No', do nothing
    }

    // Remove the selected row from the table
    DefaultTableModel model = (DefaultTableModel) tbl_customer.getModel();
    model.removeRow(selectedRow);

    // Log the deletion activity
    logActivity("Deleted customer: " + customerN + " at " + java.time.LocalDateTime.now());

    // Optionally, update the CSV file if you need to reflect this change
    updateCSVFile();
    }//GEN-LAST:event_dlt_cusActionPerformed

    private void btn_RefreshCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshCusActionPerformed
        loadCusDataToTable();
    }//GEN-LAST:event_btn_RefreshCusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_RefreshCus;
    private javax.swing.JButton btn_addCus;
    private javax.swing.JButton dlt_cus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_customer;
    // End of variables declaration//GEN-END:variables
     
    public void loadCusDataToTable(){
       String filePath = "resources/Custs.csv";  // Path to the CSV file
       DefaultTableModel model = (DefaultTableModel) tbl_customer.getModel();

    // Clear existing rows in the table
    model.setRowCount(0);

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");  // Split the line by commas

            // Add row to table with parcel details and status
            model.addRow(new Object[] {
                values[0],  
                values[1],  
                values[2]
            });
        }
    } catch (IOException e) {
        System.out.println("Error loading data: " + e.getMessage());
    }
    
    }
    private void logActivity(String message) {
    try (FileWriter logWriter = new FileWriter("resources/logfile.txt", true)) {
        logWriter.append(message).append("\n");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error writing to log file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// Method to update the CSV file after deletion (Optional)
  private void updateCSVFile() {
    // You may re-write the table data to the CSV file after deletion
    try (FileWriter writer = new FileWriter("resources/Custs.csv")) {
        DefaultTableModel model = (DefaultTableModel) tbl_customer.getModel();
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String customerlID = model.getValueAt(i, 0).toString();
            String customerName = model.getValueAt(i, 1).toString();
            String ParcelID = model.getValueAt(i, 2).toString();
   
            String csvLine = String.format("%s,%s,%s", customerlID,customerName, ParcelID);
            writer.append(csvLine).append("\n");
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error updating CSV file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
}
