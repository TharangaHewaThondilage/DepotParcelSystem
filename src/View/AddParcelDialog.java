package view;

import javax.swing.JOptionPane;
import java.io.*;


public class AddParcelDialog extends java.awt.Dialog {

    public AddParcelDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_pid = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_height = new javax.swing.JTextField();
        txt_parID1 = new javax.swing.JTextField();
        txt_deyDep1 = new javax.swing.JTextField();
        txt_weight1 = new javax.swing.JTextField();
        txt_lenght1 = new javax.swing.JTextField();
        txt_width = new javax.swing.JTextField();
        btn_addParcel = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_pid.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        txt_pid.setText("ParcelID  ");
        add(txt_pid, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setText("DaysInDepot");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("Width");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setText("Weight");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 90, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setText("Lenght");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 80, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setText("Height");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));
        add(txt_height, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 120, -1));
        add(txt_parID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 120, -1));
        add(txt_deyDep1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 120, -1));
        add(txt_weight1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 120, -1));
        add(txt_lenght1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 120, -1));
        add(txt_width, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 120, -1));

        btn_addParcel.setBackground(new java.awt.Color(0, 51, 102));
        btn_addParcel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_addParcel.setForeground(new java.awt.Color(255, 255, 255));
        btn_addParcel.setText("Add");
        btn_addParcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addParcelActionPerformed(evt);
            }
        });
        add(btn_addParcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btn_addParcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addParcelActionPerformed
        // Validate inputs
        if (txt_parID1.getText().isEmpty() || txt_deyDep1.getText().isEmpty() ||
            txt_weight1.getText().isEmpty() || txt_lenght1.getText().isEmpty() ||
            txt_width.getText().isEmpty() || txt_height.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if all inputs are numbers
        if (!isNumeric(txt_lenght1.getText()) || !isNumeric(txt_height.getText()) ||
            !isNumeric(txt_deyDep1.getText()) || !isNumeric(txt_weight1.getText()) ||
            !isNumeric(txt_width.getText())) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for dimensions and weight.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if ParcelID already exists in the CSV file
        if (isParcelIDExists(txt_parID1.getText())) {
            JOptionPane.showMessageDialog(this, "ParcelID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Save data to Parcel.csv
        saveParcelToCSV();

        JOptionPane.showMessageDialog(this, "Parcel added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        setVisible(false);
        dispose();
        
    }//GEN-LAST:event_btn_addParcelActionPerformed
      private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str); // Try converting to number
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isParcelIDExists(String parcelID) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/Parcels.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(parcelID)) { 
                    reader.close();
                    return true;
                }
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private void saveParcelToCSV() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("data/Parcels.csv", true));
            writer.append(txt_parID1.getText() + ",");
            writer.append(txt_deyDep1.getText() + ",");
            writer.append(txt_weight1.getText() + ",");
            writer.append(txt_lenght1.getText() + ",");
            writer.append(txt_width.getText() + ",");
            writer.append(txt_height.getText() + "\n");
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving parcel data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddParcelDialog dialog = new AddParcelDialog(new java.awt.Frame(), true);
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
    private javax.swing.JButton btn_addParcel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_deyDep1;
    private javax.swing.JTextField txt_height;
    private javax.swing.JTextField txt_lenght1;
    private javax.swing.JTextField txt_parID1;
    private javax.swing.JLabel txt_pid;
    private javax.swing.JTextField txt_weight1;
    private javax.swing.JTextField txt_width;
    // End of variables declaration//GEN-END:variables
}
