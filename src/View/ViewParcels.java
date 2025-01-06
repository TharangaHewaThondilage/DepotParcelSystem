package view;

import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Parcel;

public class ViewParcels extends javax.swing.JPanel {

    public ViewParcels() {
 
        initComponents();     
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_parcel = new javax.swing.JTable();
        btn_loadParcel = new javax.swing.JButton();
        btn_dlt_par = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbl_par = new javax.swing.JLabel();
        btn_newparcel1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_parcel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ParcelID", "DaysInDepot", "Weight", "Lenght", "Width", "Height"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
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
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 460, 340));

        btn_loadParcel.setBackground(new java.awt.Color(0, 51, 102));
        btn_loadParcel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_loadParcel.setForeground(new java.awt.Color(255, 255, 255));
        btn_loadParcel.setText("Load Parcels");
        btn_loadParcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loadParcelActionPerformed(evt);
            }
        });
        add(btn_loadParcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 140, 30));

        btn_dlt_par.setBackground(new java.awt.Color(204, 0, 0));
        btn_dlt_par.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_dlt_par.setForeground(new java.awt.Color(255, 255, 255));
        btn_dlt_par.setText("Delete Parcel");
        btn_dlt_par.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dlt_parActionPerformed(evt);
            }
        });
        add(btn_dlt_par, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 140, 30));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lbl_par.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_par.setForeground(new java.awt.Color(255, 255, 255));
        lbl_par.setText("View Parcel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(lbl_par)
                .addContainerGap(286, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_par)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 30));

        btn_newparcel1.setBackground(new java.awt.Color(0, 51, 102));
        btn_newparcel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_newparcel1.setForeground(new java.awt.Color(255, 255, 255));
        btn_newparcel1.setText("Add New Parcels");
        btn_newparcel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newparcel1ActionPerformed(evt);
            }
        });
        add(btn_newparcel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 140, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loadParcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loadParcelActionPerformed
        
        DefaultTableModel model = (DefaultTableModel) tbl_parcel.getModel();
        model.setRowCount(0);

        File csvFile = new File("data/Parcels.csv");
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
        
    }//GEN-LAST:event_btn_loadParcelActionPerformed

    private void btn_dlt_parActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dlt_parActionPerformed
       int selectedRow = tbl_parcel.getSelectedRow();
         if (selectedRow == -1) {
         JOptionPane.showMessageDialog(this, "Please select a parcel to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String parcelId = tbl_parcel.getValueAt(selectedRow, 0).toString(); 

    File inputFile = new File("data/Parcels.csv");
    File tempFile = new File("data/Parcel_temp.csv");

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

        String line;
        boolean found = false;

        while ((line = reader.readLine()) != null) {
            String[] columns = line.split(",");
            if (columns.length == 6) {
                try {
                    
                    String id = columns[0];
                    int DaysInDepot = Integer.parseInt(columns[1]);
                    double Weight = Double.parseDouble(columns[2]);
                    double Length = Double.parseDouble(columns[3]);
                    double Width = Double.parseDouble(columns[4]);
                    double Height = Double.parseDouble(columns[5]);

                    Parcel currentParcel = new Parcel(id, DaysInDepot, Weight, Length, Width, Height);


                    if (currentParcel.getParcelId().equals(parcelId)) {
                         AppLogger.logger.info("Deleted parcel: " + currentParcel.toCSV());
                        found = true; 
                        continue;
                    }
                    writer.write(currentParcel.toCSV());
                    writer.newLine();
                } catch (NumberFormatException e) {
                    // Handle malformed data in the CSV file
                    JOptionPane.showMessageDialog(this, "Invalid data format in file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }

        if (found) {
            JOptionPane.showMessageDialog(this, "Parcel deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Parcel not found in the file.", "Error", JOptionPane.ERROR_MESSAGE);
        }

     } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error updating file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
     }

     if (inputFile.delete() && tempFile.renameTo(inputFile)) {

        ((javax.swing.table.DefaultTableModel) tbl_parcel.getModel()).removeRow(selectedRow);
     } else {
        JOptionPane.showMessageDialog(this, "Error replacing the original file.", "Error", JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_btn_dlt_parActionPerformed

    private void btn_newparcel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newparcel1ActionPerformed

            // Get the parent frame and pass it to the dialog
    AddParcelDialog dialog = new AddParcelDialog((JFrame) SwingUtilities.getWindowAncestor(this), true);
    dialog.setLocationRelativeTo(this);
    dialog.setVisible(true);
        
      
    }//GEN-LAST:event_btn_newparcel1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dlt_par;
    private javax.swing.JButton btn_loadParcel;
    private javax.swing.JButton btn_newparcel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_par;
    public javax.swing.JTable tbl_parcel;
    // End of variables declaration//GEN-END:variables

    public JTable getTbl_parcel() {
        return tbl_parcel;
    }

    public void setTbl_parcel(JTable tbl_parcel) {
        this.tbl_parcel = tbl_parcel;
    }

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
