/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import server.Connectivity;
import java.awt.Color;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vampire
 */
public class FrontPage extends javax.swing.JFrame {
        
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement  pst = null;
    private String username;
    private static String ret_date,ret_venue;
    private static int ret_slot;
    
    
    /**
     * Creates new form FrontPage
     */
    public FrontPage() throws SQLException {
        initComponents();
        LoginPage login = new LoginPage();
       welcome.setText("Welcome " +login.getName());
       username = login.getName();
       summarystatus.setVisible(false);
        conn = Connectivity.connect();
        
        
        
        //Setting Date
        Date date = new Date();
        SimpleDateFormat dat = new SimpleDateFormat("dd MMM,yyyy");
        presentDate.setText(dat.format(date));
        
       
        
        //Setting time
        time t = new time();
        t.start();
        
        
        
        
        
                   int visible =1 ;
                   
                  String query2 = "SELECT * FROM slot WHERE username='"+username+"' ORDER BY date";
                  PreparedStatement pst2 = conn.prepareStatement(query2);
                  ResultSet rs2 = pst2.executeQuery();
                   
                  String sb = "<html><body style='text-align: right'>";
                   
                   while(rs2.next())
                   {
                       if(visible==1)
                       summarystatus.setVisible(true);
                       visible = 0;
                       sb = sb +"Venue : "+  rs2.getString("venue")+" "+"date : "+ rs2.getDate(4)+
                               " Event :"+ rs2.getString("eventname")+"<br/> <br/>";
                       summary.setText(sb);
                   } 
                    
                   sb = sb + "</html>";
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
        logout = new javax.swing.JButton();
        welcome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        venuebox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        slotbox = new javax.swing.JComboBox<>();
        datechooser = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        bookstatus = new javax.swing.JLabel();
        confirm = new javax.swing.JButton();
        summarystatus = new javax.swing.JLabel();
        checkAll = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        eventname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        event_type = new javax.swing.JComboBox<>();
        openEvents = new javax.swing.JButton();
        check = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        summary = new javax.swing.JLabel();
        presentDate = new javax.swing.JButton();
        presentTime = new javax.swing.JButton();
        jlabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, -1, -1));

        welcome.setText("Welcome");
        getContentPane().add(welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 12, 283, 32));

        jLabel1.setText("Venues   Avaialble");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 152, 28));

        venuebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "venue_1", "venue_2", "venue_3", "venue_4" }));
        getContentPane().add(venuebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 139, -1));

        jLabel2.setText("Time Slot");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 128, 28));

        slotbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8   am    - 10 am", "10 am   - 12 pm", "2    pm  -  4   pm", " 4  pm  -   6   pm" }));
        slotbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slotboxActionPerformed(evt);
            }
        });
        getContentPane().add(slotbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));
        getContentPane().add(datechooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 139, -1));

        jLabel3.setText("Select Date");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 128, 30));

        bookstatus.setText("Booking");
        getContentPane().add(bookstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 144, 32));

        confirm.setText("Book");
        confirm.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                confirmAncestorResized(evt);
            }
        });
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        getContentPane().add(confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 139, -1));

        summarystatus.setText("Your Bookings");
        getContentPane().add(summarystatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 124, 38));

        checkAll.setText("All Bookings");
        checkAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAllActionPerformed(evt);
            }
        });
        getContentPane().add(checkAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 139, -1));

        jLabel4.setText("Event name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 112, 35));

        eventname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventnameActionPerformed(evt);
            }
        });
        getContentPane().add(eventname, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 200, -1));

        jLabel5.setText("Event Type");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 123, 30));

        event_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "private", "public" }));
        event_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                event_typeActionPerformed(evt);
            }
        });
        getContentPane().add(event_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 200, -1));

        openEvents.setText("Open Events");
        openEvents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openEventsActionPerformed(evt);
            }
        });
        getContentPane().add(openEvents, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, 130, -1));

        check.setText("Check Availabilty");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });
        getContentPane().add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 140, -1));

        summary.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        summary.setAutoscrolls(true);
        jScrollPane2.setViewportView(summary);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 520, 130));

        presentDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presentDateActionPerformed(evt);
            }
        });
        getContentPane().add(presentDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 150, 30));
        getContentPane().add(presentTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 150, 30));

        jlabel12.setText("Current Time");
        getContentPane().add(jlabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 100, 30));

        jLabel7.setText("CurrentDate");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 100, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        new LoginPage().setVisible(true);
        
        dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
        try
        {
           
            SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dformat.format(datechooser.getDate());
            String venue = venuebox.getSelectedItem().toString();
            int slot = slotbox.getSelectedIndex()+1;
             //JOptionPane.showMessageDialog(null,datechooser.getDateFormatString());
             
         
            //Before querying query 1 ,we need to check whether the user is already registered an event or not
             String query1 = "SELECT venue,slot,date FROM slot WHERE( venue='"+venue+"' AND slot='" +slot
                     + " ') AND "+"date='"+date+"'";
             pst = conn.prepareStatement(query1);
             rs = pst.executeQuery();
             
             
             
             if(rs.next())
             {
                 bookstatus.setForeground(Color.red);
                 bookstatus.setText("ALREADY BOOKED");
                 
                 int visible =1 ;
                   
                  String query2 = "SELECT * FROM slot WHERE username='"+username+"'";
                  PreparedStatement pst2 = conn.prepareStatement(query2);
                  ResultSet rs2 = pst2.executeQuery();
                  
                   
                  String sb = "<html><body style='text-align: right'>";
                   
                   while(rs2.next())
                   {
                       if(visible==1)
                       summarystatus.setVisible(true);
                       visible = 0;
                       sb = sb +"Venue : "+  rs2.getString("venue")+" "+"date : "+ rs2.getDate(4)+
                               " Event :"+ rs2.getString("eventname")+"<br/> <br/>";
                       summary.setText(sb);
                   } 
                    
                   sb = sb + "</html>";
                 
             }
             else
             {
                   //querying into string ,not to the server
            String query = "insert into slot(username,venue,slot,date,eventname,event_type) values(?,?,?,?,?,?)";
            //now i prepared a statement because i need to take values through run time
            PreparedStatement pst = conn.prepareStatement(query);
            
            
           // pst = conn.prepareStatement(query);
            
            pst.setString(1,username);
            pst.setString(2,venuebox.getSelectedItem().toString());
            pst.setInt(3,(slotbox.getSelectedIndex()+1));
            pst.setString(4,date);
            pst.setString(5,eventname.getText());
            pst.setString(6,event_type.getSelectedItem().toString());
            
            pst.execute();
            pst.close();
            bookstatus.setForeground(Color.GREEN);
            bookstatus.setText("BOOKED");
            
            
            
            int visible =1 ;
                   
                  String query2 = "SELECT * FROM slot WHERE username='"+username+"'";
                  PreparedStatement pst2 = conn.prepareStatement(query2);
                  ResultSet rs2 = pst2.executeQuery();
                   
                  String sb = "<html><body style='text-align: right'>";
                   
                   while(rs2.next())
                   {
                       if(visible==1)
                       summarystatus.setVisible(true);
                       visible = 0;
                       sb = sb +"Venue : "+  rs2.getString("venue")+" "+"date : "+ rs2.getDate(4)+
                               " Event :"+ rs2.getString("eventname")+"<br/> <br/>";
                       summary.setText(sb);
                   } 
                    
                   sb = sb + "</html>";
            
            
           // confirm.setEnabled(false);
             }
            /*
            
            jTextField_email.setText("");
            jTextField_phone.setText("");
            jTextField_username.setText("");
            jPasswordField.setText("");
            */
            //Status.setText("Sign Up Successful");
            
            //JOptionPane.showMessageDialog(null,datechooser.getDateFormatString());
            
        }
        catch(Exception e)
        {
           e.printStackTrace();
           // Status.setText("Username Not Available");
        }
    }//GEN-LAST:event_confirmActionPerformed

    public static String returnDate()
    {
        return ret_date;
    }
     public static String returnVenue()
    {
        return ret_venue;
    }
     public static int returnSlot()
    {
        return ret_slot;
    }
    
    private void confirmAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_confirmAncestorResized
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmAncestorResized

    private void checkAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAllActionPerformed
        try {
            // TODO add your handling code here:
            new VenueTable().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(FrontPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_checkAllActionPerformed

    private void openEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openEventsActionPerformed
        try {
            // TODO add your handling code here:
            new openEvents().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(FrontPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_openEventsActionPerformed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        try {
            
            SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dformat.format(datechooser.getDate());
            ret_date = date;
            
             String venue = venuebox.getSelectedItem().toString();
             ret_venue = venue;
            int slot = slotbox.getSelectedIndex()+1;
            ret_slot = slot;
            
            // TODO add your handling code here:
            new CheckAvailablity().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(FrontPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkActionPerformed

    private void slotboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slotboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_slotboxActionPerformed

    private void event_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_event_typeActionPerformed

    private void eventnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventnameActionPerformed

    private void presentDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presentDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_presentDateActionPerformed

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
            java.util.logging.Logger.getLogger(FrontPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrontPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrontPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrontPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrontPage().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrontPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    class time extends Thread
{
    public void run()
    {
        for(;;)
        {
            try
            {
                Date datum = new Date();
                SimpleDateFormat s2 = new SimpleDateFormat("hh:mm:ss a");
            presentTime.setText(s2.format(datum));
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bookstatus;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton check;
    private javax.swing.JButton checkAll;
    private javax.swing.JButton confirm;
    private com.toedter.calendar.JDateChooser datechooser;
    private javax.swing.JComboBox<String> event_type;
    private javax.swing.JTextField eventname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlabel12;
    private javax.swing.JButton logout;
    private javax.swing.JButton openEvents;
    private javax.swing.JButton presentDate;
    private javax.swing.JButton presentTime;
    private javax.swing.JComboBox<String> slotbox;
    private javax.swing.JLabel summary;
    private javax.swing.JLabel summarystatus;
    private javax.swing.JComboBox<String> venuebox;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
