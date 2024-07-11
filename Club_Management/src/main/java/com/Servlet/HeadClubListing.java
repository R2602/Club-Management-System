package com.Servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.ClubDAO;
import com.DAO.ClubMemberDAO;
import com.DAO.UserDAO;
import com.entities.ClubMember;
import com.entities.Event;
import com.entities.Notice;
import com.entities.UserClub;
import com.entities.UserInfo;

public class HeadClubListing extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        int clubId = Integer.parseInt(request.getParameter("clubId"));


        // Correct the method call and variable name
        List<UserClub> clubs = ClubDAO.getClubsByUserId(userId);
		List<Event>events = ClubDAO.getEventsByClubId(clubId );
        List<Notice>notices = ClubDAO.getNoticeByClubId(clubId);
        List<ClubMember>clubMembers = ClubMemberDAO.getClubMembersByClubId(clubId);
        List<UserInfo> users = UserDAO.getUserInfo();



        session.setAttribute("clubs", clubs);
        session.setAttribute("events", events);
        session.setAttribute("notices", notices);
        session.setAttribute("clubMembers", clubMembers);
        session.setAttribute("users", users);

        request.getRequestDispatcher("head_dashboard.jsp").forward(request, response);
    }
}
