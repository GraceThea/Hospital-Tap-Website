
import java.awt.Image;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DBConnection;
import model.Staff;

public class StaffMenu extends javax.swing.JFrame {
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    //  Current Logged In Staff
    Staff currentStaff;
    
    String MEDICINE;
    int medsPrice;
    int DOCSID;
    String DOCSNAME;
    int docsPrice;
    int TOTALPRICE;
    
    public StaffMenu() {
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
        
        // ALL ICON
        ImageIcon tempall = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\all.png");
        Image scaledall = tempall.getImage().getScaledInstance(35,25,Image.SCALE_SMOOTH); 
        ImageIcon finalall = new ImageIcon(scaledall);
        allB.setIcon(finalall);
        allB.setText("");
        
        // INBOX ICON
        ImageIcon tempinbox = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\inbox white.png");
        Image scaledinbox = tempinbox.getImage().getScaledInstance(35,25,Image.SCALE_SMOOTH); 
        ImageIcon finalinbox = new ImageIcon(scaledinbox);
        inboxB.setIcon(finalinbox);
        inboxB.setText("");
        
        // PAST ICON
        ImageIcon temppast = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\past.png");
        Image scaledpast = temppast.getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH); 
        ImageIcon finalpast = new ImageIcon(scaledpast);
        historyB.setIcon(finalpast);
        historyB.setText("");
    }
    
    StaffMenu(Staff currentStaff){
        this();
        this.currentStaff=currentStaff;
        

        name.setText(currentStaff.getStaffName());
    
        displayUnconfirmed();
        displayUnpaid();
        checkNotif();
        
    }
    

// DISPLAY UNCONFIRMED APPOINTMENTS
    public void displayUnconfirmed(){
        try{
            con = DBConnection.getConnection();
            String sql= "SELECT * FROM appointments WHERE purchaseStatus=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, "waiting for confirmation");
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table1.getModel();
            clearTable1();
            while(rs.next()){
                model.addRow(new String[]{"A00"+rs.getString(1),rs.getString(2),"P00"+rs.getString(3),rs.getString(4),"D00"+rs.getString(5),rs.getString(6),"Rp. "+rs.getString(12),rs.getString(13)});
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    // DISPLAY UNPAID FOR CASH/CARD PAYMENTS
    public void displayUnpaid(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");
            String sql= "SELECT * FROM appointments WHERE purchaseStatus=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, "unpaid");
            rs = pst.executeQuery();
            DefaultTableModel model2 = (DefaultTableModel)table2.getModel();
            clearTable2();
            while(rs.next()){
                model2.addRow(new String[]{"A00"+rs.getString(1),rs.getString(2),"P00"+rs.getString(3),rs.getString(4),"D00"+rs.getString(5),rs.getString(6),"Rp. "+rs.getString(12),rs.getString(13)});
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    // CLEAR TABLE1
    public void clearTable1(){ 
        ((DefaultTableModel)table1.getModel()).setNumRows(0);

    }
    
    // CLEAR TABLE2
    public void clearTable2(){ 
        ((DefaultTableModel)table2.getModel()).setNumRows(0);

    }
    
    // CHECK NOTIFICATION
    public void checkNotif(){
        if(table1.getRowCount()==0 && table2.getRowCount()==0){
            ImageIcon tempinbox = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Login_SQL\\src\\inbox white.png");
            Image scaledinbox = tempinbox.getImage().getScaledInstance(35,25,Image.SCALE_SMOOTH); 
            ImageIcon finalinbox = new ImageIcon(scaledinbox);
            inboxB.setIcon(finalinbox);
            inboxB.setText("");
        }
        else{
            ImageIcon tempinbox = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Login_SQL\\src\\notif white.png");
            Image scaledinbox = tempinbox.getImage().getScaledInstance(35,25,Image.SCALE_SMOOTH); 
            ImageIcon finalinbox = new ImageIcon(scaledinbox);
            inboxB.setIcon(finalinbox);
            inboxB.setText("");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        emptyData = new javax.swing.JLabel();
        confirmB = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        logoutB = new javax.swing.JButton();
        historyB = new javax.swing.JButton();
        inboxB = new javax.swing.JButton();
        allB = new javax.swing.JButton();
        icon = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        x = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        docpp = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        cashB = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(153, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel1.setText("Inbox");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 112, 196, -1));

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
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(2).setResizable(false);
            table1.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 989, 135));

        emptyData.setFont(new java.awt.Font("DengXian", 2, 12)); // NOI18N
        emptyData.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(emptyData, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 483, 231, 22));

        confirmB.setBackground(new java.awt.Color(255, 204, 102));
        confirmB.setText("Confirm");
        confirmB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBActionPerformed(evt);
            }
        });
        jPanel2.add(confirmB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 470, 106, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 153));

        logoutB.setBackground(new java.awt.Color(204, 204, 0));
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
        inboxB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inboxBActionPerformed(evt);
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

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setText("icon");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(allB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(historyB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(logoutB, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(inboxB, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inboxB, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historyB, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(allB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutB)
                .addContainerGap())
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 520));

        jPanel5.setBackground(new java.awt.Color(255, 204, 51));

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 566, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(x, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(docpp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(name))
                            .addComponent(docpp))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 1060, -1));

        table2.setModel(new javax.swing.table.DefaultTableModel(
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
        table2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(2).setResizable(false);
            table2.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 989, 135));

        cashB.setBackground(new java.awt.Color(255, 204, 102));
        cashB.setText("Pay cash/card");
        cashB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashBActionPerformed(evt);
            }
        });
        jPanel2.add(cashB, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 280, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 204, 0));
        jButton1.setText("BPJS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 280, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1152, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void confirmBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBActionPerformed
        if(table1.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Select an appointment");
        }
        else{
            int result = JOptionPane.showConfirmDialog(null, "Are you sure to confirm payment?", "Confirm payment",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.NO_OPTION){
            }
            else{
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");
                    
                    int row = table1.getSelectedRow();
                    String appID = (String) table1.getValueAt(row, 0);
                    String appIDnew = appID.substring(3, appID.length());
                    
                    String sql = "UPDATE appointments SET purchaseStatus=? where appointmentID="+appIDnew;
                    pst = con.prepareStatement(sql);
                    pst.setString(1, "paid");
                    pst.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Payment confirmed sucessfully!");
                    displayUnconfirmed();
                    checkNotif();
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
            }
        }
        
    }//GEN-LAST:event_confirmBActionPerformed

    private void inboxBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inboxBActionPerformed

    }//GEN-LAST:event_inboxBActionPerformed

    private void historyBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBActionPerformed
        new StaffHistory(currentStaff).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_historyBActionPerformed

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

    private void allBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allBActionPerformed
        new StaffAll(currentStaff).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_allBActionPerformed

    private void xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xActionPerformed
        System.exit(0);
    }//GEN-LAST:event_xActionPerformed

    private void cashBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashBActionPerformed
        if(table2.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Select an appointment");
        }
        else{
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");

                int row = table2.getSelectedRow();
                String appID = (String) table2.getValueAt(row, 0);
                String appIDnew = appID.substring(3, appID.length());

                String sql= "SELECT * FROM appointments WHERE appointmentID="+appIDnew;
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                if(rs.next()){

                    MEDICINE = rs.getString(10);
                    medsPrice = rs.getInt(11);
                    DOCSID = rs.getInt(5);
                    DOCSNAME = rs.getString(6);
                    docsPrice= rs.getInt(8);
                    TOTALPRICE = rs.getInt(12);

                    ImageIcon invoice = new ImageIcon("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Login_SQL\\src\\invoice.png");
                    //                    Image invoiceScaled = invoice.getImage().getScaledInstance(25,15,Image.SCALE_SMOOTH);
                    String[] options = {"Cancel", "Pay"};
                    String invoiceLabel = "Dr. "+DOCSNAME + "                  Rp. "+ docsPrice +"\n" +
                    MEDICINE + "          Rp. "+medsPrice +"\n" +
                    "Total price                Rp. "+TOTALPRICE;
                    int choice = JOptionPane.showOptionDialog(null, invoiceLabel, "Payment", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, invoice, options, options[0]);
                    if(choice==0){
                    }

                    if(choice ==1){

                        int print = JOptionPane.showConfirmDialog(null, "Do you want to print invoice?", "Invoice",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                        if(print == JOptionPane.NO_OPTION){
                            String sql1 = "UPDATE appointments SET purchaseStatus=? where appointmentID="+appIDnew;
                            pst = con.prepareStatement(sql1);
                            pst.setString(1, "paid");
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Payment successful");

                            clearTable2();
                            displayUnpaid();
                            checkNotif();
                        }

                        if(print == JOptionPane.YES_OPTION){
                            JOptionPane.showMessageDialog(null, "Printing...");
                            String sql1 = "UPDATE appointments SET purchaseStatus=? where appointmentID="+appIDnew;
                            pst = con.prepareStatement(sql1);
                            pst.setString(1, "paid");
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Payment successful");

                            clearTable2();
                            displayUnpaid();
                            checkNotif();
                        }

                    }
                }

            }

            catch(Exception e){

            }
        }
    }//GEN-LAST:event_cashBActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Login_SQL\\src\\bpjs.png");
                
                String[] options = {"Pay", "Cancel"};
                System.out.println("Trying BPJS Process");

                   int result = JOptionPane.showOptionDialog(
                   null,
                   "Payment with BPJS",
                   "Payment Confirmation",
                   JOptionPane.YES_NO_OPTION,
                   JOptionPane.QUESTION_MESSAGE,
                   icon,
                   options,
                   options[0]);  // Default button (index 0) is "Pay"

    if (result == JOptionPane.YES_OPTION) {
        // User clicked "Pay"
        // Add your payment processing code here
        System.out.println("Payment processed successfully");
    } else {
        // User clicked "Cancel" or closed the dialog
        System.out.println("Payment canceled");
    }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton allB;
    private javax.swing.JButton cashB;
    private javax.swing.JButton confirmB;
    private javax.swing.JLabel docpp;
    private javax.swing.JLabel emptyData;
    private javax.swing.JButton historyB;
    private javax.swing.JLabel icon;
    private javax.swing.JButton inboxB;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logo;
    private javax.swing.JButton logoutB;
    private javax.swing.JLabel name;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JButton x;
    // End of variables declaration//GEN-END:variables
}
