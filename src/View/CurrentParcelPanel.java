package View;

import Controller.Worker;
import Model.CustomerQueue;
import Model.Log;
import Model.ParcelMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Prasad
 */
public class CurrentParcelPanel extends javax.swing.JPanel {

    /**
     * Creates new form CurrentParcelPanel
     */
    public CurrentParcelPanel() {
        initComponents();
        loadCustomerDetails();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_PcusName = new javax.swing.JTextField();
        txt_PparID = new javax.swing.JTextField();
        txt_Pdays = new javax.swing.JTextField();
        txt_Pweight = new javax.swing.JTextField();
        btn_update = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_calFee = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Days In Depot");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 90, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Weight");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 70, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("ParcelID");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 70, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Customer Name");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, -1));
        add(txt_PcusName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 150, -1));
        add(txt_PparID, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 90, -1));
        add(txt_Pdays, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 90, -1));
        add(txt_Pweight, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 100, -1));

        btn_update.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 100, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Fee");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, -1));
        add(txt_calFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, 140, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        
    }//GEN-LAST:event_btn_updateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_PcusName;
    private javax.swing.JTextField txt_Pdays;
    private javax.swing.JTextField txt_PparID;
    private javax.swing.JTextField txt_Pweight;
    private javax.swing.JTextField txt_calFee;
    // End of variables declaration//GEN-END:variables
    
      private void loadCustomerDetails() {
        try {
            // Read Customer.csv into a HashMap
            BufferedReader customerReader = new BufferedReader(new FileReader("resources/Custs.csv"));
            HashMap<String, String> customerMap = new HashMap<>();

               String line;
            while ((line = customerReader.readLine()) != null) {
                String[] parts = line.split(",");
                String customerName = parts[1];
                String parcelID = parts[2];
                customerMap.put(parcelID, customerName);
            }
            customerReader.close();

            // Read Parcel.csv and display the first customer's details
            BufferedReader parcelReader = new BufferedReader(new FileReader("resources/Parcels.csv"));

            if ((line = parcelReader.readLine()) != null) {
                String[] parts = line.split(",");
                String parcelID = parts[0];
                String customerName = customerMap.get(parcelID);

                txt_PcusName.setText(customerName);
                txt_PparID.setText(parcelID);
                txt_Pdays.setText(parts[1]);
                txt_Pweight.setText(parts[2]);
            }
            parcelReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
     private void updateParcelStatusInTable(String parcelID) {
         ParcelsToProcessPanel Parcelprocess = new ParcelsToProcessPanel();
    for (int row = 0; row < Parcelprocess.tbl_parcel.getRowCount(); row++) {
        if (Parcelprocess.tbl_parcel.getValueAt(row, 0).toString().equals(parcelID)) {
            Parcelprocess.tbl_parcel.setValueAt("Collected", row, 7); // Assuming status is in column 3
            break;
        }
    }
}

     private void writeLogEntry(String customerName, String parcelID) {
    try (FileWriter fw = new FileWriter("logfile.txt", true);
         BufferedWriter bw = new BufferedWriter(fw)) {

        String logEntry = String.format("Parcel ID: %s collected by %s on %s\n",
                parcelID, customerName, java.time.LocalDate.now());

        bw.write(logEntry);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
     
   

}
