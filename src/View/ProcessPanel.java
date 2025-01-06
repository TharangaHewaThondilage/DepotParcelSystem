package view;


import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Parcel;

public class ProcessPanel extends javax.swing.JPanel {
   
   String customerFile, parcelFile ,parcelId ,weightText,dimension;    
   double fee;

    private ViewParcels viewParcel;
    
    public ProcessPanel() {
        initComponents();
         fetchCustomerAndParcelData();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_cusID = new javax.swing.JLabel();
        txt_demention = new javax.swing.JLabel();
        txt_weight = new javax.swing.JLabel();
        txt_proID = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_fee = new javax.swing.JLabel();
        btn_prNxtCus = new javax.swing.JButton();
        btn_mrkProcess = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        log_area = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(153, 255, 255));
        setMinimumSize(new java.awt.Dimension(630, 320));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Process");
        jPanel1.add(jLabel1);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Details", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Dimention");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("ProcessID");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 80, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 102));
        jLabel4.setText("Customer Name");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 102));
        jLabel5.setText("Weight");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        txt_cusID.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txt_cusID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 1, true));
        jPanel2.add(txt_cusID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 140, 20));

        txt_demention.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txt_demention.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 1, true));
        jPanel2.add(txt_demention, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 100, 20));

        txt_weight.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txt_weight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel2.add(txt_weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 80, 20));

        txt_proID.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txt_proID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 1, true));
        jPanel2.add(txt_proID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 90, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setText("Fee");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, -1));

        txt_fee.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 102), 1, true));
        jPanel2.add(txt_fee, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 90, 20));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 610, 100));

        btn_prNxtCus.setBackground(new java.awt.Color(0, 51, 102));
        btn_prNxtCus.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_prNxtCus.setForeground(new java.awt.Color(255, 255, 255));
        btn_prNxtCus.setText("Process Next Customer");
        btn_prNxtCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prNxtCusActionPerformed(evt);
            }
        });
        add(btn_prNxtCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 180, 30));

        btn_mrkProcess.setBackground(new java.awt.Color(0, 51, 102));
        btn_mrkProcess.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_mrkProcess.setForeground(new java.awt.Color(255, 255, 255));
        btn_mrkProcess.setText("Mark Parcel as Processed");
        btn_mrkProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mrkProcessActionPerformed(evt);
            }
        });
        add(btn_mrkProcess, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 190, 30));

        log_area.setColumns(20);
        log_area.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        log_area.setRows(5);
        jScrollPane1.setViewportView(log_area);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 610, 100));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_prNxtCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prNxtCusActionPerformed
        fetchCustomerAndParcelData();
    }//GEN-LAST:event_btn_prNxtCusActionPerformed

    private void btn_mrkProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mrkProcessActionPerformed
         this.customerFile = "data/customers.csv"; 
         this.parcelFile = "data/Parcels.csv"; 

        try {
           
        Parcel selectedParcel = new Parcel(
            txt_proID.getText(),
            0, 
            Double.parseDouble(txt_weight.getText()),
            Double.parseDouble(txt_demention.getText().split("x")[0]), 
            Double.parseDouble(txt_demention.getText().split("x")[1]), 
            Double.parseDouble(txt_demention.getText().split("x")[2]) 
        );
           this.fee = selectedParcel.calculateFee();
           
           txt_fee.setText("$. " + this.fee);
   
            removeProcessedCustomerData(customerFile);
            
            highlightProcessedParcel(parcelFile);

            ViewParcels viewParcelsInstance = new ViewParcels(); 
            updateTblParcel(viewParcelsInstance); 

            logProcessingDetails("logs/application.log" ,fee);

            log_area.append("Processed customer ID: " + txt_cusID.getText() +
                ", Parcel ID: " + txt_proID.getText() + ", Fee: $. " + fee + "\n");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error processing data: " + e.getMessage());
        }
    }

    private void removeProcessedCustomerData(String customerFile) throws IOException {
        File tempCustomerFile = new File("data/customer_temp.csv");
        try (BufferedReader customerReader = new BufferedReader(new FileReader(customerFile));
             BufferedWriter customerWriter = new BufferedWriter(new FileWriter(tempCustomerFile))) {

            String line;
            while ((line = customerReader.readLine()) != null) {
                String[] customerData = line.split(",");
                if (!customerData[1].equals(txt_cusID.getText())) {
                    customerWriter.write(line);
                    customerWriter.newLine();
                }
            }
        }
        new File(customerFile).delete();
        tempCustomerFile.renameTo(new File(customerFile));
    }

    private void highlightProcessedParcel(String parcelFile) throws IOException {
        File tempParcelFile = new File("data/parcel_temp.csv");
        try (BufferedReader parcelReader = new BufferedReader(new FileReader(parcelFile));
             BufferedWriter parcelWriter = new BufferedWriter(new FileWriter(tempParcelFile))) {

            String line;
            while ((line = parcelReader.readLine()) != null) {
                String[] parcelData = line.split(",");
                if (parcelData[0].equals(txt_proID.getText())) {
                 
                    line = line + ",Processed";
                }
                parcelWriter.write(line);
                parcelWriter.newLine();
            }
        }
        new File(parcelFile).delete();
        tempParcelFile.renameTo(new File(parcelFile));
    }

    private void updateTblParcel(ViewParcels viewParcelsInstance) {
        
        JTable tbl_parcel = viewParcelsInstance.tbl_parcel;    
   
        for (int row = 0; row < tbl_parcel.getRowCount(); row++) {
            String parcelID = tbl_parcel.getValueAt(row, 0).toString();
            if (parcelID.equals(txt_proID.getText())) {
                tbl_parcel.setRowSelectionInterval(row, row); 
                tbl_parcel.setSelectionBackground(Color.YELLOW); // Optional: Change row color to highlight
            }
        }
    }

    private void logProcessingDetails(String logFile ,double fee) throws IOException {
         try (BufferedWriter logWriter = new BufferedWriter(new FileWriter(logFile, true))) {
        String logMessage = "Processed customer ID: " + txt_cusID.getText() +
                ", Parcel ID: " + txt_proID.getText() + ", Fee: $. " + fee;
        logWriter.write(logMessage);
        logWriter.newLine();
    }
    }//GEN-LAST:event_btn_mrkProcessActionPerformed


     private void fetchCustomerAndParcelData() {
        this.customerFile = "data/customers.csv"; 
        this.parcelFile = "data/Parcels.csv"; 
        
        txt_fee.setText("");
        
        try {
            // Step 1: Read the first row from customer.csv
            String[] customerData = null;
            try (BufferedReader customerReader = new BufferedReader(new FileReader(customerFile))) {
                String line = customerReader.readLine(); 
                if (line != null) {
                    customerData = line.split(","); 
                    if (customerData.length >= 3) {
                        txt_cusID.setText(customerData[1]); 
                        txt_proID.setText(customerData[2]); 
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid customer data format in CSV.");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Customer CSV is empty.");
                    return;
                }
            }
              
            String processID = txt_proID.getText();
            
            boolean matchFound = false;  
            // Step 2: Read the corresponding row from Parcel.csv
            try (BufferedReader parcelReader = new BufferedReader(new FileReader(parcelFile))) {
                 String line;
             while ((line = parcelReader.readLine()) != null) { 
               String[] parcelData = line.split(","); 
                if (parcelData.length >= 6 && parcelData[0].equals(processID)) {
                  txt_weight.setText(parcelData[2]); // Set Weight (Column 3)
                  txt_demention.setText(parcelData[3] + " x " + parcelData[4] + " x " + parcelData[5]);
                matchFound = true;
             break; 
        }
    }

    if (!matchFound) {
        JOptionPane.showMessageDialog(this, "No matching parcel data found for Process ID: " + processID);
    }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading CSV files: " + e.getMessage());
        }
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_mrkProcess;
    private javax.swing.JButton btn_prNxtCus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea log_area;
    private javax.swing.JLabel txt_cusID;
    private javax.swing.JLabel txt_demention;
    private javax.swing.JLabel txt_fee;
    private javax.swing.JLabel txt_proID;
    private javax.swing.JLabel txt_weight;
    // End of variables declaration//GEN-END:variables
}
