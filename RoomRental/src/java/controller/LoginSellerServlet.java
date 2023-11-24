/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LoginSellerAuthenticator;

/**
 *
 * @author ADM
 */
public class LoginSellerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("loginSeller.html");
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        
        UserDTO user=new UserDTO();
        user.setUsername(username);
        user.setPassword(password);
        
        LoginSellerAuthenticator l1 = new LoginSellerAuthenticator();
        boolean login= l1.isLogin(user);
        
        if(login)
        {
            HttpSession session=request.getSession(true);
            session.setAttribute("username",username);
            response.sendRedirect("sellerhome.jsp");
        }
        else
        {
            response.sendRedirect("loginSeller.html");
        }
    }
}
