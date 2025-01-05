
package View;

import Controller.Manager;
import Model.Customer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class addCustomerDetails extends java.awt.Dialog {

  
    public addCustomerDetails(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadParcelIDs();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        comb_parId = new javax.swing.JComboBox<>();
        add_cusQ = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_cusQ = new javax.swing.JTextField();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("ParcelID");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 110, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Customer Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, -1));
        add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 120, -1));

        add(comb_parId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 120, -1));

        add_cusQ.setText("ADD");
        add_cusQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_cusQActionPerformed(evt);
            }
        });
        add(add_cusQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Customer No");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));
        add(txt_cusQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 120, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void add_cusQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_cusQActionPerformed
    // Ensure the Manager object is created and used
    Manager manager = new Manager();
    // Get the next available customer queue number and set it to txt_cusQ (non-editable)
    int nextCustomerQueueNo = manager.getNextCustomerQueueNo();
    txt_cusQ.setText(String.valueOf(nextCustomerQueueNo));
    txt_cusQ.setEditable(false); // Disable editing of txt_cusQ

    // Get the other input values from text fields and combo box
    String name = txt_name.getText().trim();  // Assuming txt_name is the name text field
    String parcelID = comb_parId.getSelectedItem().toString(); // Assuming comb_parId is a combo box for Parcel ID

    // Validate that fields are filled
    if (name.isEmpty() || parcelID.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Create a new Customer object
    Customer newCustomer = new Customer(nextCustomerQueueNo, name, parcelID);

    // Add the customer to the queue and save to Custs.csv
    manager.addCustomerToQueue(newCustomer);

    // Optionally, show a message indicating success
    JOptionPane.showMessageDialog(this, "Customer added to queue successfully.");
    
    // Clear the other fields after adding
    txt_name.setText("");
    comb_parId.setSelectedIndex(0);  // Reset combo box
    }//GEN-LAST:event_add_cusQActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                addCustomerDetails dialog = new addCustomerDetails(new java.awt.Frame(), true);
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
    private javax.swing.JButton add_cusQ;
    private javax.swing.JComboBox<String> comb_parId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txt_cusQ;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables

   private void loadParcelIDs() {

    comb_parId.removeAllItems();

    try (BufferedReader reader = new BufferedReader(new FileReader("resources/Parcels.csv"))) {
        String line;
        
        // Read each line from the CSV
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");

            String parcelID = data[0].trim();

            comb_parId.addItem(parcelID);
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error reading from file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
}
