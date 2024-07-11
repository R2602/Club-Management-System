package com.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.DatabaseConnection.DatabaseConnection;
import com.entities.ClubMember;
import com.entities.User;

import java.util.ArrayList;

public class ClubMemberDAO {

    public static boolean joinClub(int userId, int clubId) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO club_members (club_id, user_id, member_name) VALUES (?, ?, ?)")) {

            User user = UserDAO.getUserById(userId);

            preparedStatement.setInt(1, clubId);
            preparedStatement.setInt(2, userId);
            preparedStatement.setString(3, user.getUsername());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static List<ClubMember> getClubMembersByClubId(int clubId) {
        List<ClubMember> clubMembers = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                 "SELECT u.user_id, u.username,u.email " +
                 "FROM club_members AS cm " +
                 "JOIN users AS u ON cm.user_id = u.user_id " +
                 "WHERE cm.club_id = ?")) {

            preparedStatement.setInt(1, clubId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    ClubMember clubMember = new ClubMember();
                    clubMember.setUserId(resultSet.getInt("user_id"));
                    clubMember.setMemberName(resultSet.getString("username"));
                    clubMember.setEmail(resultSet.getString("email"));
                    clubMembers.add(clubMember);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clubMembers;
    }


    public static boolean isUserMemberOfClub(int userId, int clubId) {
        boolean isMember = false;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT COUNT(*) FROM club_members WHERE user_id = ? AND club_id = ?")) {

            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, clubId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    isMember = count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isMember;
    }
}

