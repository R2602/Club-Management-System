package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminUsername = request.getParameter("username");
        String adminPassword = request.getParameter("password");

        // Validate admin credentials (you should check against your database)
        if (adminUsername.equals("admin") && adminPassword.equals("admin123")) {
            HttpSession session = request.getSession();
            session.setAttribute("adminName", adminUsername);
            response.sendRedirect(request.getContextPath() + "/AdminDashboardServlet");
        } else {
            response.sendRedirect(request.getContextPath() + "/admin_login.jsp");
        }
    }
}
