




import java.sql.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import model.Patient;


public class MainMenu extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    ButtonGroup bg = new ButtonGroup();
    
    //  Patient
    Patient patient;
   
    
    int DOCSID;
    String DOCSNAME;
    
    public MainMenu() {
        initComponents();

        bg.add(drSteven);
        bg.add(drCarla);
        bg.add(drJoshua);
        bg.add(drMarcie);
        
        // PROFILE
        ImageIcon tempp = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\profiles.png");
        Image scaledp = tempp.getImage().getScaledInstance(150,180,Image.SCALE_SMOOTH); 
        ImageIcon finalp = new ImageIcon(scaledp);
        p.setIcon(finalp);
        p.setText("");
        
        // LOGO
        ImageIcon templogo = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\logos.png");
        Image scaledlogo = templogo.getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH); 
        ImageIcon finallogo = new ImageIcon(scaledlogo);
        logo.setIcon(finallogo);
        logo.setText("");
        
        // X ICON
        ImageIcon tempx = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\x.png");
        Image scaledx = tempx.getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH); 
        ImageIcon finalx = new ImageIcon(scaledx);
        x.setIcon(finalx);
        x.setText("");
        
        // ICON
        ImageIcon tempicon = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\icon.png");
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
        ImageIcon temppast = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\past.png");
        Image scaledpast = temppast.getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH); 
        ImageIcon finalpast = new ImageIcon(scaledpast);
        historyB.setIcon(finalpast);
        historyB.setText("");
        
        // APPOINTMENT ICON
        ImageIcon tempapp = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\appointment picked.png");
        Image scaledapp = tempapp.getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH); 
        ImageIcon finalapp = new ImageIcon(scaledapp);
        newB.setIcon(finalapp);
        newB.setText("");
        
        // DOCTOR ICON
        ImageIcon tempdoc = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\doctor.png");
        Image scaleddoc = tempdoc.getImage().getScaledInstance(27,35,Image.SCALE_SMOOTH); 
        ImageIcon finaldoc = new ImageIcon(scaleddoc);
        docsB.setIcon(finaldoc);
        docsB.setText("");
        
        // BANNER
        ImageIcon tempbanner = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\banners.png");
        Image scaledbanner = tempbanner.getImage().getScaledInstance(800,300,Image.SCALE_SMOOTH); 
        ImageIcon finalbanner = new ImageIcon(scaledbanner);
        banner.setIcon(finalbanner);
        banner.setText("");
        
        time();
        
        Year.removeAllItems();
        Month.removeAllItems();
        Date.removeAllItems();
        Hour.removeAllItems();
        
        Year.addItem("Year");
        Year.addItem("2023");
        Year.addItem("2024");
        Year.addItem("2025");
        
        Month.addItem("Month");
        Month.addItem("January");
        Month.addItem("February");
        Month.addItem("March");
        Month.addItem("April");
        Month.addItem("May");
        Month.addItem("June");
        Month.addItem("July");
        Month.addItem("August");
        Month.addItem("September");
        Month.addItem("October");
        Month.addItem("November");
        Month.addItem("December");
        
        Date.addItem("Date");
        for (int i=1;i<32;i++){
            Date.addItem(Integer.toString(i));
        }
        
        Hour.addItem("Hour");
        for (int i=8;i<10;i++){
            Hour.addItem("0"+Integer.toString(i)+":00");
        }
        for (int i=10;i<19;i++){
            Hour.addItem(Integer.toString(i)+":00");
        }
        
    }
    
    public void time(){
        Timer timer;
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Date date = new Date();
                SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");
                
                String clockString = st.format(date);
                
                clock.setText(clockString);
            }   
        });
        
        timer.start();
    }
    
    public MainMenu(Patient patient) {
      
        this();
        this.patient=patient;

        emptyData.setText(null);
        
        displayProfile();
        displayPending();
       
        try{
            // CHECK IF THERE IS ANY UNPAID APPOINTMENTS
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");
            String sql = "SELECT * FROM appointments WHERE patientID=? and purchaseStatus=?";
            pst = con.prepareStatement(sql);
            
            pst.setInt(1, patient.getId());
            pst.setString(2, "unpaid");
            rs = pst.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Check your inbox!");
                
                ImageIcon tempinbox = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Login_SQL\\src\\notif white.png");
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
    
    
    // DISPLAY PROFILE PAGE
    public void displayProfile(){
        patient.displayProfile();
        
        name.setText(patient.getPatientName());
        dob.setText(patient.getPatientDOB());
        phone.setText(patient.getPatientPhone());
        email.setText(patient.getPatientEmail());
        address.setText(patient.getPatientAddress());
    }
    
    // DISPLAY PENDING APPOINTMENTS
    public void displayPending(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");
            String sql= "SELECT * FROM appointments WHERE patientID=? and purchaseStatus IS NULL";            
            pst = con.prepareStatement(sql);
            pst.setInt(1, patient.getId());
            rs = pst.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel)table1.getModel();
            clearTable();
            
            while(rs.next()){
                model.addRow(new String[]{"A00"+rs.getString(1),rs.getString(2),rs.getString(14),"Dr. "+rs.getString(6)});
            }
        }
        catch(Exception ex){
            System.out.println(ex);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        drSteven = new javax.swing.JRadioButton();
        drCarla = new javax.swing.JRadioButton();
        drJoshua = new javax.swing.JRadioButton();
        drMarcie = new javax.swing.JRadioButton();
        ourDocsB = new javax.swing.JButton();
        myAppB = new javax.swing.JButton();
        emptyData = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        logoutB = new javax.swing.JButton();
        docsB = new javax.swing.JButton();
        newB = new javax.swing.JButton();
        historyB = new javax.swing.JButton();
        inboxB = new javax.swing.JButton();
        icon = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dob = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        x = new javax.swing.JButton();
        p = new javax.swing.JLabel();
        clock = new javax.swing.JLabel();
        area = new javax.swing.JLabel();
        resetB1 = new javax.swing.JButton();
        makeAppB1 = new javax.swing.JButton();
        delApp = new javax.swing.JButton();
        Year = new javax.swing.JComboBox<>();
        Date = new javax.swing.JComboBox<>();
        Month = new javax.swing.JComboBox<>();
        Hour = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        banner = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setForeground(new java.awt.Color(255, 255, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("STZhongsong", 0, 14)); // NOI18N
        jLabel1.setText("Pending appointments");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, 196, -1));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "Time", "Doctor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setResizable(false);
            table1.getColumnModel().getColumn(0).setPreferredWidth(10);
            table1.getColumnModel().getColumn(1).setResizable(false);
            table1.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 338, 122));

        jLabel3.setFont(new java.awt.Font("STZhongsong", 0, 14)); // NOI18N
        jLabel3.setText("Make appointment");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 339, 179, -1));

        jLabel4.setFont(new java.awt.Font("DengXian", 0, 14)); // NOI18N
        jLabel4.setText("at");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 20, -1));

        jLabel6.setFont(new java.awt.Font("STZhongsong", 0, 12)); // NOI18N
        jLabel6.setText("Doctor");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 463, -1));

        drSteven.setFont(new java.awt.Font("DengXian", 0, 14)); // NOI18N
        drSteven.setText("Dr. Steven");
        drSteven.setToolTipText("Rheumatologists");
        drSteven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drStevenActionPerformed(evt);
            }
        });
        jPanel2.add(drSteven, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 98, -1));

        drCarla.setFont(new java.awt.Font("DengXian", 0, 14)); // NOI18N
        drCarla.setText("Dr. Carla");
        drCarla.setToolTipText("Clinical Pathology");
        drCarla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drCarlaActionPerformed(evt);
            }
        });
        jPanel2.add(drCarla, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 98, -1));

        drJoshua.setFont(new java.awt.Font("DengXian", 0, 14)); // NOI18N
        drJoshua.setText("Dr. Joshua");
        drJoshua.setToolTipText("Cardiologists");
        jPanel2.add(drJoshua, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 98, -1));

        drMarcie.setFont(new java.awt.Font("DengXian", 0, 14)); // NOI18N
        drMarcie.setText("Dr. Marcie");
        drMarcie.setToolTipText("Oncologist");
        jPanel2.add(drMarcie, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 440, 98, -1));

        ourDocsB.setBackground(new java.awt.Color(255, 153, 0));
        ourDocsB.setFont(new java.awt.Font("STZhongsong", 0, 12)); // NOI18N
        ourDocsB.setText("Our Doctors");
        ourDocsB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ourDocsBActionPerformed(evt);
            }
        });
        jPanel2.add(ourDocsB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 110, 30));

        myAppB.setBackground(new java.awt.Color(255, 204, 0));
        myAppB.setFont(new java.awt.Font("STZhongsong", 0, 12)); // NOI18N
        myAppB.setText("My Appointments");
        myAppB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myAppBActionPerformed(evt);
            }
        });
        jPanel2.add(myAppB, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, 30));

        emptyData.setFont(new java.awt.Font("DengXian", 2, 12)); // NOI18N
        emptyData.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(emptyData, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 478, 166, 22));

        jPanel3.setBackground(new java.awt.Color(255, 204, 153));

        logoutB.setFont(new java.awt.Font("STZhongsong", 1, 14)); // NOI18N
        logoutB.setForeground(new java.awt.Color(153, 153, 153));
        logoutB.setText("Log out");
        logoutB.setBorder(null);
        logoutB.setBorderPainted(false);
        logoutB.setContentAreaFilled(false);
        logoutB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBActionPerformed(evt);
            }
        });

        docsB.setFont(new java.awt.Font("DengXian", 1, 14)); // NOI18N
        docsB.setForeground(new java.awt.Color(153, 153, 153));
        docsB.setText("Our Doctors");
        docsB.setBorder(null);
        docsB.setBorderPainted(false);
        docsB.setContentAreaFilled(false);
        docsB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docsBActionPerformed(evt);
            }
        });

        newB.setFont(new java.awt.Font("DengXian", 1, 14)); // NOI18N
        newB.setForeground(new java.awt.Color(153, 153, 153));
        newB.setText("New appointment");
        newB.setBorder(null);
        newB.setBorderPainted(false);
        newB.setContentAreaFilled(false);
        newB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBActionPerformed(evt);
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
        inboxB.setMaximumSize(new java.awt.Dimension(334, 196));
        inboxB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inboxBMouseClicked(evt);
            }
        });
        inboxB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inboxBActionPerformed(evt);
            }
        });

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setText("icon");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newB, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(inboxB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(logoutB, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(historyB, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(docsB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inboxB, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historyB, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(docsB, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutB)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 530));

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        name.setFont(new java.awt.Font("STZhongsong", 0, 14)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("NAME");

        jLabel5.setFont(new java.awt.Font("STZhongsong", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Hello, ");

        dob.setFont(new java.awt.Font("STZhongsong", 0, 12)); // NOI18N
        dob.setForeground(new java.awt.Color(153, 153, 153));
        dob.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dob.setText("YYYY-MM-DD");

        phone.setFont(new java.awt.Font("STZhongsong", 0, 12)); // NOI18N
        phone.setForeground(new java.awt.Color(153, 153, 153));
        phone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phone.setText("08-");

        email.setFont(new java.awt.Font("STZhongsong", 0, 12)); // NOI18N
        email.setForeground(new java.awt.Color(153, 153, 153));
        email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        email.setText("email@gmail.com");

        address.setFont(new java.awt.Font("STZhongsong", 0, 12)); // NOI18N
        address.setForeground(new java.awt.Color(153, 153, 153));
        address.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        address.setText("home");

        x.setFont(new java.awt.Font("DengXian", 0, 14)); // NOI18N
        x.setText("Exit");
        x.setBorderPainted(false);
        x.setContentAreaFilled(false);
        x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xActionPerformed(evt);
            }
        });

        p.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p.setText("profile");

        clock.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        clock.setForeground(new java.awt.Color(153, 153, 153));
        clock.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        clock.setText("hh:mm:ss");

        area.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        area.setForeground(new java.awt.Color(153, 153, 153));
        area.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        area.setText("Hospital Tap Indonesia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(area, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name)
                .addGap(18, 18, 18)
                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(dob)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(address)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(clock)
                .addGap(2, 2, 2)
                .addComponent(area)
                .addContainerGap())
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, -1, 530));

        resetB1.setBackground(new java.awt.Color(255, 204, 0));
        resetB1.setFont(new java.awt.Font("STZhongsong", 0, 12)); // NOI18N
        resetB1.setText("Reset");
        resetB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetB1ActionPerformed(evt);
            }
        });
        jPanel2.add(resetB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 478, 75, -1));

        makeAppB1.setBackground(new java.awt.Color(255, 204, 102));
        makeAppB1.setFont(new java.awt.Font("STZhongsong", 0, 12)); // NOI18N
        makeAppB1.setText("Make appointment");
        makeAppB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeAppB1ActionPerformed(evt);
            }
        });
        jPanel2.add(makeAppB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 478, -1, -1));

        delApp.setBackground(new java.awt.Color(255, 204, 0));
        delApp.setFont(new java.awt.Font("STZhongsong", 0, 12)); // NOI18N
        delApp.setText("Delete appointment");
        delApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delAppActionPerformed(evt);
            }
        });
        jPanel2.add(delApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 340, -1, -1));

        Year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year" }));
        jPanel2.add(Year, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 60, 30));

        Date.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Date" }));
        jPanel2.add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 60, 30));

        Month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month" }));
        jPanel2.add(Month, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, -1, 30));

        Hour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(Hour, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, -1, 30));

        jLabel7.setFont(new java.awt.Font("STZhongsong", 0, 12)); // NOI18N
        jLabel7.setText("Appointment Time");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 151, -1));

        logo.setText("jLabel8");
        jPanel2.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 50, 40));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel8.setText("Hospital Tap");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 230, 40));

        banner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        banner.setText("banner");
        jPanel2.add(banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 15, 890, 318));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1154, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void clearTable(){
        // RIBET WAY TO CLEAR TABLE
//        DefaultTableModel model = (DefaultTableModel)table1.getModel();
//        model.getDataVector().removeAllElements();
//        revalidate();
        
        ((DefaultTableModel)table1.getModel()).setNumRows(0);
    }
    
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

    private void drStevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drStevenActionPerformed
        
    }//GEN-LAST:event_drStevenActionPerformed

    private void ourDocsBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ourDocsBActionPerformed
        new DocsPage(patient).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_ourDocsBActionPerformed

    private void myAppBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myAppBActionPerformed
        new History(patient).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_myAppBActionPerformed

    private void docsBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docsBActionPerformed
        new DocsPage(patient).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_docsBActionPerformed

    private void newBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBActionPerformed
        
    }//GEN-LAST:event_newBActionPerformed

    private void historyBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBActionPerformed
        new History(patient).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_historyBActionPerformed

    private void drCarlaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drCarlaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drCarlaActionPerformed

    private void inboxBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inboxBActionPerformed
        new Inbox(patient).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_inboxBActionPerformed

    private void xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xActionPerformed
        System.exit(0);
    }//GEN-LAST:event_xActionPerformed

    private void resetB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetB1ActionPerformed

        emptyData.setText(null);
        bg.clearSelection();
        Year.setSelectedIndex(0);
        Month.setSelectedIndex(0);
        Date.setSelectedIndex(0);
        Hour.setSelectedIndex(0);
    }//GEN-LAST:event_resetB1ActionPerformed

    private void makeAppB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeAppB1ActionPerformed
        
        // CHECKS IF TEXT FIELD IS FILLED
        if(!(drSteven.isSelected())&&
            !(drCarla.isSelected())&&
            !(drJoshua.isSelected())&&
            !(drMarcie.isSelected())||
            Year.getSelectedIndex()==0 ||
            Month.getSelectedIndex()==0 ||
            Date.getSelectedIndex()==0 ||
            Hour.getSelectedIndex()==0){
            emptyData.setText("Fill in the data completely");
        }
       
        else{
            try{
                // INPUT DATA INTO DATABASE
                var year = Year.getSelectedItem();
                int month = Month.getSelectedIndex();
                int date = Date.getSelectedIndex();
                var hour = (String) Hour.getSelectedItem();
                String appDate = year+"-"+month+"-"+date;
                
                if(drSteven.isSelected()){
                    DOCSID = 1;
                    DOCSNAME = "Steven";
                }
                else if(drCarla.isSelected()){
                    DOCSID = 2;
                    DOCSNAME = "Carla";
                }
                else if(drJoshua.isSelected()){
                    DOCSID = 3;
                    DOCSNAME = "Joshua";
                }
                else if(drMarcie.isSelected()){
                    DOCSID = 4;
                    DOCSNAME = "Marcie";
                }
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");
                
                String sql= "SELECT * FROM appointments WHERE appointmentDate=? and hour=? and docsID=?";
                pst = con.prepareStatement(sql);
                pst.setString(1, appDate);
                pst.setString(2, hour);
                pst.setInt(3, DOCSID);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    JOptionPane.showMessageDialog(rootPane, "Choosen time is already taken. Choose another time");
                }
                else{
                    String sql2= "SELECT * FROM appointments WHERE appointmentDate=? and hour=? and patientID=?";
                    pst = con.prepareStatement(sql2);
                    pst.setString(1, appDate);
                    pst.setString(2, hour);
                    pst.setInt(3, patient.getId());
                    rs = pst.executeQuery();
                    
                    if(rs.next()){
                        int result = JOptionPane.showConfirmDialog(null, "You already have appointment at this time. \nAre you sure to book appointment?", "Appointment confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                        if(result == JOptionPane.YES_OPTION){
                            
                            String sql1 = "INSERT INTO appointments(appointmentDate, patientID, patientName, docsID, docsName, hour)values(?,?,?,?,?,?)";
                            pst = con.prepareStatement(sql1);
                            
                            pst.setString(1, appDate);
                            pst.setInt(2, patient.getId());
                            pst.setString(3, patient.getPatientName());
                            pst.setInt(4, DOCSID);
                            pst.setString(5, DOCSNAME);
                            pst.setString(6, hour);

                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(this, "Appointment has been recorded");
                            displayPending();

                            bg.clearSelection();
                            emptyData.setText(null);

                            Year.setSelectedIndex(0);
                            Month.setSelectedIndex(0);
                            Date.setSelectedIndex(0);
                            Hour.setSelectedIndex(0);
                        }

                        else{
                            
                        }
                    }
                    
                    else{
                        String sql1 = "INSERT INTO appointments(appointmentDate, patientID, patientName, docsID, docsName, hour)values(?,?,?,?,?,?)";
                        pst = con.prepareStatement(sql1);

                        pst.setString(1, appDate);
                        pst.setInt(2, patient.getId());
                        pst.setString(3, patient.getPatientName());
                        pst.setInt(4, DOCSID);
                        pst.setString(5, DOCSNAME);
                        pst.setString(6, hour);

                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Appointment has been recorded");
                        displayPending();

                        bg.clearSelection();
                        emptyData.setText(null);

                        Year.setSelectedIndex(0);
                        Month.setSelectedIndex(0);
                        Date.setSelectedIndex(0);
                        Hour.setSelectedIndex(0);
                    }
                    
                }
                
            }
            
            catch(Exception e){
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_makeAppB1ActionPerformed

    private void delAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delAppActionPerformed
        if(table1.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Select an appointment");
        }
        else{
            int del = JOptionPane.showConfirmDialog(rootPane, "Are you sure to delete the appointment?", "Delete appointment",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(del == JOptionPane.YES_OPTION){
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");

                    int row = table1.getSelectedRow();
                    String appID = (String) table1.getValueAt(row, 0);
                    String appIDnew = appID.substring(3, appID.length());
                    
                    String sql= "DELETE FROM appointments WHERE appointmentID="+appIDnew;
                    pst = con.prepareStatement(sql);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Appointment is deleted");
                    displayPending();

                }
                catch(Exception e){
                    System.out.println(e);
                }
            }

            else{
                
            }
                
        }
    }//GEN-LAST:event_delAppActionPerformed

    private void inboxBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inboxBMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_inboxBMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Date;
    private javax.swing.JComboBox<String> Hour;
    private javax.swing.JComboBox<String> Month;
    private javax.swing.JComboBox<String> Year;
    private javax.swing.JLabel address;
    private javax.swing.JLabel area;
    private javax.swing.JLabel banner;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel clock;
    private javax.swing.JButton delApp;
    private javax.swing.JLabel dob;
    private javax.swing.JButton docsB;
    private javax.swing.JRadioButton drCarla;
    private javax.swing.JRadioButton drJoshua;
    private javax.swing.JRadioButton drMarcie;
    private javax.swing.JRadioButton drSteven;
    private javax.swing.JLabel email;
    private javax.swing.JLabel emptyData;
    private javax.swing.JButton historyB;
    private javax.swing.JLabel icon;
    private javax.swing.JButton inboxB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton logoutB;
    private javax.swing.JButton makeAppB1;
    private javax.swing.JButton myAppB;
    private javax.swing.JLabel name;
    private javax.swing.JButton newB;
    private javax.swing.JButton ourDocsB;
    private javax.swing.JLabel p;
    private javax.swing.JLabel phone;
    private javax.swing.JButton resetB1;
    private javax.swing.JTable table1;
    private javax.swing.JButton x;
    // End of variables declaration//GEN-END:variables
}
