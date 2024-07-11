package com.Servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.ClubDAO;
@WebServlet("/JoinClubServlet")
public class JoinClubServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the clubId parameter from the request
        int clubId = Integer.parseInt(request.getParameter("clubId"));
        
        // Get the userId of the logged-in user from the session
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId != null) {
            int userIdValue = userId.intValue();
            
            // Check if the user is already a member of the club
            boolean isUserAlreadyMember = ClubDAO.isUserAlreadyMember(userIdValue, clubId);
            
            if (isUserAlreadyMember) {
                // If the user is already a member, you can handle it here, e.g., show a message.
                // You might also want to redirect them back to the club details page.
                response.sendRedirect("ClubDetailsServlet?clubId=" + clubId + "&message=already-member");
            } else {
                // If the user is not a member, add them to the club
                ClubDAO.addUserToClub(userIdValue, clubId);
                
                // Redirect to the club details page with a success message
                response.sendRedirect("ClubDetailsServlet?clubId=" + clubId + "&message=joined-successfully");
            }
        } else {
            // If the user is not logged in, you can handle it here, e.g., show an error message.
            // Redirect them to an appropriate page or display an error message.
            response.sendRedirect("login.jsp?message=login-required");
        }
    }
}
