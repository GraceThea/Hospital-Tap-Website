

import java.awt.Image;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DoctorEdit extends javax.swing.JFrame {
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    String APPID;
    String APPPATIENT;
    String APPDATE;
    
    int DOCSID;
    String DOCSNAME;
    int DOCSPRICE;
   
    
    String MEDICINEID= "";
    String MEDICINENAME;
    int MEDICINEPRICE=0;
    
    int TOTALPRICE;
   
     
    public DoctorEdit() {
        initComponents();
        combobox.removeAllItems();
        
        ImageIcon tempp = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\profiles.png");
        Image scaledp = tempp.getImage().getScaledInstance(150,180,Image.SCALE_SMOOTH); 
        ImageIcon finalp = new ImageIcon(scaledp);
        p.setIcon(finalp);
        p.setText("");
        
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");
            String sql= "SELECT * FROM medicines";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                combobox.addItem(rs.getString(2));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
//        combobox.getSelectedIndex();
    }

    
    DoctorEdit(String appPatient, String appID, String appDate, int docsID, String docsName){
        
        this();
        
        APPID = appID;
        APPPATIENT = appPatient;
        APPDATE = appDate;
        DOCSID= docsID;
        DOCSNAME=docsName;
        
        id.setText(": A00"+APPID);
        name.setText(": "+APPPATIENT);
        date.setText(": "+APPDATE);
        
        // CHECK DOCS PRICE
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");
            String sql2 = "SELECT * FROM doctors WHERE docsID="+DOCSID;
            pst = con.prepareStatement(sql2);
            rs = pst.executeQuery();
                if(rs.next()){
                    DOCSPRICE = rs.getInt(5);
                }
        }
        catch(Exception e){
            System.out.println(e);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        homeB = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        p = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        combobox = new javax.swing.JComboBox<>();
        resetB = new javax.swing.JButton();
        editB = new javax.swing.JButton();
        emptyData = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        moreMed = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        notesTA = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        medList = new javax.swing.JTextArea();
        addMedB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");

        homeB.setFont(new java.awt.Font("DengXian", 1, 14)); // NOI18N
        homeB.setForeground(new java.awt.Color(153, 153, 153));
        homeB.setText("<< back");
        homeB.setBorderPainted(false);
        homeB.setContentAreaFilled(false);
        homeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Appointment");

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel1.setText("Patient ID - name");

        name.setFont(new java.awt.Font("DengXian", 0, 14)); // NOI18N
        name.setText(":");

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel2.setText("Appointment ID");

        id.setFont(new java.awt.Font("DengXian", 0, 14)); // NOI18N
        id.setText(":");

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel3.setText("Appointment date ");

        date.setFont(new java.awt.Font("DengXian", 0, 14)); // NOI18N
        date.setText(":");

        p.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p.setText("profile");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                    .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(23, 23, 23)
                                .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(date))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(jLabel1))
                .addGap(81, 81, 81))
        );

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel4.setText("Notes");

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel5.setText("Medicine");

        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        resetB.setBackground(new java.awt.Color(255, 204, 0));
        resetB.setText("Reset");
        resetB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBActionPerformed(evt);
            }
        });

        editB.setBackground(new java.awt.Color(204, 204, 0));
        editB.setText("Edit");
        editB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBActionPerformed(evt);
            }
        });

        emptyData.setFont(new java.awt.Font("DengXian", 2, 12)); // NOI18N
        emptyData.setForeground(new java.awt.Color(255, 0, 0));

        jLabel8.setText(":");

        jLabel9.setText(":");

        jLabel7.setForeground(new java.awt.Color(255, 153, 0));
        jLabel7.setText("*Choose [ - ] if medicine is not listed");

        moreMed.setText("More");
        moreMed.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                moreMedFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                moreMedFocusLost(evt);
            }
        });
        moreMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreMedActionPerformed(evt);
            }
        });
        moreMed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                moreMedKeyPressed(evt);
            }
        });

        notesTA.setColumns(20);
        notesTA.setRows(5);
        notesTA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                notesTAFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(notesTA);

        medList.setColumns(20);
        medList.setRows(5);
        jScrollPane2.setViewportView(medList);

        addMedB.setBackground(new java.awt.Color(204, 204, 0));
        addMedB.setText("Add");
        addMedB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMedBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emptyData, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(moreMed)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(addMedB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(46, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(resetB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(editB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emptyData, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel8))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(moreMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addMedB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetB)
                    .addComponent(editB))
                .addContainerGap(16, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(homeB)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeB)
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void editBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBActionPerformed
        
        // CONFIRMING UPDATE
        
        if(notesTA.getText().trim().isEmpty()){
            emptyData.setText("Fill in the data completely");
        }
        else{
            int result = JOptionPane.showConfirmDialog(null, "Are you sure to update?", "Confirm edit appointment",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.NO_OPTION){
            }
        
            else{
                try{
                    if(!(medList.getText().equals(""))){
                        String strMed = medList.getText();
                        String strMedNew = strMed.substring(0, strMed.length()-2);
                        MEDICINENAME = strMedNew;

                        ArrayList<String> MedList = new ArrayList<String>(Arrays.asList(strMedNew.split(", ")));
                        for(int i=0;i<MedList.size();i++){
                            String medName = MedList.get(i);
                            try{
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");
                                String sql = "SELECT * FROM medicines WHERE medicineName=?";
                                pst = con.prepareStatement(sql);
                                pst.setString(1, medName);
                                rs = pst.executeQuery();
                                if (rs.next()){
                                    MEDICINEID = MEDICINEID + " " + rs.getString(1);
                                    MEDICINEPRICE += rs.getInt(3);
                                }
                                else{
                                    MEDICINEID = MEDICINEID + " -";
                                }
                            }
                            catch(Exception e){
                                System.out.println(e);
                                
                            }
                        }
                    }
                    else{
                        MEDICINEID = "0";
                        MEDICINENAME = "-";
                        MEDICINEPRICE = 0;
                    }
                        
                    TOTALPRICE = MEDICINEPRICE + DOCSPRICE;
                    
                    // INPUT DATA INTO DATABASE
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");
                    String sql = "UPDATE appointments SET docsNote=?, docsPrice=?, medicineID=?, medicineName=?, medicinePrice=?, price=?, purchaseStatus=? where appointmentID="+APPID;
                    pst = con.prepareStatement(sql);
                    pst.setString(1, notesTA.getText());
                    pst.setInt(2, DOCSPRICE);
                    pst.setString(3, MEDICINEID);
                    pst.setString(4, MEDICINENAME);
                    pst.setInt(5, MEDICINEPRICE);
                    pst.setInt(6, TOTALPRICE);
                    pst.setString(7, "unpaid");
                    pst.executeUpdate();
                  
                    JOptionPane.showMessageDialog(null, "Updated sucessfully!");
                    new DoctorMenu(DOCSNAME, DOCSID).setVisible(true);
                    setVisible(false);
                }
                
                catch(Exception e){
                    JOptionPane.showMessageDialog(this, e);
                }
            
            }
        
        }
            
        
    }//GEN-LAST:event_editBActionPerformed

    private void resetBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBActionPerformed
        notesTA.setText(null);
        moreMed.setText("More");
        combobox.setSelectedIndex(0);
        medList.setText("");
        emptyData.setText(null);
    }//GEN-LAST:event_resetBActionPerformed

    private void homeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBActionPerformed
        new DoctorMenu(DOCSNAME, DOCSID).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_homeBActionPerformed

    private void moreMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreMedActionPerformed
        
    }//GEN-LAST:event_moreMedActionPerformed

    private void moreMedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moreMedKeyPressed

    }//GEN-LAST:event_moreMedKeyPressed

    private void moreMedFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_moreMedFocusGained
        moreMed.setText("");
        combobox.setSelectedIndex(0);
        
    }//GEN-LAST:event_moreMedFocusGained

    private void moreMedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_moreMedFocusLost
        
    }//GEN-LAST:event_moreMedFocusLost

    private void addMedBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMedBActionPerformed
        try{
        int medIndex = combobox.getSelectedIndex();
                    
            if(medIndex>0){
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");
                String sql2 = "SELECT * FROM medicines WHERE medicineID="+medIndex;
                pst = con.prepareStatement(sql2);
                rs = pst.executeQuery();
                if(rs.next()){
                    medList.append(rs.getString(2) + ", ");
                }
            }
            if(medIndex==0){
                if(moreMed.getText().equals("More") || moreMed.getText().equals("")){
                    
                }
                else{
                    medList.append("*"+moreMed.getText() + ", ");
                }

            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_addMedBActionPerformed

    private void notesTAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_notesTAFocusGained
        emptyData.setText(null);
    }//GEN-LAST:event_notesTAFocusGained

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
            java.util.logging.Logger.getLogger(DoctorEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMedB;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JLabel date;
    private javax.swing.JButton editB;
    private javax.swing.JLabel emptyData;
    private javax.swing.JButton homeB;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea medList;
    private javax.swing.JTextField moreMed;
    private javax.swing.JLabel name;
    private javax.swing.JTextArea notesTA;
    private javax.swing.JLabel p;
    private javax.swing.JButton resetB;
    // End of variables declaration//GEN-END:variables
}
