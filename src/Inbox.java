


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import model.Patient;




public class Inbox extends javax.swing.JFrame {
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    ButtonGroup bg = new ButtonGroup();
    
    //  Patient
    public Patient patient;
    
    int DOCSID;
    String DOCSNAME;
    int docsPrice;
    String MEDICINE;
    int medsPrice;
    int TOTALPRICE;
    
    public Inbox() {
        initComponents();
        
        // LOGO
        ImageIcon templogo = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\logos.png");
        Image scaledlogo = templogo.getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH); 
        ImageIcon finallogo = new ImageIcon(scaledlogo);
        logo.setIcon(finallogo);
        logo.setText("");
        
        // PROFILE
        ImageIcon tempp = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\profiles.png");
        Image scaledp = tempp.getImage().getScaledInstance(150,180,Image.SCALE_SMOOTH); 
        ImageIcon finalp = new ImageIcon(scaledp);
        p.setIcon(finalp);
        p.setText("");
        
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
        ImageIcon tempinbox = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\inbox picked.png");
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
        ImageIcon tempapp = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\appointment.png");
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
        
        time();
    }
    
    public Inbox(Patient patient) {
        
        this();
        this.patient=patient;
        
        

        displayProfile();
        displayUnpaid();
            
        checkNotif();
        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    // TIME
    public void time(){
        
        Timer timer;
        
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                java.util.Date date = new java.util.Date();
                SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");
                
                String clockString = st.format(date);
                
                clock.setText(clockString);
            }   
        });
        
        timer.start();
    }
    
    // DISPLAY PROFILE PAGE
    public void displayProfile(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");
            String sql = "select * from patients where patientID=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, patient.getId());
            rs = pst.executeQuery();
            if(rs.next()){
                this.patient.setPatientDOB(rs.getString(3));
                this.patient.setPatientPhone(rs.getString(4));
                this.patient.setPatientEmail(rs.getString(5));
                this.patient.setPatientAddress(rs.getString(6));

                //  Changing Name
                name.setText(patient.getPatientName());
                dob.setText(patient.getPatientDOB());
                phone.setText(patient.getPatientPhone());
                email.setText(patient.getPatientEmail());
                address.setText(patient.getPatientAddress());
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    // DISPLAY UNPAID
    public void displayUnpaid(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");
            String sql= "select * from appointments where patientID=? and purchaseStatus=?";            
            pst = con.prepareStatement(sql);
            pst.setInt(1, patient.getId());
            pst.setString(2, "unpaid");
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel)appointments.getModel();
            clearTable();
            while(rs.next()){
           
                model.addRow(new String[]{rs.getString(1),rs.getString(2),"Dr. "+rs.getString(6),"Rp. "+rs.getString(12),rs.getString(13)});
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    // CLEAR TABLE
    public void clearTable(){
        ((DefaultTableModel)appointments.getModel()).setNumRows(0);
    }
    
    
    // CHECK NOTIFICATION
    public void checkNotif(){
        if(appointments.getRowCount()==0){
            ImageIcon tempinbox = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Login_SQL\\src\\inbox picked.png");
            Image scaledinbox = tempinbox.getImage().getScaledInstance(35,25,Image.SCALE_SMOOTH); 
            ImageIcon finalinbox = new ImageIcon(scaledinbox);
            inboxB.setIcon(finalinbox);
            inboxB.setText("");
        }
        else{
            ImageIcon tempinbox = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Login_SQL\\src\\notif blue.png");
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        appointments = new javax.swing.JTable();
        emptyData = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        historyB = new javax.swing.JButton();
        newB = new javax.swing.JButton();
        docsB = new javax.swing.JButton();
        inboxB = new javax.swing.JButton();
        logoutB = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        x = new javax.swing.JButton();
        p = new javax.swing.JLabel();
        dob = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        area = new javax.swing.JLabel();
        clock = new javax.swing.JLabel();
        payB = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setForeground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel1.setText("Inbox");

        appointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "Doctor", "Price", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        appointments.getTableHeader().setReorderingAllowed(false);
        appointments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointmentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(appointments);

        emptyData.setFont(new java.awt.Font("DengXian", 2, 12)); // NOI18N
        emptyData.setForeground(new java.awt.Color(255, 0, 0));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(logoutB, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(icon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(newB, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(historyB, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(docsB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(inboxB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        name.setFont(new java.awt.Font("DengXian", 1, 14)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("NAME");

        jLabel5.setFont(new java.awt.Font("DengXian", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Hello, ");

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

        dob.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        dob.setForeground(new java.awt.Color(153, 153, 153));
        dob.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dob.setText("YYYY-MM-DD");

        phone.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        phone.setForeground(new java.awt.Color(153, 153, 153));
        phone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phone.setText("08-");

        email.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        email.setForeground(new java.awt.Color(153, 153, 153));
        email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        email.setText("email@gmail.com");

        address.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        address.setForeground(new java.awt.Color(153, 153, 153));
        address.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        address.setText("home");

        area.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        area.setForeground(new java.awt.Color(153, 153, 153));
        area.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        area.setText("Hospital Tap Indonesia");

        clock.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        clock.setForeground(new java.awt.Color(153, 153, 153));
        clock.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        clock.setText("hh:mm:ss");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addComponent(clock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(area, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clock)
                .addGap(2, 2, 2)
                .addComponent(area)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(127, 127, 127)
                    .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(dob)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(phone)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(email)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(address)
                    .addContainerGap(128, Short.MAX_VALUE)))
        );

        payB.setBackground(new java.awt.Color(255, 204, 102));
        payB.setText("Pay");
        payB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 36)); // NOI18N
        jLabel8.setText("Hospital Tap");

        logo.setText("jLabel8");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(emptyData, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(payB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(emptyData, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(payB)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void payBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBActionPerformed

        // CHECKS IF APPOINTMENT IS SELECTED
        if(appointments.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Select an appointment");
        }
        else{   
            
            ImageIcon methodicon = new ImageIcon("");
            System.out.println("Payment Method Selection");
            String[] methods = {"Cash", "E-money", "BPJS"};
            int paymentMethod = JOptionPane.showOptionDialog(null, "Choose a payment method", "Payment", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, methodicon, methods, methods[0]);
            
            if(paymentMethod==0){
                JOptionPane.showMessageDialog(this, "Please go to the cashier");
            }
            
              if(paymentMethod==2){ 
                System.out.println("BPJS Selected");
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
                   options[0]
           );  

           if (result == JOptionPane.YES_OPTION) {
               // User clicked "Pay"
               // Perform payment processing logic here
               System.out.println("Payment successful!");
           } else {
               // User clicked "Cancel" or closed the dialog
               // Handle cancellation logic here
               System.out.println("Payment cancelled or closed.");
           }
                    }
                    
            
            if(paymentMethod==1){ 
                System.out.println("E-Money Selected");
                ImageIcon icon = new ImageIcon("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Login_SQL\\src\\qrcode.png");
                String[] options = {"Pay", "Cancel"};
                System.out.println("Trying E-Money Process");
                try{
                    // GET MED NAME, PRICE AND DOC
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");
                    int row = appointments.getSelectedRow();
                    System.out.println("Getting App ID");
                    String appID = (String) appointments.getValueAt(row, 0);
                    System.out.println("App ID value from row fetched");
                    String appIDnew = appID;
                    System.out.println("App ID: " + appIDnew);
                    System.out.println("Instantiat appID, Done...");
                    String sql = "SELECT * FROM appointments WHERE appointmentID=?";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, appIDnew); 
                   
                    rs = pst.executeQuery();
                    System.out.println("Executing Query");
                    
                    if(rs.next()){
                        System.out.println("Getting Data From Result Set");
                        MEDICINE = rs.getString(11);
                        medsPrice = rs.getInt(11);
                        DOCSID = rs.getInt(5);
                        DOCSNAME = rs.getString(6);
                        docsPrice= rs.getInt(8);
                        TOTALPRICE = rs.getInt(12);

                        // PRINT OUT INVOICE
                        System.out.println("Printing Invoice");
                        String invoiceLabel = "Dr. "+DOCSNAME + "               Rp. "+ docsPrice +"\n" + 
                                         MEDICINE + "             Rp. "+medsPrice +"\n" +
                                        "Total price                Rp. "+TOTALPRICE;

                        int choice = JOptionPane.showOptionDialog(null, invoiceLabel, "Payment", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
                        if(choice==1){
                        }
                        else{ 
                            // MAKE STATUS WAITING FOR CONFIRMATION
                            String sql3 = "UPDATE appointments SET purchaseStatus=? where appointmentID=?";
                            pst = con.prepareStatement(sql3);
                            pst.setString(1, "waiting for confirmation");
                            pst.setString(2, (String) appointments.getValueAt(row,0));
                            System.out.println((String) appointments.getValueAt(row,0));
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Payment sucessful!");

                            displayUnpaid();

                            checkNotif();

                        }
                    }
                  
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(this, e);
                }
            }
        
        }
    }//GEN-LAST:event_payBActionPerformed

    private void historyBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBActionPerformed
        new History(patient).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_historyBActionPerformed

    private void newBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBActionPerformed
        new MainMenu(patient).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_newBActionPerformed

    private void docsBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docsBActionPerformed
        new DocsPage(patient).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_docsBActionPerformed

    private void inboxBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inboxBActionPerformed
        
    }//GEN-LAST:event_inboxBActionPerformed

    private void logoutBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Log out",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.NO_OPTION){
        }

        else{
            LandingPage landing = new LandingPage();
            landing.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_logoutBActionPerformed

    private void xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xActionPerformed
        System.exit(0);
    }//GEN-LAST:event_xActionPerformed

    private void appointmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_appointmentsMouseClicked

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
            java.util.logging.Logger.getLogger(Inbox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inbox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inbox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inbox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inbox().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JTable appointments;
    private javax.swing.JLabel area;
    private javax.swing.JLabel clock;
    private javax.swing.JLabel dob;
    private javax.swing.JButton docsB;
    private javax.swing.JLabel email;
    private javax.swing.JLabel emptyData;
    private javax.swing.JButton historyB;
    private javax.swing.JLabel icon;
    private javax.swing.JButton inboxB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton logoutB;
    private javax.swing.JLabel name;
    private javax.swing.JButton newB;
    private javax.swing.JLabel p;
    private javax.swing.JButton payB;
    private javax.swing.JLabel phone;
    private javax.swing.JButton x;
    // End of variables declaration//GEN-END:variables
}
