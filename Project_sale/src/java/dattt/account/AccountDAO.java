/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattt.account;

import dattt.utils.DBHelpers;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author jike
 */
public class AccountDAO implements Serializable {

    public AccountDTO checkLogin(String user, String pass)
    throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try{
            con = DBHelpers.makeConnection();
            if(con != null){
                String sql = "Select * "
                        + "From Account "
                        + "Where [user] = ? And pass = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, user);
                stm.setString(2, pass);
                rs = stm.executeQuery();
                while(rs.next()){
                    return new AccountDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                }
            }
        
        } finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return null;
    }

    public AccountDTO checkAccountExist(String user)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //check connection
            con = DBHelpers.makeConnection();
            if (con != null) {
                // create sql string
                String sql = "Select * "
                        + "From Account "
                        + "Where [user] = ? ";
                //create statement object to load to sql string
                stm = con.prepareStatement(sql);
                stm.setString(1, user);
                rs = stm.executeQuery();
                while (rs.next()) {
                    return new AccountDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                }
            }
        } catch (Exception e) {

        }
        return null;
    }

    public boolean signUp(String user, String pass) 
    throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //check connection
            con = DBHelpers.makeConnection();
            if (con != null) {
                // create sql string
                String sql = "Insert Into Account "
                        + "Values(?, ?, 0, 0) ";
                        
                //create statement object to load to sql string
                stm = con.prepareStatement(sql);
                stm.setString(1, user);
                stm.setString(2, pass);
                int affectedRow = stm.executeUpdate();
                if(affectedRow > 0){
                    return true;
                }
            }
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;

    }
}
