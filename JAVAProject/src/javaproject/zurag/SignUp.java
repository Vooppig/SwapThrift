/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaproject.zurag;

import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javaproject.DatabaseConnection;
import javax.swing.JOptionPane;

/**
 *
 * @author Erkhes
 */
public class SignUp {
    private void SignUp(String firstname, String lastname, String username, String password){
        
        DatabaseConnection conn = new DatabaseConnection();
        if(conn.connect() != null){
        try{
            PreparedStatement st = (PreparedStatement)
                conn.connect().prepareStatement("INSERT INTO ts_user_table (name,user_pass,firstname,lastname) VALUES(?,?,?,?)");
            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, firstname);
            st.setString(4, lastname);
            int result = st.executeUpdate();
            //
        }
        catch (SQLException ex){
            System.Logger.getLogger(SignUp.class.getName()).log(System.Logger.Level.SEVERE, null, ex);
        }
        }
        else{
            System.out.println("Database connection unavailable");
        }
    }
}
