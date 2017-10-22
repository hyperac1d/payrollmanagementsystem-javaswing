/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.payroll.system;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static java.sql.DriverManager.getConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author mat
 */
public final class EmployeeDetails extends javax.swing.JFrame {
    byte[] imgdata;
    int xMouse;
    int yMouse;
    /**
     * Creates new form EmployeeDetails
     */
    public EmployeeDetails() {
        PG.url = "jdbc:postgresql://localhost:5432/payrolldb";
        PG.username = "postgres";
        PG.password = "123";
        PG.className = "org.postgresql.Driver";
        initComponents();
        UIC.DateChooser.setReadOnly(dcbday);
        UIC.Frame.setDefault(this);
        this.showDetails();
        System.out.println("Clicked: "+App.lpersonnel);
    }
    public void showDetails(){
        String[] columns = {"ID", "FIRSTNAME", "MIDDLEINITIAL","LASTNAME", "DESIGNATION", "CONTACTNO", "BIRTHDATE", "AGE", "ADDRESS", "SSS_NO", "PAGIBIG_NO", "RATE", "ALLOWANCE", "DATEHIRED"};
        String whereClause = "id=" + App.lpersonnel;
        System.out.println("tblclick: "+App.lpersonnel);
        String[][] records = PG.executeDQL("employee", columns, whereClause);
//
        txtfname.setText(records[0][1]);
        txtmname.setText(records[0][2]);
        txtlname.setText(records[0][3]);
        txtdes.setText(records[0][4]);
        txtcon.setText(records[0][5]);
        String date = records[0][6];
        txtage.setText(records[0][7]);
        txtaddress.setText(records[0][8]);
        txtSSS.setText(records[0][9]);
        txtPagibig.setText(records[0][10]);
        txtrate.setText(records[0][11]);
        txtallowance.setText(records[0][12]);
        String datehired = records[0][13];
        
        
        try {
            java.util.Date date2 = new SimpleDateFormat("YYYY-mm-dd").parse(date);
            dcbday.setDate(date2);
        } catch (ParseException ex) {
            System.out.println("Parse date error: "+ex);
        }
        
        try {
            java.util.Date date3 = new SimpleDateFormat("YYYY-mm-dd").parse(datehired);
            dc_datehired.setDate(date3);
        } catch (ParseException ex) {
            System.out.println("Parse date error: "+ex);
        }
        
        try{
            PG.conn = getConnection(PG.url, PG.username, PG.password);
            PG.stmt = PG.conn.createStatement();
            ResultSet rs = PG.stmt.executeQuery("SELECT profile FROM employee WHERE id= "+App.lpersonnel);
            if(rs.next()){
                byte[] in = rs.getBytes("profile");
                ImageIcon icon =new ImageIcon(in);
                    //stretching image
                Image image = icon.getImage();
                Image scaledImage = image.getScaledInstance(lblIMAGE.getWidth(),lblIMAGE.getHeight(), Image.SCALE_DEFAULT);                                                                
                lblIMAGE.setIcon(new javax.swing.ImageIcon(scaledImage)); 
            }else{
                System.out.println("no image: inside else");
//                ImageIcon icon =new ImageIcon("src/project/payroll/system/unknown.png");                
//                Image image = icon.getImage();
//                Image scaledImage = image.getScaledInstance(lblIMAGE.getWidth(),lblIMAGE.getHeight(), Image.SCALE_DEFAULT);                                                                
//                lblIMAGE.setIcon(new javax.swing.ImageIcon(scaledImage));
            } 
        }
        catch(Exception e){
            //System.out.println("Image Error: " + e.getMessage());
            System.out.println("SQLException: "+e);
//            System.out.println("no image");
//            ImageIcon icon =new ImageIcon("src\\project\\payroll\\system\\unknown.png");                
//            Image image = icon.getImage();
//            Image scaledImage = image.getScaledInstance(lblIMAGE.getWidth(),lblIMAGE.getHeight(), Image.SCALE_DEFAULT);                                                                
//            lblIMAGE.setIcon(new javax.swing.ImageIcon(scaledImage));
        }
    }
    public Image stretchImage(String path,JLabel label)
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage(path);
        Image scaledImage = image.getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT);
        return scaledImage;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Titlebar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        lblMaximize = new javax.swing.JLabel();
        lblMinimize = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel_PersonnelDetails = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        btnUpdatePersonnel = new javax.swing.JButton();
        btnDeletePersonnel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblIMAGE = new javax.swing.JLabel();
        btnBrowse = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        txtfname = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel41 = new javax.swing.JLabel();
        txtmname = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel44 = new javax.swing.JLabel();
        txtcon = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel39 = new javax.swing.JLabel();
        txtage = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel40 = new javax.swing.JLabel();
        txtdes = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        dcbday = new com.toedter.calendar.JDateChooser();
        jSeparator11 = new javax.swing.JSeparator();
        txtlname = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        dc_datehired = new com.toedter.calendar.JDateChooser();
        jLabel46 = new javax.swing.JLabel();
        txtallowance = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jSeparator24 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        txtPagibig = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        txtSSS = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        txtrate = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1450, 790));
        setMinimumSize(new java.awt.Dimension(1450, 790));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1450, 790));
        setResizable(false);
        setSize(new java.awt.Dimension(1450, 790));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_Titlebar.setBackground(new java.awt.Color(0, 105, 92));
        jPanel_Titlebar.setMaximumSize(new java.awt.Dimension(1450, 40));
        jPanel_Titlebar.setMinimumSize(new java.awt.Dimension(1450, 40));
        jPanel_Titlebar.setPreferredSize(new java.awt.Dimension(1450, 40));

        jLabel1.setBackground(new java.awt.Color(250, 250, 250));
        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 191, 165));
        jLabel1.setText("Mesagon Builders | Payroll Management System");

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/payroll/system/images/icons8_Close_Window_25px.png"))); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });

        lblMaximize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/payroll/system/images/icons8_Maximize_Window_25px.png"))); // NOI18N

        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/payroll/system/images/icons8_Minimize_Window_25px.png"))); // NOI18N
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_TitlebarLayout = new javax.swing.GroupLayout(jPanel_Titlebar);
        jPanel_Titlebar.setLayout(jPanel_TitlebarLayout);
        jPanel_TitlebarLayout.setHorizontalGroup(
            jPanel_TitlebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_TitlebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 825, Short.MAX_VALUE)
                .addComponent(lblMinimize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMaximize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClose)
                .addContainerGap())
        );
        jPanel_TitlebarLayout.setVerticalGroup(
            jPanel_TitlebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_TitlebarLayout.createSequentialGroup()
                .addGroup(jPanel_TitlebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_TitlebarLayout.createSequentialGroup()
                        .addGroup(jPanel_TitlebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaximize, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel_Titlebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 40));

        jPanel5.setBackground(new java.awt.Color(0, 137, 123));
        jPanel5.setMaximumSize(new java.awt.Dimension(1380, 150));
        jPanel5.setMinimumSize(new java.awt.Dimension(1380, 150));
        jPanel5.setPreferredSize(new java.awt.Dimension(1380, 150));

        jLabel14.setFont(new java.awt.Font("Segoe UI Light", 1, 60)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Personnel Details");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(400, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(330, 330, 330))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1450, 150));

        jPanel_PersonnelDetails.setBackground(new java.awt.Color(245, 245, 245));
        jPanel_PersonnelDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(97, 97, 97));
        jLabel42.setText("Date of Birth: (yyyy-mm-dd)");
        jPanel_PersonnelDetails.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 340, 30));

        jLabel43.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(97, 97, 97));
        jLabel43.setText("Address:");
        jPanel_PersonnelDetails.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, -1, 30));

        txtaddress.setBackground(new java.awt.Color(245, 245, 245));
        txtaddress.setColumns(20);
        txtaddress.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        txtaddress.setRows(5);
        txtaddress.setBorder(null);
        jScrollPane1.setViewportView(txtaddress);

        jPanel_PersonnelDetails.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 350, 140));
        jPanel_PersonnelDetails.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        btnUpdatePersonnel.setBackground(new java.awt.Color(0, 137, 123));
        btnUpdatePersonnel.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnUpdatePersonnel.setForeground(new java.awt.Color(240, 240, 240));
        btnUpdatePersonnel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/payroll/system/images/icons8_Update_25px.png"))); // NOI18N
        btnUpdatePersonnel.setText("Update");
        btnUpdatePersonnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePersonnelActionPerformed(evt);
            }
        });
        jPanel_PersonnelDetails.add(btnUpdatePersonnel, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 480, 180, 40));

        btnDeletePersonnel.setBackground(new java.awt.Color(0, 137, 123));
        btnDeletePersonnel.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnDeletePersonnel.setForeground(new java.awt.Color(240, 240, 240));
        btnDeletePersonnel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/payroll/system/images/icons8_Delete_25px.png"))); // NOI18N
        btnDeletePersonnel.setText("Delete ");
        btnDeletePersonnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePersonnelActionPerformed(evt);
            }
        });
        jPanel_PersonnelDetails.add(btnDeletePersonnel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 480, 180, 40));

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));

        lblIMAGE.setForeground(new java.awt.Color(240, 240, 240));
        lblIMAGE.setText("default");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblIMAGE, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblIMAGE, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel_PersonnelDetails.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 30, 280, 220));

        btnBrowse.setBackground(new java.awt.Color(0, 137, 123));
        btnBrowse.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        btnBrowse.setForeground(new java.awt.Color(255, 255, 255));
        btnBrowse.setIcon(new javax.swing.ImageIcon("D:\\Graphics\\icons8_Image_File_20px.png")); // NOI18N
        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });
        jPanel_PersonnelDetails.add(btnBrowse, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 260, 140, 30));

        jLabel38.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(97, 97, 97));
        jLabel38.setText("First Name:");
        jPanel_PersonnelDetails.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 180, 30));

        txtfname.setBackground(new java.awt.Color(245, 245, 245));
        txtfname.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        txtfname.setBorder(null);
        txtfname.setOpaque(false);
        jPanel_PersonnelDetails.add(txtfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 320, 50));
        jPanel_PersonnelDetails.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 320, 20));

        jLabel41.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(97, 97, 97));
        jLabel41.setText("Middle Initial:");
        jPanel_PersonnelDetails.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 160, 30));

        txtmname.setBackground(new java.awt.Color(245, 245, 245));
        txtmname.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        txtmname.setBorder(null);
        txtmname.setOpaque(false);
        jPanel_PersonnelDetails.add(txtmname, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 110, 50));
        jPanel_PersonnelDetails.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 110, 20));

        jLabel44.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(97, 97, 97));
        jLabel44.setText("Contact Number");
        jPanel_PersonnelDetails.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 180, 30));

        txtcon.setBackground(new java.awt.Color(245, 245, 245));
        txtcon.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        txtcon.setBorder(null);
        txtcon.setOpaque(false);
        jPanel_PersonnelDetails.add(txtcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 320, 50));
        jPanel_PersonnelDetails.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 320, 20));

        jLabel39.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(97, 97, 97));
        jLabel39.setText("Age:");
        jPanel_PersonnelDetails.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, 140, 30));

        txtage.setBackground(new java.awt.Color(245, 245, 245));
        txtage.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        txtage.setBorder(null);
        txtage.setOpaque(false);
        jPanel_PersonnelDetails.add(txtage, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 80, 140, 50));
        jPanel_PersonnelDetails.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, 140, 20));

        jLabel40.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(97, 97, 97));
        jLabel40.setText("Designation:");
        jPanel_PersonnelDetails.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 180, 30));

        txtdes.setBackground(new java.awt.Color(245, 245, 245));
        txtdes.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        txtdes.setBorder(null);
        txtdes.setOpaque(false);
        jPanel_PersonnelDetails.add(txtdes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 320, 50));
        jPanel_PersonnelDetails.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 320, 20));

        dcbday.setDateFormatString("yyyy/MM/dd");
        dcbday.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jPanel_PersonnelDetails.add(dcbday, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 320, 50));
        jPanel_PersonnelDetails.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 320, 20));

        txtlname.setBackground(new java.awt.Color(245, 245, 245));
        txtlname.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        txtlname.setBorder(null);
        txtlname.setOpaque(false);
        jPanel_PersonnelDetails.add(txtlname, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 320, 50));

        jLabel45.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(97, 97, 97));
        jLabel45.setText("Last Name:");
        jPanel_PersonnelDetails.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 180, 30));

        dc_datehired.setDateFormatString("yyyy/MM/dd");
        dc_datehired.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jPanel_PersonnelDetails.add(dc_datehired, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 320, 50));

        jLabel46.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(97, 97, 97));
        jLabel46.setText("Date Hired:");
        jPanel_PersonnelDetails.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 190, 30));

        txtallowance.setBackground(new java.awt.Color(245, 245, 245));
        txtallowance.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        txtallowance.setBorder(null);
        txtallowance.setOpaque(false);
        txtallowance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtallowanceActionPerformed(evt);
            }
        });
        jPanel_PersonnelDetails.add(txtallowance, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 290, 210, 50));

        jLabel60.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(97, 97, 97));
        jLabel60.setText("Allowance/Day:");
        jPanel_PersonnelDetails.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 250, 190, 30));
        jPanel_PersonnelDetails.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 340, 220, 20));
        jPanel_PersonnelDetails.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 320, 20));

        txtPagibig.setBackground(new java.awt.Color(245, 245, 245));
        txtPagibig.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        txtPagibig.setBorder(null);
        txtPagibig.setOpaque(false);
        txtPagibig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagibigActionPerformed(evt);
            }
        });
        jPanel_PersonnelDetails.add(txtPagibig, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 320, 50));

        jLabel54.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(97, 97, 97));
        jLabel54.setText("Pag-ibig No.");
        jPanel_PersonnelDetails.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 160, 30));

        txtSSS.setBackground(new java.awt.Color(245, 245, 245));
        txtSSS.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        txtSSS.setBorder(null);
        txtSSS.setOpaque(false);
        jPanel_PersonnelDetails.add(txtSSS, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 320, 50));

        jLabel51.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(97, 97, 97));
        jLabel51.setText("SSS No.");
        jPanel_PersonnelDetails.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 130, 30));
        jPanel_PersonnelDetails.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 320, 20));
        jPanel_PersonnelDetails.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, 220, 20));

        txtrate.setBackground(new java.awt.Color(245, 245, 245));
        txtrate.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        txtrate.setBorder(null);
        txtrate.setOpaque(false);
        txtrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrateActionPerformed(evt);
            }
        });
        jPanel_PersonnelDetails.add(txtrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 180, 220, 50));

        jLabel58.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(97, 97, 97));
        jLabel58.setText("Rate:");
        jPanel_PersonnelDetails.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, 160, 30));

        getContentPane().add(jPanel_PersonnelDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 1450, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);

        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();

        //raw image to bytes
        File fimage = new File(filename);
        if(filename==null){
            lblIMAGE.setText("");
        }
        try{
            FileInputStream fis = new FileInputStream(fimage);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum; (readNum=fis.read(buf))!=-1;){
                bos.write(buf,0,readNum);
            }
            imgdata = bos.toByteArray();

            //update JLabel to load image
            java.awt.Image image = stretchImage(filename,this.lblIMAGE);
            this.lblIMAGE.setIcon(new javax.swing.ImageIcon(image));
        }
        catch(IOException e){
            System.out.println("FileInputStream Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

//    int ch = JOptionPane.showConfirmDialog(null, "Do you really want to delete this profile?", "Warning!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
//        if (ch==0){
//            String[] columns = {"FIRSTNAME", "LASTNAME", "DESIGNATION"};
//            String whereClause = "id="+App.lpersonnel;
//            String[][] records = PG.executeDQL("employee", columns, whereClause);
//
//            String fname = records[0][0];
//            String lname = records[0][1];
//            String des = records[0][2];
//
//            //delete personnel from dbo.employee_project
//            Object[] values = {fname, lname, des};
//            String queryDelete = "DELETE FROM employee_project WHERE emp_fname=? AND emp_lname=? AND designation=?";
//            
//            if(PG.executeDML(queryDelete, values)){
//                try {
//                    App.viewListofPersonnels();
//                    JOptionPane.showMessageDialog(null, "Personnel removed in the project!");
//                    //remove personnel in the dbo.epmployee
//                    String query = "DELETE FROM employee WHERE id="+App.lpersonnel;
//                    PG.stmt.executeQuery(query);
//                } catch (SQLException ex) {
//                    Logger.getLogger(EmployeeDetails.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//           
//            
//            
//        }
    private void btnDeletePersonnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePersonnelActionPerformed
        // TODO add your handling code here:
        System.out.println("DELETE PERSONNEL");
        int id = App.lpersonnel;
        int ch = JOptionPane.showConfirmDialog(null, "Do you want to delete this personnel?", "Personnel Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(ch==0){
//            String[] columns = {"FIRSTNAME", "LASTNAME", "DESIGNATION"};
//            String whereClause = "id="+id;
//            String[][] records = PG.executeDQL("employee", columns, whereClause);
//
//            String fname = records[0][0];
//            String lname = records[0][1];
//            String des = records[0][2];
//
//            //delete personnel from dbo.employee_project
//            Object[] values = {fname, lname, des};
//            String queryDelete = "DELETE FROM employee_project WHERE emp_fname=? AND emp_lname=? AND designation=?";
            Object[] values = {id};
            String queryDelete2 = "DELETE FROM employee WHERE id=?";
            if(PG.executeDML(queryDelete2, values)){
                JOptionPane.showMessageDialog(null, "Personnel has been deleted!");
                txtfname.setText("");
                txtmname.setText("");
                txtlname.setText("");
                txtdes.setText("");
                txtcon.setText("");
                //String bday = UIC.DateChooser.getDate(dcdob);
                dcbday.setDate(null);
                String age = txtage.getText();
                txtaddress.setText("");
                
                this.dispose();
                App.viewListofPersonnels();
            }
            

            
        }
    }//GEN-LAST:event_btnDeletePersonnelActionPerformed

    private void btnUpdatePersonnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePersonnelActionPerformed
        // TODO add your handling code here:
        
        String fname = txtfname.getText();
        String mname = txtmname.getText();
        String lname = txtlname.getText();
        String des = txtdes.getText();
        String con = txtcon.getText();
        java.sql.Date dob = new java.sql.Date(dcbday.getDate().getTime());
        java.sql.Date dhired = new java.sql.Date(dc_datehired.getDate().getTime());
        String age = txtage.getText();
        String address = txtaddress.getText();
        Float rate = Float.parseFloat(txtrate.getText());
        Float allowance = Float.parseFloat(txtallowance.getText());
        String sss = txtSSS.getText();
        String pagibig = txtPagibig.getText();
        
        
        byte[] image = this.imgdata;
        
        Object[] values = {fname, mname, lname, des, con, dob, age, address, image, sss, pagibig, rate, allowance, dhired, App.lpersonnel};
        String query = "UPDATE employee SET firstname=?, middleinitial=?, lastname=?, designation=?, contactno=?, birthdate=?, age=?, address=?, profile=?, sss_no=?, pagibig_no=?, rate=?, allowance=?, datehired=? WHERE id=?";
        
        if(PG.executeDML(query, values)){
            JOptionPane.showMessageDialog(null, "profile successfully updated!"); 
            txtfname.setText("");
            txtmname.setText("");
            txtdes.setText("");
            txtcon.setText("");
            txtage.setText("");
            txtaddress.setText("");
            lblIMAGE.setIcon(null);
            dcbday.setDate(null);
            App.viewListofPersonnels();
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "profile update error!");
        }
            
        
    }//GEN-LAST:event_btnUpdatePersonnelActionPerformed

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        // TODO add your handling code here:
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMouseClicked

    private void txtallowanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtallowanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtallowanceActionPerformed

    private void txtPagibigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagibigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagibigActionPerformed

    private void txtrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrateActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnDeletePersonnel;
    private javax.swing.JButton btnUpdatePersonnel;
    private com.toedter.calendar.JDateChooser dc_datehired;
    private com.toedter.calendar.JDateChooser dcbday;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel_PersonnelDetails;
    private javax.swing.JPanel jPanel_Titlebar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblIMAGE;
    private javax.swing.JLabel lblMaximize;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JTextField txtPagibig;
    private javax.swing.JTextField txtSSS;
    private javax.swing.JTextArea txtaddress;
    private javax.swing.JTextField txtage;
    private javax.swing.JTextField txtallowance;
    private javax.swing.JTextField txtcon;
    private javax.swing.JTextField txtdes;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtlname;
    private javax.swing.JTextField txtmname;
    private javax.swing.JTextField txtrate;
    // End of variables declaration//GEN-END:variables
}
