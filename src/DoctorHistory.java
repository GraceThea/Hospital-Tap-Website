


import java.sql.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DoctorHistory extends javax.swing.JFrame {

    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel model;
    
    String DOCSNAME;
    int DOCSID;
    
    
    public DoctorHistory() {
        initComponents();
        
        // LOGO
        ImageIcon templogo = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\logos.png");
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
        
        // INBOX ICON
        ImageIcon tempinbox = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\inbox.png");
        Image scaledinbox = tempinbox.getImage().getScaledInstance(35,25,Image.SCALE_SMOOTH); 
        ImageIcon finalinbox = new ImageIcon(scaledinbox);
        inboxB.setIcon(finalinbox);
        inboxB.setText("");
        
        // PAST ICON
        ImageIcon temppast = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\past white.png");
        Image scaledpast = temppast.getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH); 
        ImageIcon finalpast = new ImageIcon(scaledpast);
        historyB.setIcon(finalpast);
        historyB.setText("");
    }
    
    DoctorHistory(String docsName, int docsID) {
        
        this();
        this.DOCSID=docsID;
        this.DOCSNAME=docsName;
        
        jLabel9.setText(null);
        name.setText("Dr. "+DOCSNAME);
        
        clearTable();
        displayPrevious();
        
        // CHECK IF THERE IS NOTIF
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");
            String sql= "SELECT * FROM appointments WHERE docsID=? and docsNote IS NULL";
            pst = con.prepareStatement(sql);
            pst.setInt(1, DOCSID);
            rs = pst.executeQuery();
            if(rs.next()){
                ImageIcon tempinbox = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Login_SQL\\src\\notif grey.png");
                Image scaledinbox = tempinbox.getImage().getScaledInstance(35,25,Image.SCALE_SMOOTH); 
                ImageIcon finalinbox = new ImageIcon(scaledinbox);
                inboxB.setIcon(finalinbox);
                inboxB.setText("");
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }

//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    // DISPLAY PREVIOUS APPOINTMENTS
    public void displayPrevious(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");
            String sql= "SELECT * FROM appointments WHERE docsID=? and docsNote IS NOT NULL";
            pst = con.prepareStatement(sql);
            pst.setInt(1, DOCSID);
            rs = pst.executeQuery();
            model = (DefaultTableModel)previousT.getModel();
            while(rs.next()){
                model.addRow(new String[]{"A00"+rs.getString(1),rs.getString(2) +" at "+ rs.getString(14),"P00"+rs.getString(3),rs.getString(4),rs.getString(7),rs.getString(10)});
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    // CLEAR TABLE
    public void clearTable(){ 
        ((DefaultTableModel)previousT.getModel()).setNumRows(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        previousT = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        historyB = new javax.swing.JButton();
        inboxB = new javax.swing.JButton();
        logoutB = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        x = new javax.swing.JButton();
        docpp = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel8.setText("Previous appointment");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 179, -1));

        previousT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date/Time", "Patient ID", "Patient", "Notes", "Medicine"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        previousT.getTableHeader().setReorderingAllowed(false);
        previousT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                previousTMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(previousT);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 158, 974, 340));

        jLabel9.setFont(new java.awt.Font("DengXian", 2, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 419, 192, 22));

        jPanel4.setBackground(new java.awt.Color(255, 255, 153));

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setText("icon");

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

        inboxB.setFont(new java.awt.Font("DengXian", 1, 14)); // NOI18N
        inboxB.setForeground(new java.awt.Color(153, 153, 153));
        inboxB.setText("Inbox");
        inboxB.setBorder(null);
        inboxB.setBorderPainted(false);
        inboxB.setContentAreaFilled(false);
        inboxB.setMaximumSize(new java.awt.Dimension(334, 196));
        inboxB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inboxBActionPerformed(evt);
            }
        });

        logoutB.setBackground(new java.awt.Color(204, 204, 0));
        logoutB.setFont(new java.awt.Font("DengXian", 1, 14)); // NOI18N
        logoutB.setForeground(new java.awt.Color(255, 255, 255));
        logoutB.setText("Log out");
        logoutB.setBorder(null);
        logoutB.setBorderPainted(false);
        logoutB.setContentAreaFilled(false);
        logoutB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inboxB, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(logoutB, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(historyB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inboxB, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historyB, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutB)
                .addContainerGap())
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 520));

        jPanel2.setBackground(new java.awt.Color(255, 204, 51));

        name.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        name.setText("NAME");

        x.setFont(new java.awt.Font("DengXian", 0, 14)); // NOI18N
        x.setText("Exit");
        x.setBorderPainted(false);
        x.setContentAreaFilled(false);
        x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xActionPerformed(evt);
            }
        });

        docpp.setText("pp");

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 36)); // NOI18N
        jLabel15.setText("Hospital Tap");

        logo.setText("jLabel8");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 588, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(docpp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(name))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(docpp)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 0, 1070, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void historyBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBActionPerformed

    }//GEN-LAST:event_historyBActionPerformed

    private void inboxBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inboxBActionPerformed
        new DoctorMenu(DOCSNAME, DOCSID).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_inboxBActionPerformed

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

    private void previousTMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previousTMouseReleased

    }//GEN-LAST:event_previousTMouseReleased

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
            java.util.logging.Logger.getLogger(DoctorHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel docpp;
    private javax.swing.JButton historyB;
    private javax.swing.JLabel icon;
    private javax.swing.JButton inboxB;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel logo;
    private javax.swing.JButton logoutB;
    private javax.swing.JLabel name;
    private javax.swing.JTable previousT;
    private javax.swing.JButton x;
    // End of variables declaration//GEN-END:variables
}
