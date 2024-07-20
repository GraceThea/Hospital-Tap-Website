

import java.awt.Image;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Staff;

public class StaffHistory extends javax.swing.JFrame {
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    Staff currentStaff;
    
    public StaffHistory() {
        initComponents();
        
        // LOGO
        ImageIcon templogo = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\logo.png");
        Image scaledlogo = templogo.getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH); 
        ImageIcon finallogo = new ImageIcon(scaledlogo);
        logo.setIcon(finallogo);
        logo.setText("");
        
        // DOC PP
        ImageIcon tempPP = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\doctor picked.png");
        Image scaledPP = tempPP.getImage().getScaledInstance(25,30,Image.SCALE_SMOOTH); 
        ImageIcon finalPP = new ImageIcon(scaledPP);
        docpp.setIcon(finalPP);
        docpp.setText("");
        
        // X ICON
        ImageIcon tempx = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\x.png");
        Image scaledx = tempx.getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH); 
        ImageIcon finalx = new ImageIcon(scaledx);
        x.setIcon(finalx);
        x.setText("");
        
        // ICON
        ImageIcon tempicon = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\icon white.png");
        Image scaledicon = tempicon.getImage().getScaledInstance(25,15,Image.SCALE_SMOOTH); 
        ImageIcon finalicon = new ImageIcon(scaledicon);
        icon.setIcon(finalicon);
        icon.setText("");
        
        // ALL ICON
        ImageIcon tempall = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\all.png");
        Image scaledall = tempall.getImage().getScaledInstance(35,25,Image.SCALE_SMOOTH); 
        ImageIcon finalall = new ImageIcon(scaledall);
        allB.setIcon(finalall);
        allB.setText("");
        
        // INBOX ICON
        ImageIcon tempinbox = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\inbox.png");
        Image scaledinbox = tempinbox.getImage().getScaledInstance(35,25,Image.SCALE_SMOOTH); 
        ImageIcon finalinbox = new ImageIcon(scaledinbox);
        inboxB.setIcon(finalinbox);
        inboxB.setText("");
        
        // PAST ICON
        ImageIcon temppast = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester1_FinalProject\\src\\past white.png");
        Image scaledpast = temppast.getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH); 
        ImageIcon finalpast = new ImageIcon(scaledpast);
        historyB.setIcon(finalpast);
        historyB.setText("");
    }
    
    StaffHistory(Staff currentStaff){
        
        this();
        this.currentStaff=currentStaff;


        name.setText(currentStaff.getStaffName());
        
        displayPrevious();
        
        try{
            // CHECK IF THERE IS ANY UNPAID APPOINTMENTS
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");
            String sql = "SELECT * FROM appointments WHERE (purchaseStatus=?) OR (purchaseStatus=?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, "waiting for confirmation");
            pst.setString(2, "unpaid");
            rs = pst.executeQuery();
            if(rs.next()){
                ImageIcon tempinbox = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Login_SQL\\src\\notif grey.png");
                Image scaledinbox = tempinbox.getImage().getScaledInstance(35,25,Image.SCALE_SMOOTH); 
                ImageIcon finalinbox = new ImageIcon(scaledinbox);
                inboxB.setIcon(finalinbox);
                inboxB.setText("");
            }
            else{
                ImageIcon tempinbox = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Login_SQL\\src\\inbox.png");
                Image scaledinbox = tempinbox.getImage().getScaledInstance(35,25,Image.SCALE_SMOOTH); 
                ImageIcon finalinbox = new ImageIcon(scaledinbox);
                inboxB.setIcon(finalinbox);
                inboxB.setText("");
            }
        }
        
        catch(Exception ex){
            System.out.println(ex);
        }
        
        
    }
    
    // DISPLAY PREVIOUS APPOINTMENTS
    public void displayPrevious(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");
            String sql= "SELECT * FROM appointments WHERE purchaseStatus=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, "paid");
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table1.getModel();
            clearTable();
            while(rs.next()){
                model.addRow(new String[]{"A00"+rs.getString(1),rs.getString(2),"P00"+rs.getString(3),rs.getString(4),"D00"+rs.getString(5),rs.getString(6),"Rp. "+rs.getString(12),rs.getString(13)});
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    // CLEAR TABLE
    public void clearTable(){ 
        ((DefaultTableModel)table1.getModel()).setNumRows(0);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        emptyData = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        inboxB = new javax.swing.JButton();
        historyB = new javax.swing.JButton();
        allB = new javax.swing.JButton();
        logoutB = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        x = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        docpp = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel1.setText("Previous appoinments");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "Patient ID", "Patient name", "Doctor ID", "Doctor name", "Price", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table1);

        emptyData.setFont(new java.awt.Font("DengXian", 2, 12)); // NOI18N
        emptyData.setForeground(new java.awt.Color(255, 0, 0));

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));
        jPanel3.setPreferredSize(new java.awt.Dimension(93, 255));

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setText("icon");

        inboxB.setFont(new java.awt.Font("DengXian", 1, 14)); // NOI18N
        inboxB.setForeground(new java.awt.Color(153, 153, 153));
        inboxB.setText("Inbox");
        inboxB.setBorder(null);
        inboxB.setBorderPainted(false);
        inboxB.setContentAreaFilled(false);
        inboxB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inboxBActionPerformed(evt);
            }
        });

        historyB.setFont(new java.awt.Font("DengXian", 1, 14)); // NOI18N
        historyB.setForeground(new java.awt.Color(153, 153, 153));
        historyB.setText("Past appointments");
        historyB.setBorder(null);
        historyB.setBorderPainted(false);
        historyB.setContentAreaFilled(false);
        historyB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyBActionPerformed(evt);
            }
        });

        allB.setFont(new java.awt.Font("DengXian", 1, 14)); // NOI18N
        allB.setForeground(new java.awt.Color(153, 153, 153));
        allB.setText("ALL");
        allB.setBorder(null);
        allB.setBorderPainted(false);
        allB.setContentAreaFilled(false);
        allB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allBActionPerformed(evt);
            }
        });

        logoutB.setBackground(new java.awt.Color(153, 204, 255));
        logoutB.setFont(new java.awt.Font("DengXian", 1, 14)); // NOI18N
        logoutB.setForeground(new java.awt.Color(255, 255, 255));
        logoutB.setText("Log out");
        logoutB.setActionCommand("");
        logoutB.setBorder(null);
        logoutB.setBorderPainted(false);
        logoutB.setContentAreaFilled(false);
        logoutB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(allB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(historyB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(logoutB, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(inboxB, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inboxB, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historyB, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(allB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addComponent(logoutB)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));

        x.setFont(new java.awt.Font("DengXian", 0, 14)); // NOI18N
        x.setText("Exit");
        x.setBorderPainted(false);
        x.setContentAreaFilled(false);
        x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xActionPerformed(evt);
            }
        });

        name.setFont(new java.awt.Font("DengXian", 1, 14)); // NOI18N
        name.setText("NAME");

        docpp.setText("pp");

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 36)); // NOI18N
        jLabel15.setText("Hospital Tap");

        logo.setText("jLabel8");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 580, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(x, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(docpp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(name))
                            .addComponent(docpp)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(9, 9, 9)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(emptyData, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(emptyData, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inboxBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inboxBActionPerformed
        new StaffMenu(currentStaff).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_inboxBActionPerformed

    private void historyBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBActionPerformed
        
    }//GEN-LAST:event_historyBActionPerformed

    private void allBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allBActionPerformed
        new StaffAll(currentStaff).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_allBActionPerformed

    private void logoutBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Are you sure to log out?", "Log out",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
            LandingPage landing = new LandingPage();
            landing.setVisible(true);
            setVisible(false);
        }

        else{
        }
    }//GEN-LAST:event_logoutBActionPerformed

    private void xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xActionPerformed
        System.exit(0);
    }//GEN-LAST:event_xActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton allB;
    private javax.swing.JLabel docpp;
    private javax.swing.JLabel emptyData;
    private javax.swing.JButton historyB;
    private javax.swing.JLabel icon;
    private javax.swing.JButton inboxB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton logoutB;
    private javax.swing.JLabel name;
    private javax.swing.JTable table1;
    private javax.swing.JButton x;
    // End of variables declaration//GEN-END:variables
}
