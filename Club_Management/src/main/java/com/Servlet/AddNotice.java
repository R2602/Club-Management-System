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
 * Servlet implementation class AddNotice
 */
@WebServlet("/addNotice")
public class AddNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNotice() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int clubId = Integer.parseInt(request.getParameter("clubId"));
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String description = request.getParameter("description");

		  String query = "INSERT INTO notices (club_id, notice_name,notice_date, notice_description) VALUES (?, ? ,? ,?)";

	        try (Connection connection = DatabaseConnection.getConnection();
	                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            preparedStatement.setInt(1,clubId );
	            preparedStatement.setString(2,name);
	            preparedStatement.setString(3,date);
	            preparedStatement.setString(4,description);

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
            response.sendRedirect("head_dashboard.jsp");

	}

}
