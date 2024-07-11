<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
    <!-- Navigation bar -->
    <nav style="background-color: #333; color: #fff; padding: 10px;">
        <div style="max-width: 960px; margin: 0 auto; display: flex; justify-content: space-between; align-items: center;">
            <h1>Admin Dashboard</h1>
            <a href="logout.jsp" style="color: #fff; text-decoration: none;">Logout</a>
        </div>
    </nav>

    <!-- Main content -->
    <div style="max-width: 960px; margin: 20px auto; padding: 20px; background-color: #fff; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">
        <h1>Welcome, Admin!</h1>
        <h2>User Information</h2>

        <!-- Display user data in a table (adjust as needed) -->
        <table style="width: 100%; border-collapse: collapse; margin-top: 20px;">
            <thead>
                <tr>
                    <th style="padding: 10px; background-color: #333; color: #fff;">User ID</th>
                    <th style="padding: 10px; background-color: #333; color: #fff;">Username</th>
                    <th style="padding: 10px; background-color: #333; color: #fff;">Is User a Head?</th>
                    <th style="padding: 10px; background-color: #333; color: #fff;">Change Head Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td style="padding: 10px; border: 1px solid #ccc;">${user.userId}</td>
                        <td style="padding: 10px; border: 1px solid #ccc;">${user.username}</td>
                        <td style="padding: 10px; border: 1px solid #ccc;">${user.headUser ? 'Yes' : 'No'}</td>
                        <td style="padding: 10px; border: 1px solid #ccc;">
                            <!-- Hidden form to change headUser status -->
                            <form action="changeHeadStatus" method="post">
                                <input type="hidden" name="userId" value="${user.userId}">
                                <label>
                                    <input type="radio" name="newHeadStatus" value="1"> Yes
                                </label>
                                <label>
                                    <input type="radio" name="newHeadStatus" value="0"> No
                                </label>
                                <input type="submit" value="Change">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
