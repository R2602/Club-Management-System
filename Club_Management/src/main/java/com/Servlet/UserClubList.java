package com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.ClubDAO;
import com.entities.UserClub;

/**
 * Servlet implementation class UserClubList
 */
@WebServlet("/userclublist")
public class UserClubList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserClubList() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");

        List<UserClub> clubs = ClubDAO.getClubsByUserId(userId);
        session.setAttribute("clubs", clubs);

        request.getRequestDispatcher("userclublisting.jsp").forward(request, response);
    }
}
