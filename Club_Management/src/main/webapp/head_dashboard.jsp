<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.ServletException, javax.servlet.http.HttpServlet, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.http.HttpSession" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.DAO.ClubDAO" %>
<%@ page import="com.DAO.ClubMemberDAO" %>
<%@ page import="com.DAO.UserDAO" %>
<%@ page import="com.entities.UserInfo" %>
<%@ page import="com.entities.UserClub" %>
<%@ page import="com.entities.Event" %>
<%@ page import="com.entities.Notice" %>
<%@ page import="com.entities.ClubMember" %>

<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Head Dashboard</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.16/dist/tailwind.min.css">
    
    <style>
        /* Styles for the modal (hidden by default) */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgb(0, 0, 0);
            background-color: rgba(0, 0, 0, 0.4);
            padding-top: 60px;
        }

        /* Styles for the modal content */
        .modal-content {
            background-color: #fefefe;
            margin: 5% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
        }

        /* Styles for the close button */
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }
        .club-card {
            
            padding: 1rem;
            margin-bottom: 1rem;
            /* Add more styles as needed */
        }
    </style>
</head>

<body class="bg-cover bg-center bg-no-repeat" style="background-image: url('img/head_bg3.png');">
        <jsp:include page="navbar.jsp" />

   <%
    // Retrieve the user_id from the session
    int userId = (int) session.getAttribute("userId");
    List<UserClub> clubs = ClubDAO.getClubsByUserId(userId);
%>

<%
    if (clubs != null && !clubs.isEmpty()) {
        for (UserClub club : clubs) {
            int clubId = club.getClubId();
%>

            <div class="club-card">
                <p class="text-4xl text-white text-center font-bold p-4"><%= club.getClubName() %></p>
                <p class="text-lg font-semibold text-white"> <%= club.getClubDescription() %></p>
                <p class="text-xl text-white text-center font-bold p-4"><strong>Year:</strong> <%= club.getClubYear() %></p>
            </div>
    

<div class="flex space-x-24 pl-40 h-2/4">
    <div class="p-2 rounded-lg shadow-md bg-white border border-blue-500 w-1/4 h-4/6">
        <h1 class="text-center font-bold text-2xl ">Events</h1>
        <% List<Event> events = ClubDAO.getEventsByClubId(clubId); %>
        <% if (events != null && !events.isEmpty()) { %>
            <div class="overflow-auto max-h-80">
                <% for (Event event : events) { %>
                    <div class="event-card mb-4 p-4 border border-gray-200 rounded-md">
                        <p><strong>Description:</strong> <%= event.getEventDescription() %></p>
                        <p><strong>Date:</strong> <%= event.getEventDate() %></p>
                    </div>
                <% } %>
            </div>
        <% } else { %>
            <p class="text-2xl font-bold p-8">No events available for this club.</p>
        <% } %>
		<div class="flex items-center justify-center">
		
        <button onclick="openModal()" class="bg-red-500 text-white px-4 py-2 rounded">Add Events</button>
        </div>
        <div id="myModal" class="modal">
<div class="modal-content">
        <span class="close" onclick="closeModal()">&times;</span>
        <!-- Your form for adding events goes here -->
        <form action="addEvent" method="post" class="p-4">
            <input type="hidden" name="clubId" value="<%=clubId %>">

            <div class="mb-4">
                <label for="eventName" class="block text-sm font-bold text-gray-700">Event Name</label>
                <input type="text" id="eventName" name="name" required class="w-full px-3 py-2 border rounded">
            </div>

            <div class="mb-4">
                <label for="description" class="block text-sm font-bold text-gray-700">Event Description</label>
                <textarea name="description" rows="5" cols="10" class="w-full px-3 py-2 border rounded"required></textarea>
            </div>

            <div class="mb-4">
                <label for="date" class="block text-sm font-bold text-gray-700">Event Date</label>
                <input type="date" name="date" class="w-full px-3 py-2 border rounded"required>
            </div>

            <input type="submit" value="Submit" class="bg-blue-500 text-white px-4 py-2 rounded">
        </form>
    </div>
        </div>
    </div>

    <div class="p-2 rounded-lg shadow-md bg-white border border-blue-500 w-1/4 h-4/6">
        <h1 class="text-center font-bold text-2xl">Notices</h1>
        <% List<Notice> notices = ClubDAO.getNoticeByClubId(clubId); %>
        <% if (notices != null && !notices.isEmpty()) { %>
            <div class="overflow-auto max-h-80">
                <% for (Notice notice : notices) { %>
                    <div class="notice-card mb-4 p-4 border border-gray-200 rounded-md">
                        <p><strong>Title:</strong> <%= notice.getNoticeName() %></p>
                        <p><strong>Description:</strong> <%= notice.getNoticeDescription() %></p>
                        <p><strong>Date:</strong> <%= notice.getNoticeDate() %></p>
                    </div>
                <% } %>
            </div>
        <% } else { %>
                <div class="p-8 text-2xl font-bold">
            <p>No notices available for this club.</p>
            </div>
        <% } %>
			<div class="flex items-center justify-center">

        <button onclick="openNoticeModal()" class="bg-red-500 text-white px-4 py-2 rounded">Add Notice</button>
        </div>
        <div id="noticeModal" class="modal">
<div class="modal-content">
        <span class="close" onclick="closeNoticeModal()">&times;</span>
        <!-- Your form for adding notices goes here -->
        <form action="addNotice" method="post" class="p-4">
            <input type="hidden" name="clubId" value="<%=clubId %>">

            <div class="mb-4">
                <label for="noticeName" class="block text-sm font-bold text-gray-700">Notice Name</label>
                <input type="text" id="noticeName" name="name" required class="w-full px-3 py-2 border rounded">
            </div>

            <div class="mb-4">
                <label for="date" class="block text-sm font-bold text-gray-700">Notice Date</label>
                <input type="date" name="date" class="w-full px-3 py-2 border rounded"required>
            </div>

            <div class="mb-4">
                <label for="description" class="block text-sm font-bold text-gray-700">Notice Description</label>
                <textarea name="description" rows="5" cols="10" class="w-full px-3 py-2 border rounded"required></textarea>
            </div>

            <input type="submit" value="Submit" class="bg-blue-500 text-white px-4 py-2 rounded">
        </form>
    </div>
        </div>
        
 
        
    </div>
    
     <div class="p-4 rounded-lg shadow-md bg-white border border-blue-500 w-1/4 h-3/4">
           
		<h1 class="text-center font-bold text-2xl">Club Members</h1>
		<% List<ClubMember> clubMembers = ClubMemberDAO.getClubMembersByClubId(clubId); %>
        <% if (events != null && !events.isEmpty()) { %>
            <div class="overflow-auto max-h-80">
                <% for (ClubMember clubMember : clubMembers) { %>
                    <div class="event-card mb-4 p-4 border border-gray-200 rounded-md">
                        <p><strong>Name:</strong> <%= clubMember.getMemberName() %></p>
                        <p><strong>Email:</strong> <%= clubMember.getEmail() %></p>
                    </div>
                <% } %>
            </div>
        <% } else { %>
        <div class="p-12 text-2xl font-bold">
            <p>No Members available for this club.</p>
        </div>
        
        <% } %>
    </div>
    
</div>


<%
            }
        } else {
    %>

    

<div class="max-w-md mx-auto  rounded-md border shadow-xl">
    <!-- Card Header -->
    <div class=" text-white text-4xl text-center py-4 font-normal hover:text-red-500">
        Create Club
    </div>

    <!-- Card Content (Form) -->
    <form action="createClub" method="post" class="p-4 ">
        <input type="hidden" name="userId" value="<%=userId %>">

        <div class="mb-4">
            <label for="name" class="block text-lg font-bold text-white">Club Name</label>
			<input type="text" name="name" required placeholder="Give Name to your Club..." class="border border-red-400 focus:placeholder-red-400 placeholder-gray-500 w-full px-3 py-2 border rounded" style="::placeholder { color: red; }">
        </div>

        <div class="mb-4">
            <label for="description" class="block text-lg font-bold text-white">Description</label>
            <textarea name="description" rows="5" cols="10" placeholder = "Write the description of your club... " class="focus:placeholder-red-400 border border-red-400 placeholder-gray-500 w-full px-3 py-2 border text-black rounded" required></textarea>
        </div>

        <div class="mb-4">
            <label for="clubYear" class="block text-lg font-bold text-white">Club Year</label>
            <input type="number" id="clubYear" name="year" min="1900" max="2100" pattern="[0-9]{4}" placeholder="YYYY" required
                class="w-full px-3 py-2 border rounded placeholder-gray-500 focus:placeholder-red-400 border border-red-700">
        </div>

			<div class="flex items-center justify-center">
                <input type="submit" value="Create Club" class="bg-red-500 text-white px-4 py-2 rounded">
            </div>   
        </form>

</div>
    


<%
        }
    %>


    <script>
    	function openModal() {
        	document.getElementById('myModal').style.display = 'block';
    	}

    	function closeModal() {
        	document.getElementById('myModal').style.display = 'none';
    	}
    
    
        function openNoticeModal() {
            document.getElementById('noticeModal').style.display = 'block';
        }

        function closeNoticeModal() {
            document.getElementById('noticeModal').style.display = 'none';
        }

        function openCreateClubModal() {
            document.getElementById('createClubModal').style.display = 'block';
        }

        function closeCreateClubModal() {
            document.getElementById('createClubModal').style.display = 'none';
        }
    </script>
    
    
</body>
</html>
