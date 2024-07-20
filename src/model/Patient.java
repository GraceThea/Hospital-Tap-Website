/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
/**
 *
 * @author USER
 */
public class Patient {
    private int id;
    private String patientName;
    private String patientDOB;
    private String patientPhone;
    private String patientEmail;
    private String patientAddress;

    
    public Patient(int id, String patientName) {
        this.id = id;
        this.patientName = patientName;
    }

    public Patient() {
        
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientDOB() {
        return patientDOB;
    }

    public void setPatientDOB(String patientDOB) {
        this.patientDOB = patientDOB;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

      // DISPLAY PROFILE PAGE
    public void displayProfile(){
        try{
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM patients WHERE patientID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, this.id);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                this.patientDOB = rs.getString(3);
                this.patientPhone = rs.getString(4);
                this.patientEmail = rs.getString(5);
                this.patientAddress = rs.getString(6);            
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void patientLogin(String email, String password){
        try {
            // Checks Database for inputed EMAIL and PASS
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM patients WHERE patientEmail=? and patientPassword=?";

            PreparedStatement pst = conn.prepareStatement("SELECT * FROM patients WHERE patientEmail=? and patientPassword=?");
            pst.setString(1, email);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            // If Correct
            if (rs.next()) {
                String name = rs.getString(2);
                int fId = rs.getInt(1);
                JOptionPane.showMessageDialog(null, "Welcome, " + name);

                
                this.patientName = name;
                this.id = fId;
                System.out.println("Logged In");
            } else {
                
            }
 
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    } 
}
