/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.AdminValues;
import beans.ErrorMessage;
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
public class AdminServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        
        
        /*
        MEEZO IF YOU ADD ANYTHING TO THIS PAGE BE VERY CAREFUL. There are a LOT OF parameters available in this page and you could get
        name collisions. TALK TO ME FIRST if you add anything here!!!! - Justin
        */
        
        response.setContentType("text/html;charset=UTF-8");
        DBUtilities adminDB = DBUtilities.getInstance();
        Utilities util = Utilities.getInstance();
        AdminValues adminMsg = new AdminValues();
        adminMsg.setMsg("Welcome Admin!");
        String action = request.getParameter("action");
        String removeUser = request.getParameter("removeUser");
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null) { //First Check to determine if user Accessing this page is an admin or not. Security check.
            ErrorMessage eMsg = new ErrorMessage();
            eMsg.setMsg("You tried Accessing Admin page without Admin Rights! Please try again");
            request.setAttribute("ErrorMessage", eMsg);
            util.forwardRequest(request, response, "WEB-INF/error.jsp");
        } 
        else if (action == null) {          //If user Visiting /Admin page via Admin Link.
            adminMsg.setMsg("Welcome Admin. Please pick an Option to do!");
        } 
        
        //Removing Users Functionality.
        else if (action.equals("removeUser")) {   //Checks if user making request is an admin. if the form was filled and not white space.
            String user = request.getParameter("removeUser");
            if (user != null && !user.trim().equals("")) {
                if (adminDB.usernameExist(user)) { //checking if username entered exists
                    if (adminDB.userTypeAdmin(user)) { //if does exist making sure user being deleted is NOT ADMIN.
                        adminMsg.setMsg("Sorry but the user " + user + " you tried deleting is an admin!");
                    } else // adminDB.removeUser(user);
                    {
                        if (adminDB.removeUser(user) == 1) {
                            adminMsg.setMsg("You have sucessfully Deleted " + user + " From the database.");
                        } else {
                            adminMsg.setMsg("An error occured In Deleting " + user + " From the database");
                        }
                    }
                } else {
                    adminMsg.setMsg("The userName you supplied was invalid");
                }
            } else {
                adminMsg.setMsg("Please Fill in the Form to continue");
            }
        } //End Removing Users Functionality.
        
        
        //Start Add User Functionality.
        else if(action.equals("addUser")){
            String addUserName = request.getParameter("addUserName");
            String addPassword = request.getParameter("addPassword");
            if(addUserName != null && addPassword != null && !addUserName.trim().equals("") && !addPassword.trim().equals("")){
                if(adminDB.usernameExist(addUserName)){
                    adminMsg.setMsg("Sorry but that user name already exists!");
                }
                else{
                    if(adminDB.userRegister(addUserName, addPassword) ==1){
                        adminMsg.setMsg("you sucessfully Registered "+addUserName);
                    }else{
                        adminMsg.setMsg("There was an error in registering "+addUserName);
                    }
                }
            }else{
                adminMsg.setMsg("Please Fill in the Forms to continue");
            }
        }//End of Adding Users Functionality.
        
        //Start Get Users Password Functionality
        else if(action.equals("retrievePassword")){
            String getUserName = request.getParameter("retrievePassword");
            if(getUserName != null && !getUserName.trim().equals("")){
                if(adminDB.usernameExist(getUserName)){
                    String pass = adminDB.getUserPassword(getUserName);
                    adminMsg.setMsg(getUserName+"'s password is: "+pass);
                    //get password
                }else{
                    adminMsg.setMsg("Sorry but that username doesn't exist!");
                }
            }
            else{
                adminMsg.setMsg("Please Fill in the Username Form to continue");
            }               
        }//End of Get user Password Functionality.
        
        //Start addAdmin Functionality
        else if(action.equals("addAdmin")){
            String addAdmin = request.getParameter("addAdmin");
            if(addAdmin != null && !addAdmin.trim().equals("")){
                if(adminDB.usernameExist(addAdmin)){
                    if(!adminDB.userTypeAdmin(addAdmin)){
                        if(adminDB.addAdminUser(addAdmin) ==1){
                            adminMsg.setMsg("You Sucessfully made "+addAdmin+" a user with Administration rights");
                        }else{
                            adminMsg.setMsg("Sorry but an error occured trying to make "+addAdmin+" an admin...");
                        }
                    }else{
                        adminMsg.setMsg("Sorry but that username is already an Admin!");
                    }
                    //make Admin
                }else{
                    adminMsg.setMsg("Sorry but that username doesn't exist!");
                }
            }
            else{
                adminMsg.setMsg("Please Fill in the Username Form to continue");
            }           
        } // End addAdmin Functionality.
        
        //Start removeAdmin functionality.
        else if(action.equals("removeAdmin")){
            String removeAdmin = request.getParameter("removeAdmin");
            if(removeAdmin != null && !removeAdmin.trim().equals("")){
                if(adminDB.usernameExist(removeAdmin)){
                    if(adminDB.userTypeAdmin(removeAdmin)){
                        if(adminDB.removeAdminUser(removeAdmin)==1){
                            adminMsg.setMsg("You Sucessfully took away "+removeAdmin+"'s Administration rights");
                        }else{
                            adminMsg.setMsg("Sorry but an error occured trying to take away "+removeAdmin+"'s admin rights...");
                        }
                    }else{
                        adminMsg.setMsg("Sorry but that username is already a regular user!");
                    }
                    
                }else{
                    adminMsg.setMsg("Sorry but that username doesn't exist!");
                }
                
                
            }
            else{
                adminMsg.setMsg("Please Fill in the Username Form to continue");
            }
        }//End of Remove Admin Functionality
        
        
        request.setAttribute("adminMessage", adminMsg);
        util.forwardRequest(request, response, "WEB-INF/admin.jsp");

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
        } catch (SQLException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
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
