package com.Servlet;
// Import necessary classes...

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserDAO;

@WebServlet("/changeHeadStatus")
public class ChangeHeadStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int newHeadStatus = Integer.parseInt(request.getParameter("newHeadStatus"));

        boolean success = UserDAO.updateHeadStatus(userId, newHeadStatus);

        if (success) {
            response.sendRedirect(request.getContextPath() + "/admin_dashboad.jsp");
        } else {
            response.getWriter().println("Failed to update headUser status.");
        }
    }
}
