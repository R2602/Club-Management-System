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
import com.DAO.ClubMemberDAO;
import com.entities.Club;
import com.entities.ClubMember;
import com.entities.Event;
import com.entities.Feedback;
import com.entities.Notice;
@WebServlet("/ClubDetailsServlet")
public class ClubDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        int clubId = Integer.parseInt(request.getParameter("clubId"));

        Club club = ClubDAO.getClubById(clubId);

        List<ClubMember>clubMembers = ClubMemberDAO.getClubMembersByClubId(clubId);
        List<Event>events = ClubDAO.getEventsByClubId(clubId);
        List<Notice>notices = ClubDAO.getNoticeByClubId(clubId);
        List<Feedback>feedbacks = ClubDAO.getFeedBackByClubId(clubId);       
        session.setAttribute("club",club);
        session.setAttribute("clubMembers",clubMembers);
        session.setAttribute("events",events);
        session.setAttribute("notices", notices);
        session.setAttribute("feedbacks", feedbacks);
        // Forward the request to club_details.jsp, which includes members_card.jsp
        request.getRequestDispatcher("club_details.jsp").forward(request, response);
    }

}

