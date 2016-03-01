/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.ErrorMessage;
import beans.UserValues;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.DBUtilities;
import utils.Utilities;

/**
 *
 * @author Justin
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        Utilities util = Utilities.getInstance();
        DBUtilities dbLogin = DBUtilities.getInstance();
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60 * 60 * 5);//Set time to invalidate to 5 hours 
        UserValues valueObject = new UserValues();

        String action = request.getParameter("action");
        if (action == null) {
            valueObject.setMsg("Please enter a username and Password");
        } //Register Processing 
        else if (action.equals("Register")) {
            String par_username = request.getParameter("username");
            String par_password = request.getParameter("password");

            if (dbLogin.usernameExist(par_username)) {
                valueObject.setUsername(par_username);
                valueObject.setMsg("Sorry!! This username (" + par_username + ") already exists");
            } else if (dbLogin.userRegister(par_username, par_password) == 1) {
                //Start record last used login credential functionality.                
                util.lastLoginCookie(response, par_username);
                valueObject.setMsg("You have successfully Registered !");
            }
        } else {
            util.errorRedirect(request, "Sorry but we encountered an error Registering");
            util.forwardRequest(request, response, "WEB-INF/error.jsp");
        }
        request.setAttribute("vObj", valueObject);
        util.forwardRequest(request, response, "WEB-INF/register.jsp");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
