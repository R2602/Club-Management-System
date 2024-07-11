package com.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DatabaseConnection.DatabaseConnection;
import com.entities.User;
import com.entities.UserInfo;

public class UserDAO {

	
	
    public static User getUserById(int userId) {
        User user = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE user_id = ?")) {

            preparedStatement.setInt(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User();
                    user.setUserId(resultSet.getInt("user_id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setHeadUser(resultSet.getBoolean("is_head_user")); 
                } else {
                    System.out.println("No user found with user_id: " + userId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error fetching user with user_id: " + userId);
        }

        return user;
        
        
    }
    
    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM users")) {

            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setHeadUser(resultSet.getBoolean("is_head_user")); 

                // Fetch and set joined clubs for user
                
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error fetching all users.");
        }
        return users;
    }
    
    public static boolean updateHeadStatus(int userId, int newHeadStatus) {
        String query = "UPDATE users SET is_head_user = ? WHERE user_id = ?";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, newHeadStatus);
            preparedStatement.setInt(2, userId);

            int rowsUpdated = preparedStatement.executeUpdate();

            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	public static User getUserByUsernameAndPassword(String username, String password) {
		 User user = null;
		 User adminUser = new User();
		 adminUser.setUsername("admin");
		 adminUser.setPassword("admin123");
		 adminUser.setAdmin(true); 

		    try (Connection connection = DatabaseConnection.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(
		            "SELECT * FROM users WHERE username = ? AND password = ?")) {

		        preparedStatement.setString(1, username);
		        preparedStatement.setString(2, password);

		        try (ResultSet resultSet = preparedStatement.executeQuery()) {
		            if (resultSet.next()) {
		                user = new User();
		                user.setUserId(resultSet.getInt("user_id"));
		                user.setUsername(resultSet.getString("username"));
		                user.setEmail(resultSet.getString("email"));
		                user.setPassword(resultSet.getString("password"));
		                user.setHeadUser(resultSet.getBoolean("is_head_user")); 
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return user;
		}

    public static void createUser(User user) {
        String query = "INSERT INTO users (username, email, password, is_head_user) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setBoolean(4, user.isHeadUser());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<String> getJoinedClubNames(int userId) {
        List<String> joinedClubNames = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                 "SELECT c.club_name FROM clubs c " +
                 "INNER JOIN club_members cm ON c.club_id = cm.club_id " +
                 "WHERE cm.user_id = ?")) {

            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String clubName = resultSet.getString("club_name");
                    joinedClubNames.add(clubName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return joinedClubNames;
    }
    public class UserClubInfo {
        private int userId;
        private int clubId;

        public UserClubInfo(int userId, int clubId) {
            this.userId = userId;
            this.clubId = clubId;
        }

        public int getUserId() {
            return userId;
        }

        public int getClubId() {
            return clubId;
        }
    }
    public static boolean usernameExists(String username) {
        Connection conn = null;
    	PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
        	Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT COUNT(*) FROM users WHERE username = ?";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; 
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly in your application.
        } finally {
            // Close resources in reverse order: ResultSet, Statement, Connection.
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Handle the exception properly in your application.
            }
        }
        
        return false; // In case of an exception or if the username does not exist.
    }
    
    public static List<UserInfo> getUserInfo() {
        List<UserInfo> userInfos = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                 "SELECT * from users"
             );
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                boolean isHeadUser = resultSet.getBoolean("is_head_user");
                String email = resultSet.getString("email");

                UserInfo userInfo = new UserInfo(userId, username, isHeadUser,email);
                userInfos.add(userInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error fetching user information.");
        }

        return userInfos;
    }
}




