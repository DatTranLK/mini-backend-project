/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattt.category;

import dattt.utils.DBHelpers;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jike
 */
public class CategoryDAO implements Serializable{
    private  List<CategoryDTO> categoryList;

    public List<CategoryDTO> getCategoryList() {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<CategoryDTO> list = new ArrayList<>();
        try {
            //check connection
            con = DBHelpers.makeConnection();
            String sql = "Select * "
                    + "From Category ";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()){
                int cid = rs.getInt("cid");
                String cname = rs.getString("cname");
                
                CategoryDTO dto = new CategoryDTO(cid, cname);
                list.add(dto);
            }
        } catch (Exception e) {
        }
        
        return list;
    }
    
}
