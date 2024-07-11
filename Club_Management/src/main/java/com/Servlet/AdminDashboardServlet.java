package com.Servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.entities.UserInfo;

@WebServlet("/AdminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String adminName = (String) session.getAttribute("adminName");
        if (adminName != null) {
            List<UserInfo> users = UserDAO.getUserInfo();

            session.setAttribute("users", users);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin_dashboad.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/admin_login.jsp");
        }
    }
}
