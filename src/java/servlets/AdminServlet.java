/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.AdminValues;
import beans.ClubValues;
import beans.ErrorMessage;
import beans.NationValues;
import beans.PlayerValues;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
        ArrayList<NationValues> nationValues = new ArrayList<NationValues>();
        ArrayList<ClubValues> clubsValues = new ArrayList<ClubValues>();
        ArrayList<PlayerValues> allPlayers = new ArrayList<PlayerValues>();
        allPlayers = adminDB.allPlayers();
        nationValues = adminDB.allNations();
        clubsValues = adminDB.allClubs();
        request.setAttribute("nations", nationValues);
        request.setAttribute("clubs", clubsValues);
        request.setAttribute("players", allPlayers);

        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null) { //First Check to determine if user Accessing this page is an admin or not. Security check.
            ErrorMessage eMsg = new ErrorMessage();
            eMsg.setMsg("You tried Accessing Admin page without Admin Rights! Please try again");
            request.setAttribute("ErrorMessage", eMsg);
            util.forwardRequest(request, response, "WEB-INF/error.jsp");
        } else if (action == null) {          //If user Visiting /Admin page via Admin Link.
            adminMsg.setMsg("Welcome Admin. Please pick an Option to do!");
        } //Removing Users Functionality.
        else if (action.equals("removeUser")) {   //Checks if user making request is an admin. if the form was filled and not white space.
            String user = request.getParameter("removeUser");
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

        } //End Removing Users Functionality.
        //Start Add User Functionality.
        else if (action.equals("addUser")) {
            String addUserName = request.getParameter("addUserName");
            String addPassword = request.getParameter("addPassword");
            if (adminDB.usernameExist(addUserName)) {
                adminMsg.setMsg("Sorry but that user name already exists!");
            } else if (adminDB.userRegister(addUserName, addPassword) == 1) {
                adminMsg.setMsg("you sucessfully Registered " + addUserName);
            } else {
                adminMsg.setMsg("There was an error in registering " + addUserName);
            }

        }//End of Adding Users Functionality.
        //Start Get Users Password Functionality
        else if (action.equals("retrievePassword")) {
            String getUserName = request.getParameter("retrievePassword");
            if (adminDB.usernameExist(getUserName)) {
                String pass = adminDB.getUserPassword(getUserName);
                adminMsg.setMsg(getUserName + "'s password is: " + pass);
                //get password
            } else {
                adminMsg.setMsg("Sorry but that username doesn't exist!");
            }

        }//End of Get user Password Functionality.
        //Start addAdmin Functionality
        else if (action.equals("addAdmin")) {
            String addAdmin = request.getParameter("addAdmin");
            if (adminDB.usernameExist(addAdmin)) {
                if (!adminDB.userTypeAdmin(addAdmin)) {
                    if (adminDB.addAdminUser(addAdmin) == 1) {
                        adminMsg.setMsg("You Sucessfully made " + addAdmin + " a user with Administration rights");
                    } else {
                        adminMsg.setMsg("Sorry but an error occured trying to make " + addAdmin + " an admin...");
                    }
                } else {
                    adminMsg.setMsg("Sorry but that username is already an Admin!");
                }
                //make Admin
            } else {
                adminMsg.setMsg("Sorry but that username doesn't exist!");
            }

        } // End addAdmin Functionality.
        //Start removeAdmin functionality.
        else if (action.equals("removeAdmin")) {
            String removeAdmin = request.getParameter("removeAdmin");
            if (adminDB.usernameExist(removeAdmin)) {
                if (adminDB.userTypeAdmin(removeAdmin)) {
                    if (adminDB.removeAdminUser(removeAdmin) == 1) {
                        adminMsg.setMsg("You Sucessfully took away " + removeAdmin + "'s Administration rights");
                    } else {
                        adminMsg.setMsg("Sorry but an error occured trying to take away " + removeAdmin + "'s admin rights...");
                    }
                } else {
                    adminMsg.setMsg("Sorry but that username is already a regular user!");
                }

            } else {
                adminMsg.setMsg("Sorry but that username doesn't exist!");
            }

        }//End of Remove Admin Functionality
        //start of Add Player Functionality
        else if (action.equals("addPlayer")) {
            String addPlayerName = request.getParameter("addPlayerFirstName") + " " + request.getParameter("addPlayerLastName");
            if (!adminDB.playerExist(addPlayerName)) { // If player name doesn't exist
                String addPlayerDate = request.getParameter("addPlayerDate");
                String addPlayerClub = adminDB.getClubId(request.getParameter("addPlayerClub"));
                String addPlayerNation = adminDB.getNationId(request.getParameter("addPlayerNation"));
                String addPlayerPicture = request.getParameter("addPlayerFirstName") + "-" + request.getParameter("addPlayerLastName") + ".png";
                String addPlayerPosition = request.getParameter("addPlayerPosition");
                String addPlayerHeight = request.getParameter("addPlayerHeight");
                String addPlayerNumber = request.getParameter("addPlayerNumber");
                String addPlayerFoot = request.getParameter("addPlayerFoot");
                if (adminDB.addPlayer(addPlayerNation, addPlayerClub, addPlayerName, addPlayerDate, addPlayerPicture, addPlayerPosition, addPlayerHeight, addPlayerNumber, addPlayerFoot) == 1) {
                    adminMsg.setMsg("You Sucessfully added " + addPlayerName + " To the database");
                } else {
                    adminMsg.setMsg("Sorry but an error occured adding " + addPlayerName + " To the database");
                }
                allPlayers = adminDB.allPlayers();
                request.setAttribute("players", allPlayers);

            } else {
                adminMsg.setMsg("Sorry but that Player is already entered in the database!");
            }
            nationValues = adminDB.allNations();
            clubsValues = adminDB.allClubs();
            request.setAttribute("nations", nationValues);
            request.setAttribute("clubs", clubsValues);

        }//End of Add Player Functionality.
        //Start Edit Player Functionality.
        else if (action.equals("editPlayer")) {
            String editPlayerName = request.getParameter("editPlayerName");
            String editPlayerDate = request.getParameter("editPlayerDate");
            String editPlayerClub = adminDB.getClubId(request.getParameter("editPlayerClub"));
            String editPlayerNation = adminDB.getNationId(request.getParameter("editPlayerNation"));
            String editPlayerPicture = adminDB.getPlayerPicture(editPlayerName);
            String editPlayerPosition = request.getParameter("editPlayerPosition");
            String editPlayerHeight = request.getParameter("editPlayerHeight");
            String editPlayerNumber = request.getParameter("editPlayerNumber");
            String editPlayerFoot = request.getParameter("editPlayerFoot");

            if (adminDB.editPlayer(editPlayerNation, editPlayerClub, editPlayerName, editPlayerDate, editPlayerPicture, editPlayerPosition, editPlayerHeight, editPlayerNumber, editPlayerFoot) == 1) {
                adminMsg.setMsg("Successfully updated " + editPlayerName + " in the database");
            } else {
                adminMsg.setMsg("Sorry but an error occured updating " + editPlayerName + " in the database");
            }
            
               // adminMsg.setMsg("PlayerName: "+editPlayerName+"\n PlayerDate: "+ editPlayerDate+"\n PlayerClub: "+editPlayerClub);



            nationValues = adminDB.allNations();
            clubsValues = adminDB.allClubs();
            request.setAttribute("nations", nationValues);
            request.setAttribute("clubs", clubsValues);

        }//End of Edit Player Functionality.
        //Start Remove Player Functionality.
        else if (action.equals("removePlayer")) {
            String removePlayer = request.getParameter("removePlayer");
            if (adminDB.removePlayer(removePlayer) == 1) {
                adminMsg.setMsg("Successfully Removed " + removePlayer + " From the database");

            } else {
                adminMsg.setMsg("Sorry but an error occured removing " + removePlayer + " from the database");
            }
            allPlayers = adminDB.allPlayers();
            request.setAttribute("players", allPlayers);

        }

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
