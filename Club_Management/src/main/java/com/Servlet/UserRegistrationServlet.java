package com.Servlet;

import com.DAO.UserDAO;
import com.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class UserRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (UserDAO.usernameExists(username)) {
            String errorMessage = "Username already exists. Please choose a different username.";
            String script = "<script>alert('" + errorMessage + "');window.location = 'user_reg.jsp';</script>";

            response.setContentType("text/html");
            response.getWriter().println(script);
        } else {
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setHeadUser(false);

            UserDAO.createUser(user);
            response.sendRedirect("user_login.jsp");
        }
    }
}
