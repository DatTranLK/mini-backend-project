/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattt.controller;

import dattt.cart.CartObject;
import dattt.item.Item;
import dattt.item.Order;
import dattt.product.ProductDAO;
import dattt.product.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jike
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/AddToCartServlet"})
public class AddToCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int quantity = 1;
        String id = request.getParameter("pid");
        try {
            if (id != null) {
                ProductDAO dao = new ProductDAO();
                ProductDTO product = dao.getProductDetail(id);
                if(product != null){
                    HttpSession session = request.getSession();
                    if(session.getAttribute("order") == null){
                        Order order = new Order();
                        List<Item> listItem = new ArrayList<>();
                        Item item = new Item();
                        item.setQuantity(quantity);
                        item.setProduct(product);
                        item.setPrice(product.getPrice());
                        listItem.add(item);
                        order.setItem(listItem);
                        session.setAttribute("order", order);
                    }else{
                        Order order = (Order)session.getAttribute("order");
                        List<Item> listItems = order.getItem();
                        boolean check = false;
                        for (Item item : listItems) {
                            if(item.getProduct().getId() == product.getId()){
                                item.setQuantity(item.getQuantity() + quantity);
                                check = true;
                            }
                        }
                        if(check == false){
                            Item item = new Item();
                            item.setQuantity(quantity);
                            item.setProduct(product);
                            item.setPrice(product.getPrice());
                            listItems.add(item);
                        }
                        session.setAttribute("order", order);
                        
                    }
                }
            }
            response.sendRedirect("HomeServlet");
        } catch (SQLException ex) {
            log("AddToCartServlet   SQL: " + ex.getMessage());
        } catch (NamingException ex) {
            log("AddToCartServlet   Naming: " + ex.getMessage());
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
