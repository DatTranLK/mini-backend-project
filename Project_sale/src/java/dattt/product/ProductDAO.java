/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattt.product;

import dattt.utils.DBHelpers;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author jike
 */
public class ProductDAO implements Serializable {

    private List<ProductDTO> productList;

    public List<ProductDTO> getProductList() {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<ProductDTO> list = new ArrayList<>();
        try {
            //1 check connection
            con = DBHelpers.makeConnection();
            String sql = "Select * "
                    + "From product ";
            stm = con.prepareStatement(sql);

            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                String title = rs.getString("title");
                String description = rs.getString("description");

                ProductDTO dto = new ProductDTO(id, name, image, price, title, description);
                list.add(dto);

            }
        } catch (Exception e) {

        }
        return list;
    }

    public ProductDTO lastProduct()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //check connection
            con = DBHelpers.makeConnection();
            if (con != null) {
                // 2 create sql String
                String sql = "Select top 1 * "
                        + "From product "
                        + "order by id "
                        + "desc ";
                // create statement object to load to sql string
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    String title = rs.getString("title");
                    String description = rs.getString("description");

                    ProductDTO dto = new ProductDTO(id, name, image, price, title, description);
                    return dto;
                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }

        }
        return null;
    }

    public List<ProductDTO> getProductByCategory(String cateID) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<ProductDTO> list = new ArrayList<>();
        try {
            //1 check connection
            con = DBHelpers.makeConnection();
            String sql = "Select * "
                    + "From product "
                    + "Where cateID = ? ";
            stm = con.prepareStatement(sql);
            stm.setString(1, cateID);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                String title = rs.getString("title");
                String description = rs.getString("description");

                ProductDTO dto = new ProductDTO(id, name, image, price, title, description);
                list.add(dto);

            }
        } catch (Exception e) {

        }
        return list;
    }

    public ProductDTO getProductDetail(String id)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //check connection
            con = DBHelpers.makeConnection();
            if (con != null) {
                // create sql String
                String sql = "Select * "
                        + "From product "
                        + "Where id = ? ";
                // cteate statement object to load to sql string
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id2 = rs.getInt("id");
                    String name = rs.getString("name");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    String title = rs.getString("title");
                    String description = rs.getString("description");

                    ProductDTO dto = new ProductDTO(id2, name, image, price, title, description);
                    return dto;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public List<ProductDTO> searchProduct(String keyword)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<ProductDTO> list = new ArrayList<>();
        try {
            //check connection
            con = DBHelpers.makeConnection();
            if (con != null) {
                //create sql string
                String sql = "Select * "
                        + "From product "
                        + "Where name LIKE ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + keyword + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    String title = rs.getString("title");
                    String description = rs.getString("description");

                    ProductDTO dto = new ProductDTO(id, name, image, price, title, description);

                    list.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public List<ProductDTO> getProductBySellID(int sellID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<ProductDTO> list = new ArrayList<>();

        try {
            //check connection
            con = DBHelpers.makeConnection();
            if (con != null) {
                // create sql string
                String sql = "Select * "
                        + "From product "
                        + "Where sell_ID = ? ";
                //create statement object to load to sql string
                stm = con.prepareStatement(sql);
                //set value to parameter
                stm.setInt(1, sellID);
                //execute query
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    String title = rs.getString("title");
                    String description = rs.getString("description");

                    ProductDTO dto = new ProductDTO(id, name, image, price, title, description);
                    list.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public void deleteProduct(String id)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            //check connection
            con = DBHelpers.makeConnection();
            if (con != null) {
                //create sql string
                String sql = "Delete From product "
                        + "Where id = ? ";
                //create statement object to load to sql string
                stm = con.prepareStatement(sql);
                //set value to parameter
                stm.setString(1, id);
                //execute query
                stm.executeUpdate();
            }

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void addProduct(String name, String image, int price, String title, String desctription, String category, int sell_ID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            //check connection
            con = DBHelpers.makeConnection();
            if (con != null) {
                //create sql string
                String sql = "INSERT [dbo].[product] ([name], [image], [price], [title], [description], [cateID], [sell_ID]) "
                        + "VALUES (?,?,?,?,?,?,?) " ;    
                //create statement object to load to sql string
                stm = con.prepareStatement(sql);
                //set value to parameter
                stm.setString(1, name);
                stm.setString(2, image);
                stm.setInt(3, price);
                stm.setString(4, title);
                stm.setString(5, desctription);
                stm.setString(6, category);
                stm.setInt(7, sell_ID);
                //execute query
                stm.executeUpdate();
            }

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    public void updateProduct(String id, String name, String image, int price, String title, String description, String cateID)
    throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        try{
            //check connection 
            con = DBHelpers.makeConnection();
            if(con != null){
                //create sql String 
                String sql = "Update product "
                        + "Set [name] = ? , [image] = ? , [price] = ?, [title] = ?, [description] = ?, cateID = ? "
                        + "Where id = ? ";
                // create statement object to load to sql string
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setString(2, image);
                stm.setInt(3, price);
                stm.setString(4, title);
                stm.setString(5, description);
                stm.setString(6, cateID);
                stm.setString(7, id);
                stm.executeUpdate();
            }
            
        } finally{
            
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
