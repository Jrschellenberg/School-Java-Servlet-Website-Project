/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import beans.ErrorMessage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Justin
 */
public class Utilities {

    private volatile static Utilities uniqueInstance;

    /**
     *
     * @return Returns an instance of itself.
     */
    public static Utilities getInstance() {     //using the Single design pattern to ensure only 1 of this object is created in memory.
        if (uniqueInstance == null) {
            synchronized (Utilities.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Utilities();
                }
            }

        }
        return uniqueInstance;
    }

    /**
     *
     * @param target The cookie name we are searching for
     * @param cookies an array of all the cookies stored on the browswer
     * requesting the site
     * @return Returns true if the cookie found, else returns false.
     */
    public boolean foundCookie(String target, Cookie[] cookies) {
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (target.equals(cookie.getName())) {        //A cookie with user login credentials was found. Push them to home.jsp                    
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param lastLogin The Cookie used to determine who last Logged into the
     * website
     * @param request The request forwarded from the servlet
     */
    public void setLastLoginCookie(Cookie lastLogin, HttpServletRequest request) {
        String userNamePlaceholder = "";
        if (lastLogin != null) {
            userNamePlaceholder = lastLogin.getValue();
        }
        request.setAttribute("name", userNamePlaceholder);

    }

    /**
     *
     * @param target The cookie name we are searching for
     * @param cookies an array of all the cookies stored on the browswer
     * requesting the site
     * @return Cookie, returns the cookie if found, else returns null.
     */
    public Cookie getCookie(String target, Cookie[] cookies) {
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (target.equals(cookie.getName())) {        //A cookie with user login credentials was found. Push them to home.jsp                    
                    return cookie;
                }
            }
        }
        return null;
    }

    /**
     *
     * @param request The request forwarded from the servlet
     * @param response the response forwarded from the servlet
     * @param url The destination path the servlet is trying to forward to.
     * @throws ServletException
     * @throws IOException
     */
    public void forwardRequest(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    /**
     *
     * @param request The request forwarded from the servlet
     * @param response the response forwarded from the servlet
     * @param url The destination path the servlet is trying to include.
     * @throws ServletException
     * @throws IOException
     */
    public void includeRequest(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.include(request, response);
    }

    /**
     *
     * @param request The request forwarded from the Servlet
     * @param e The error message to be displayed by the bean in the view.
     */
    public void errorRedirect(HttpServletRequest request, String e) {
        ErrorMessage eMsg = new ErrorMessage();
        eMsg.setMsg(e);
        request.setAttribute("ErrorMessage", eMsg);

    }

    /**
     *
     * @param response The httpServlet Response forwarded from the Servlet
     * @param username The user name value to store in the cookie
     */
    public void lastLoginCookie(HttpServletResponse response, String username) {
        Cookie lastLoginCookie = new Cookie("lastLogin", username);
        lastLoginCookie.setMaxAge(60 * 60 * 24 * 7); //Set to 1 week.
        response.addCookie(lastLoginCookie);

    }

}
