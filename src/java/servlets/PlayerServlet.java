/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.CommentValues;
import beans.ErrorMessage;
import utils.DBUtilities;
import utils.Utilities;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.PlayerValues;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Justin
 */
public class PlayerServlet extends HttpServlet {

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
        DBUtilities playerDB = DBUtilities.getInstance();
        PlayerValues nValues = new PlayerValues();
        ArrayList<PlayerValues> allPlayers = new ArrayList<PlayerValues>();
        ArrayList<CommentValues> allComments = new ArrayList<CommentValues>();
        Utilities util = Utilities.getInstance();
        ErrorMessage eMsg = new ErrorMessage();
        String action = request.getParameter("action");

        String playerID = request.getParameter("p");
        if (playerID == null) {

            allPlayers = playerDB.allPlayers();
            request.setAttribute("allplayers", allPlayers);

        } else if (playerDB.playerFound(playerID)) {
            if (request.getSession().getAttribute("username") != null) { //makes sure user signed in to avoid crash if specifically call action as GET parameter
                if (action == null) {
                } //Start of AddComment functionality.
                else if (action.equals("addComment")) {
                    String user = (String) request.getSession().getAttribute("username");
                    String userId = playerDB.getUserId(user);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date d = new Date();
                    String date = dateFormat.format(d);
                    String commentText = request.getParameter("addComment");
                    int i = playerDB.addComment(userId, playerID, commentText, date);

                }//End Add comment Functionality.
                //Start edit Comments Functionality.
                else if (action.equals("editComment")) {
                    String user = (String) request.getSession().getAttribute("username");
                    String userId = playerDB.getUserId(user);
                    String commentText = request.getParameter("editComment");
                    String commentId = request.getParameter("editCommentId");
                    int i = playerDB.editComment(userId, playerID, commentText, commentId);

                }//end of Edit Comments Funtionality.
                //Start remove Comments Functionality
                else if (action.equals("Remove")) {
                    String commentId = request.getParameter("removeCommentId");
                    int i = playerDB.removeComment(commentId);
                }
            }

            nValues = playerDB.playerStats(playerID);
            request.setAttribute("playerValues", nValues);
            if (playerDB.commentsExist(playerID)) { //checks if comments are available for display on this page
                allComments = playerDB.playerComments(playerID);
            }
            request.setAttribute("allcomments", allComments); //Sets the comments to be passed as request attribute.
            request.setAttribute("player", playerID);

        } else {
            eMsg.setMsg("Sorry but an error occured with your request for a certain Player :( sorry!");
            request.setAttribute("ErrorMessage", eMsg);
            util.forwardRequest(request, response, "/WEB-INF/error.jsp");

        }

        util.forwardRequest(request, response, "/WEB-INF/players.jsp");

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
            Logger.getLogger(PlayerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PlayerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
