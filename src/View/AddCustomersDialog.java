package view;

import java.io.*;
import java.util.List;
import javax.swing.*;
import java.util.ArrayList;


public class AddCustomersDialog extends java.awt.Dialog {
    
    String customerID,customerName,parcelID ,line;
    
    
    private List<String> parcelIDs;

    public AddCustomersDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadParcelIDs();
        loadNextCustomerID();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_cusID = new javax.swing.JTextField();
        btn_addcus = new javax.swing.JButton();
        cmb_parID = new javax.swing.JComboBox<>();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ParcelID");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 100, -1));

        jLabel2.setText("CustomerID");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 70, -1));

        jLabel3.setText("Customer Name");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 100, -1));
        add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 110, -1));
        add(txt_cusID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 110, -1));

        btn_addcus.setBackground(new java.awt.Color(0, 51, 102));
        btn_addcus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_addcus.setForeground(new java.awt.Color(255, 255, 255));
        btn_addcus.setText("ADD");
        btn_addcus.setToolTipText("");
        btn_addcus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addcusActionPerformed(evt);
            }
        });
        add(btn_addcus, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        add(cmb_parID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 110, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btn_addcusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addcusActionPerformed
          
        this.customerID = txt_cusID.getText().trim();
        this.customerName = txt_name.getText().trim();
        this.parcelID = (String) cmb_parID.getSelectedItem();

        if (customerName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Customer name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (parcelID == null || parcelID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a Parcel ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        saveCustomerToFile(customerID, customerName, parcelID);
        JOptionPane.showMessageDialog(this, "Customer added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private void loadParcelIDs() {
        parcelIDs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/Parcels.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length > 0) {
                    parcelIDs.add(columns[0]);
                }
            }
            for (String parcelID : parcelIDs) {
                cmb_parID.addItem(parcelID);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading Parcel IDs: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadNextCustomerID() {
          int nextID = 1;
    try (BufferedReader reader = new BufferedReader(new FileReader("data/customers.csv"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] columns = line.split(",");
            if (columns.length > 0) {
                String customerID = columns[0];
                if (customerID.startsWith("C")) {
                    try {
                        // Extract the numeric part after 'C'
                        int id = Integer.parseInt(customerID.substring(1));
                        if (id >= nextID) {
                            nextID = id + 1;
                        }
                    } catch (NumberFormatException ignored) {
                       
                    }
                }
            }
        }
     } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error loading Customer IDs: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
     }
       txt_cusID.setText("C" + String.format("%03d", nextID));

    }

    private void saveCustomerToFile(String customerID, String customerName, String parcelID) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/customers.csv", true))) {
            writer.write(customerID + "," + customerName + "," + parcelID);
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving customer: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    

    }//GEN-LAST:event_btn_addcusActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddCustomersDialog dialog = new AddCustomersDialog(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addcus;
    private javax.swing.JComboBox<String> cmb_parID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txt_cusID;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables
}
