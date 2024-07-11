package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.DAO.UserDAO;
import com.entities.User;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = UserDAO.getUserByUsernameAndPassword(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("email", user.getEmail());

            boolean isHeadUser = user.isHeadUser(); // Use the isHeadUser method

            if (isHeadUser) {
                response.sendRedirect("head_dashboard.jsp");
            } else {
                response.sendRedirect("club-listing");
            }
        } else {
            // Add JavaScript to display an alert
            String errorMessage = "Invalid username or password. Please try again.";
            String script = "<script>alert('" + errorMessage + "');window.location = 'signinup.jsp';</script>";

            response.setContentType("text/html");
            response.getWriter().println(script);
        }
    }
}
