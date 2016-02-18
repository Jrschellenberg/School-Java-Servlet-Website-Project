/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.ErrorMassage;
import beans.UserValues;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
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
public class LoginServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60*60*5);//Set time to invalidate to 5 hours 
        UserValues valueObject = new UserValues();
        Utilities util = new Utilities();
        ErrorMassage eMsg = new ErrorMassage();
        DBUtilities dbLogin = DBUtilities.getInstance();
        eMsg.setMsg("Sorry but we encountered an error!");
        request.setAttribute("ErrorMassage", eMsg);
        
        String action = request.getParameter("action");
        if (action == null) {
            valueObject.setMsg("Welcome to Shoot 24! Please use the form below to login. If you haven't registered, please do so on our register page!");
            request.setAttribute("vObj", valueObject);
            util.forwardRequest(request, response, "WEB-INF/login.jsp");
        }

        //Login Processing 
        else if (action.equals("Login")) {
            //Get session but only add username on successful login          
            String par_username = request.getParameter("username");
            String par_password = request.getParameter("password");

            if (par_username == null || par_password == null || par_username.equals("") || par_password.equals("")) {
                valueObject.setMsg("Please fill in the username and password fields!");
            } else if (dbLogin.userLogin(par_username, par_password)) {
                //Create a session on successful log in 
                session.setAttribute("username", par_username);

                if (dbLogin.userTypeAdmin(par_username)) {
                    session.setAttribute("admin", true);
                }
                valueObject.setUsername(par_username);
                valueObject.setMsg("you have successfully logged in");
            } else {

                valueObject.setMsg("The username and/or password you supplied do not match our records. :(");
            }

            request.setAttribute("vObj", valueObject);
            //response.sendRedirect(request.getContextPath()+"/Login");
            util.forwardRequest(request, response, "WEB-INF/login.jsp");
        }
                //Logout Processing 
        else if (action.equals("Logout")) {
          
            session.invalidate();

            valueObject.setMsg("Thanks For Visiting!! you have successfully logged out");

            request.setAttribute("vObj", valueObject);
            //response.sendRedirect(request.getContextPath()+"/Login");
            util.forwardRequest(request, response, "WEB-INF/login.jsp");
        }
        else{
            util.forwardRequest(request, response, "WEB-INF/error.jsp");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
