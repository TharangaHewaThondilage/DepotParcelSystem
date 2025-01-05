package View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import View.DepotMain;
import java.io.FileWriter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Prasad
 */
public class ParcelsToProcessPanel extends javax.swing.JPanel {

  
    public ParcelsToProcessPanel() {
       
        initComponents();
         SwingUtilities.invokeLater(() -> loadDataToTable());
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_parcel = new javax.swing.JTable();
        btn_addParcel = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        btn_dltP = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_parcel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ParcelID", "Days in Depot", "Weight", "Lenght", "Width", "Height", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_parcel);
        if (tbl_parcel.getColumnModel().getColumnCount() > 0) {
            tbl_parcel.getColumnModel().getColumn(0).setResizable(false);
            tbl_parcel.getColumnModel().getColumn(1).setResizable(false);
            tbl_parcel.getColumnModel().getColumn(2).setResizable(false);
            tbl_parcel.getColumnModel().getColumn(3).setResizable(false);
            tbl_parcel.getColumnModel().getColumn(4).setResizable(false);
            tbl_parcel.getColumnModel().getColumn(5).setResizable(false);
            tbl_parcel.getColumnModel().getColumn(6).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 460, 336));

        btn_addParcel.setText("ADD Parcels");
        btn_addParcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addParcelActionPerformed(evt);
            }
        });
        add(btn_addParcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        btn_refresh.setText("Refersh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });
        add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, -1, -1));

        btn_dltP.setText("Delete");
        btn_dltP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dltPActionPerformed(evt);
            }
        });
        add(btn_dltP, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addParcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addParcelActionPerformed
       
    addParcelDetails dialog = new  addParcelDetails((JFrame) SwingUtilities.getWindowAncestor(this), true);
    dialog.setLocationRelativeTo(this);
    dialog.setVisible(true);
    }//GEN-LAST:event_btn_addParcelActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
       loadDataToTable();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_dltPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dltPActionPerformed
        // Get the selected row from the table
    int selectedRow = tbl_parcel.getSelectedRow();

    if (selectedRow == -1) {
        // If no row is selected, show an error message
        JOptionPane.showMessageDialog(this, "Please select a parcel to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Get the Parcel ID of the selected row (assuming Parcel ID is in column 0)
    String parcelID = tbl_parcel.getValueAt(selectedRow, 0).toString();

    // Confirm deletion
    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete parcel " + parcelID + "?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.NO_OPTION) {
        return; // If user clicks 'No', do nothing
    }

    // Remove the selected row from the table
    DefaultTableModel model = (DefaultTableModel) tbl_parcel.getModel();
    model.removeRow(selectedRow);

    // Log the deletion activity
    logActivity("Deleted parcel: " + parcelID + " at " + java.time.LocalDateTime.now());

    // Optionally, update the CSV file if you need to reflect this change
    updateCSVFile();
    }//GEN-LAST:event_btn_dltPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addParcel;
    private javax.swing.JButton btn_dltP;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbl_parcel;
    // End of variables declaration//GEN-END:variables
   
    public void loadDataToTable(){
       String filePath = "resources/Parcels.csv";  // Path to the CSV file
       DefaultTableModel model = (DefaultTableModel) tbl_parcel.getModel();

    // Clear existing rows in the table
    model.setRowCount(0);

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");  // Split the line by commas

            // Check if parcel is marked as collected
            String status = (values.length > 6 && values[6].equalsIgnoreCase("Collected")) ? "Collected" : "Pending";

            // Add row to table with parcel details and status
            model.addRow(new Object[] {
                values[0],  // Parcel ID
                values[1],  // Length
                values[2],  // Width
                values[3],  // Height
                values[4],  // Weight
                values[5],  // Days in Depot
                status      // Status (Pending or Collected)
            });
        }
    } catch (IOException e) {
        System.out.println("Error loading data: " + e.getMessage());
    }
    
    }
    
    // Method to log the deletion event to a log file
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
    try (FileWriter writer = new FileWriter("resources/Parcels.csv")) {
        DefaultTableModel model = (DefaultTableModel) tbl_parcel.getModel();
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String parcelID = model.getValueAt(i, 0).toString();
            String daysInDepot = model.getValueAt(i, 1).toString();
            String weight = model.getValueAt(i, 2).toString();
            String length = model.getValueAt(i, 3).toString();
            String width = model.getValueAt(i, 4).toString();
            String height = model.getValueAt(i, 5).toString();
         

            String csvLine = String.format("%s,%s,%s,%s,%s,%s", parcelID,daysInDepot, weight, length,  width, height);
            writer.append(csvLine).append("\n");
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error updating CSV file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
}
