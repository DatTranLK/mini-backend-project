/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattt.controller;

import dattt.account.AccountDTO;
import dattt.category.CategoryDAO;
import dattt.category.CategoryDTO;
import dattt.product.ProductDAO;
import dattt.product.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "ManagerProductServlet", urlPatterns = {"/ManagerProductServlet"})
public class ManagerProductServlet extends HttpServlet {
    private final String MANAGER_PRODUCT_PAGE = "ManagerProduct.jsp";
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
        
        String url = MANAGER_PRODUCT_PAGE;
        
        try {
            HttpSession session = request.getSession();
            AccountDTO a = (AccountDTO) session.getAttribute("acc");
            int sell_ID = a.getIsSell();
            ProductDAO dao = new ProductDAO();
            List<ProductDTO> list = dao.getProductBySellID(sell_ID);
            request.setAttribute("listP", list);
            //for category
            CategoryDAO daoCate = new CategoryDAO();
            List<CategoryDTO> listCate = daoCate.getCategoryList();

            request.setAttribute("listCC", listCate);
            url = MANAGER_PRODUCT_PAGE;
        }catch(SQLException ex){
            log("ManagerProductServlet   SQL: "+ex.getMessage());
        }catch(NamingException ex){
            log("ManagerProductServlet   Naming: "+ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
