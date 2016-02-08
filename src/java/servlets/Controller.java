/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.LoginValues;
import java.io.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author HFamily
 */
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        //Get session but only add username on successful login
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(300);//Set time to invalidate to 5 minutes                
        
        Login dbLogin = new Login();
        LoginValues valueObject = new LoginValues();

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        if (action.equals("Login")) {
            String par_username = request.getParameter("username");
            String par_password = request.getParameter("password");
 
            if (par_username == null || par_password == null || par_username.equals("") || par_password.equals("")) {
                valueObject.setMsg("Please fill in the username and password fields!");
            } else if (dbLogin.userLogin(par_username, par_password)) {
                //Create a session on successful log in 
               // session.invalidate();
                session.setAttribute("username", par_username);
                
                if(dbLogin.userTypeAdmin(par_username)){
                    session.setAttribute("admin", true);
                    
                }

                
                
                valueObject.setUsername(par_username);
                valueObject.setMsg("you have successfully logged in");
            } else {
                
                valueObject.setMsg("The username and/or password you supplied do not match our records. :(");
            }
            
            
        }

        request.setAttribute("vObj", valueObject);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");        
        dispatcher.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
