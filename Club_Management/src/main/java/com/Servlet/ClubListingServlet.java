package com.Servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.DAO.ClubDAO;
import com.entities.Club;

public class ClubListingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        List<Club> club =ClubDAO.getAllClubs();


        session.setAttribute("clubs", club);
        request.getRequestDispatcher("club_listing.jsp").forward(request, response);

    }
}
