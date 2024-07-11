package com.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DatabaseConnection.DatabaseConnection;

/**
 * Servlet implementation class CreateClub
 */
@WebServlet("/createClub")
public class CreateClub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateClub() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String year = request.getParameter("year");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		String query = "INSERT INTO clubs (club_name, description, founded_year, user_id) VALUES (?,?,?,?)";
		
		try( Connection connection = DatabaseConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)){
			pst.setString(1,name);
			pst.setString(2,description);
			pst.setString(3,year);
			pst.setInt(4,userId);

            pst.executeUpdate();

		}
		catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("head_dashboard.jsp");
			
	}

}
