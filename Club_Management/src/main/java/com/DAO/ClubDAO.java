package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.DatabaseConnection.DatabaseConnection;
import com.entities.Club;
import com.entities.Event;
import com.entities.Feedback;
import com.entities.Notice;
import com.entities.UserClub;

public class ClubDAO {


    public static Club getClubById(int clubId) {
        Club club = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clubs WHERE club_id = ?")) 
        {

            preparedStatement.setInt(1, clubId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    club = new Club();
                    club.setClubId(resultSet.getInt("club_id"));
                    club.setClubName(resultSet.getString("club_name"));
                    club.setDescription(resultSet.getString("description"));
                    club.setFoundedYear(resultSet.getInt("founded_year"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return club;
    }
    
    public static void createClub(Club club) {
        String query = "INSERT INTO clubs (club_name, description, founded_year) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, club.getClubName());
            preparedStatement.setString(2, club.getDescription());
            preparedStatement.setInt(3, club.getFoundedYear());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Club> getAllClubs() {
        List<Club> clubs = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clubs")) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Club club = new Club();
                    club.setClubId(resultSet.getInt("club_id"));
                    club.setClubName(resultSet.getString("club_name"));
                    club.setDescription(resultSet.getString("description"));
                    club.setFoundedYear(resultSet.getInt("founded_year"));
                    clubs.add(club);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clubs;
    }
    
    public static List<Club> getJoinedClubName(int userId) {
        List<Club> joinedClubs = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                 "SELECT c.* FROM clubs c " +
                 "INNER JOIN club_members cm ON c.club_id = cm.club_id " +
                 "WHERE cm.user_id = ?")) {

            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Club club = new Club();
                    club.setClubId(resultSet.getInt("club_id"));
                    club.setClubName(resultSet.getString("club_name"));
                    club.setDescription(resultSet.getString("description"));
                    club.setFoundedYear(resultSet.getInt("founded_year"));
                    joinedClubs.add(club);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return joinedClubs;
    }

    public static void addUserToClub(int userId, int clubId) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO club_members (user_id, club_id) VALUES (?, ?)")) {

            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, clubId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static boolean isUserAlreadyMember(int userId, int clubId) {
        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM club_members WHERE user_id = ? AND club_id = ?")
        ) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, clubId);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    
        
        public static List<Event> getEventsByClubId(int clubId) {
            List<Event> events = new ArrayList<>();
            try (Connection connection = DatabaseConnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM events WHERE club_id = ?")) {
                
                preparedStatement.setInt(1, clubId);
                
                ResultSet rs = preparedStatement.executeQuery();
                
                while (rs.next()) {
                    int eventId = rs.getInt("event_id");
                    String eventDate = rs.getString("event_date");
                    String eventDescription = rs.getString("event_description");
                    
                    Event event = new Event(eventId, clubId, eventDate, eventDescription);
                    events.add(event);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return events;
        }

		
       
        	

        	public static List<Notice> getNoticeByClubId(int clubId) {
			
			 List<Notice> notices = new ArrayList<>();
	            try (Connection connection = DatabaseConnection.getConnection();
	                 PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM notices WHERE club_id = ?")) {
	                
	                preparedStatement.setInt(1, clubId);
	                
	                ResultSet rs = preparedStatement.executeQuery();
	                
	                while (rs.next()) {
	                    int notice_id = rs.getInt("notice_id");
	                    String noticeName = rs.getString("notice_name");
	                    String noticeDate = rs.getString("notice_date");

	                    String noticeDescription = rs.getString("notice_description");
	                    
	                    Notice notice = new Notice(notice_id, clubId, noticeName,noticeDate, noticeDescription);
	                    notices.add(notice);
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            return notices;
	            }
        	public static List<Feedback> getFeedBackByClubId(int clubId) {
    			
                List<Feedback> feedbacks = new ArrayList<>();
                String jdbcURL = "";
                String dbUser = "";
                String dbPassword = "";

                try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM feedback WHERE club_id = ?")) 
                {
    	                
    	                preparedStatement.setInt(1, clubId);
    	                
    	                ResultSet rs = preparedStatement.executeQuery();
    	                
    	                while (rs.next()) {
    	                    String name = rs.getString("name");
    	                    String feedbackText = rs.getString("Feedback");

    	                    Feedback feedback = new Feedback(name,feedbackText);
    	                    feedbacks.add(feedback);
    	                }
                }
                 catch (SQLException e) {
                    e.printStackTrace();
                }
   	            return feedbacks;
        	}

        	 public static List<UserClub> getClubsByUserId(int userId) {
        	        List<UserClub> clubs = new ArrayList<>();

        	        try (Connection connection = DatabaseConnection.getConnection();
        	             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clubs WHERE user_id = ?")) {

        	            preparedStatement.setInt(1, userId);

        	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
        	                while (resultSet.next()) {
        	                    int clubId = resultSet.getInt("club_id");
        	                    String clubName = resultSet.getString("club_name");
        	                    String clubDescription = resultSet.getString("description");
        	                    int clubYear = resultSet.getInt("founded_year");

        	                    UserClub club = new UserClub(clubId, clubName, clubDescription, clubYear);
        	                    clubs.add(club);
        	                }
        	            }
        	        } catch (SQLException e) {
        	            e.printStackTrace();
        	        }

        	        return clubs;
        	    }

			}