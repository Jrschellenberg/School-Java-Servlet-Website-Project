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
import java.util.Date;
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
public class LoginServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60 * 60 * 5);//Set time to invalidate to 5 hours 
        UserValues valueObject = new UserValues();
        Utilities util = Utilities.getInstance();

        DBUtilities dbLogin = DBUtilities.getInstance();

        Cookie[] cookies = request.getCookies();
        Cookie lastLogin = util.getCookie("lastLogin", cookies);

        String action = request.getParameter("action");
        if (action == null) {
            valueObject.setMsg("Welcome to Shoot 24! Please use the form below to login. If you haven't registered, please do so on our register page!");
            util.setLastLoginCookie(lastLogin, request);
        } //Login Processing 
        else if (action.equals("Login")) {//If user clicked Login Button.          
            String par_username = request.getParameter("username");
            String par_password = request.getParameter("password");
            if (dbLogin.userLogin(par_username, par_password)) {
                //Create a session on successful log in 
                session.setAttribute("username", par_username);
                //Checking if Cookie tied to the username exists
                Cookie cookie = util.getCookie(par_username, cookies);
                Date d = new Date();
                if (cookie == null) { //If browsers has no cookies associated with logging into website.
                    cookie = new Cookie(par_username, d.toString());
                    valueObject.setMsg("Welcome " + cookie.getName() + " For the first time!");
                } else {
                    valueObject.setMsg("Welcome Back " + cookie.getName() + " The last time you visited here was " + cookie.getValue());
                    cookie = new Cookie(par_username, d.toString());
                }
                cookie.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(cookie);
                //end Users last Login functionality.

                //Start record last used login credential functionality.                
                util.lastLoginCookie(response, par_username);
                if (dbLogin.userTypeAdmin(par_username)) {
                    session.setAttribute("admin", true);
                }
                valueObject.setUsername(par_username);
            } else {
                valueObject.setMsg("The username and/or password you supplied do not match our records. :(");
            }

        } //Logout Processing 
        else if (action.equals("Logout")) {
            //??which one
            session.invalidate();
            // session.removeAttribute("username");
            // session.removeAttribute("admin");
            valueObject.setMsg("Thanks For Visiting!! you have successfully logged out");
            util.setLastLoginCookie(lastLogin, request);
        } else {
            util.errorRedirect(request, "Sorry but we encountered an error Trying to log you in!");
            util.forwardRequest(request, response, "WEB-INF/error.jsp");
        }
        request.setAttribute("vObj", valueObject);
        util.forwardRequest(request, response, "WEB-INF/login.jsp");
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
