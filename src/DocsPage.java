

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import model.Patient;

public class DocsPage extends javax.swing.JFrame {

    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    //  Patient
    Patient patient;
    
    
    
    public DocsPage() {
        initComponents();
        
        // LOGO
        ImageIcon templogo = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\logos.png");
        Image scaledlogo = templogo.getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH); 
        ImageIcon finallogo = new ImageIcon(scaledlogo);
        logo.setIcon(finallogo);
        logo.setText("");
        
        // STEVEN
        ImageIcon tempS = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\steven.jpg");
        Image scaledS = tempS.getImage().getScaledInstance(150,180,Image.SCALE_SMOOTH); 
        ImageIcon finalS = new ImageIcon(scaledS);
        steven.setIcon(finalS);
        steven.setText("");
        
        // CLARA
        ImageIcon tempC = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\clara.png");
        Image scaledC = tempC.getImage().getScaledInstance(150,180,Image.SCALE_SMOOTH); 
        ImageIcon finalC = new ImageIcon(scaledC);
        clara.setIcon(finalC);
        clara.setText("");
        
        // JOSHUA
        ImageIcon tempJ = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\joshua.png");
        Image scaledJ = tempJ.getImage().getScaledInstance(150,180,Image.SCALE_SMOOTH); 
        ImageIcon finalJ = new ImageIcon(scaledJ);
        joshua.setIcon(finalJ);
        joshua.setText("");
        
        // MARCIE
        ImageIcon tempM = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\marcie.jpg");
        Image scaledM = tempM.getImage().getScaledInstance(150,180,Image.SCALE_SMOOTH); 
        ImageIcon finalM = new ImageIcon(scaledM);
        marcie.setIcon(finalM);
        marcie.setText("");
        
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
        ImageIcon tempapp = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\appointment.png");
        Image scaledapp = tempapp.getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH); 
        ImageIcon finalapp = new ImageIcon(scaledapp);
        newB.setIcon(finalapp);
        newB.setText("");
        
        // DOCTOR ICON
        ImageIcon tempdoc = new ImageIcon ("C:\\Users\\Grace\\Documents\\NetBeansProjects\\Semester5_FinalProject\\src\\doctor picked.png");
        Image scaleddoc = tempdoc.getImage().getScaledInstance(27,35,Image.SCALE_SMOOTH); 
        ImageIcon finaldoc = new ImageIcon(scaleddoc);
        docsB.setIcon(finaldoc);
        docsB.setText("");
        
        time();
    }
    
    public DocsPage(Patient patient) {
        
        this();
        this.patient=patient;

        
        displayProfile();
    }

    // TIME
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
    
    // DISPLAY PROFILE PAGE
    public void displayProfile(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/finalexamdb", "root", "");
            String sql = "SELECT * FROM patients WHERE patientID=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, patient.getId());
            rs = pst.executeQuery();
            if(rs.next()){
                this.patient.setPatientDOB(rs.getString(3));
                this.patient.setPatientPhone(rs.getString(4));
                this.patient.setPatientEmail(rs.getString(5));
                this.patient.setPatientAddress(rs.getString(6));
                
                //  Set Text
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        steven = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        clara = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        joshua = new javax.swing.JLabel();
        marcie = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setForeground(new java.awt.Color(255, 255, 153));

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
            .addComponent(newB, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(inboxB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(logoutB, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(icon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
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

        jLabel1.setFont(new java.awt.Font("DengXian", 1, 18)); // NOI18N
        jLabel1.setText("Dr. Steven");

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 18)); // NOI18N
        jLabel2.setText("Our Doctors");

        steven.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("DengXian", 1, 18)); // NOI18N
        jLabel3.setText("Dr. Clara");

        clara.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("DengXian", 1, 18)); // NOI18N
        jLabel4.setText("Dr. Joshua");

        joshua.setText("jLabel3");

        marcie.setText("jLabel3");

        jLabel6.setFont(new java.awt.Font("DengXian", 1, 18)); // NOI18N
        jLabel6.setText("Dr. Marcie");

        jLabel7.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        jLabel7.setText("Specializes in diagnosing and ");

        jLabel8.setFont(new java.awt.Font("DengXian", 1, 12)); // NOI18N
        jLabel8.setText("Specialist in Rheumatology");

        jLabel9.setFont(new java.awt.Font("DengXian", 1, 12)); // NOI18N
        jLabel9.setText("Specialist in Clinical Pathology");

        jLabel10.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        jLabel10.setText("Specializes in laboratory meds");

        jLabel11.setFont(new java.awt.Font("DengXian", 1, 12)); // NOI18N
        jLabel11.setText("Specialist in Cadiology");

        jLabel12.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        jLabel12.setText("Specializes in diagnosing and ");

        jLabel13.setFont(new java.awt.Font("DengXian", 1, 12)); // NOI18N
        jLabel13.setText("Specialist in Oncology");

        jLabel14.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        jLabel14.setText("Specializes in diagnosing ");

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 36)); // NOI18N
        jLabel15.setText("Hospital Tap");

        logo.setText("<< back");

        jLabel16.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        jLabel16.setText("treating conditions affecting");

        jLabel17.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        jLabel17.setText("joints, bones and muscles, such ");

        jLabel18.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        jLabel18.setText("as autoimune disease, arthritis");

        jLabel19.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        jLabel19.setText("through analysis of body fluids,");

        jLabel20.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        jLabel20.setText("and the diagnosis of disease");

        jLabel21.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        jLabel21.setText("tissues, and cells");

        jLabel22.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        jLabel22.setText("treating conditions of the ");

        jLabel23.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        jLabel23.setText("heart and blood vessels");

        jLabel25.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        jLabel25.setText("and other therapy");

        jLabel26.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        jLabel26.setText("treatement plans, surgery");

        jLabel27.setFont(new java.awt.Font("DengXian", 0, 12)); // NOI18N
        jLabel27.setText("cancer. Help develop individual");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(steven, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(clara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(40, 40, 40))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17))
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(joshua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(marcie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel27)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 658, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(54, 54, 54)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(steven, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clara, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(joshua, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(marcie, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)))
                .addContainerGap(61, Short.MAX_VALUE))
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

    private void historyBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBActionPerformed
        new History(patient).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_historyBActionPerformed

    private void newBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBActionPerformed
        new MainMenu(patient).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_newBActionPerformed

    private void docsBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docsBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docsBActionPerformed

    private void inboxBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inboxBActionPerformed
        new Inbox(patient);
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
            java.util.logging.Logger.getLogger(DocsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DocsPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JLabel area;
    private javax.swing.JLabel clara;
    private javax.swing.JLabel clock;
    private javax.swing.JLabel dob;
    private javax.swing.JButton docsB;
    private javax.swing.JLabel email;
    private javax.swing.JButton historyB;
    private javax.swing.JLabel icon;
    private javax.swing.JButton inboxB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
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
    private javax.swing.JLabel joshua;
    private javax.swing.JLabel logo;
    private javax.swing.JButton logoutB;
    private javax.swing.JLabel marcie;
    private javax.swing.JLabel name;
    private javax.swing.JButton newB;
    private javax.swing.JLabel p;
    private javax.swing.JLabel phone;
    private javax.swing.JLabel steven;
    private javax.swing.JButton x;
    // End of variables declaration//GEN-END:variables
}
