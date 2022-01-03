/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattt.order;

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
public class OrderDAO implements Serializable{
    public boolean addOrders(int uid, String productID, int amount, double total) 
    throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            //check connection
            con = DBHelpers.makeConnection();
            if(con != null){
                //create sql string
                String sql = "Insert Into Cart "
                        + "Values( ?, ?, ?, ?) ";
                //create statement object to load to sql string
                stm = con.prepareStatement(sql);
                stm.setInt(1, uid);
                stm.setString(2, productID);
                stm.setInt(3, amount);
                stm.setDouble(4, total);
                //4 execute query
                int affectedRow = stm.executeUpdate();
                if(affectedRow > 0){
                    return true;
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
        return false;
    }
}
