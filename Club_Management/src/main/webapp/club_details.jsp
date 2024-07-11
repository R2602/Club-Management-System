<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Club Details</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="flex flex-col justify-center items-center bg-cover bg-center bg-no-repeat" style="background-image: url('img/club.jpg');">
        <div class ="w-full">
        <jsp:include page="navbar_u.jsp" />
		</div>
<div class=" p-4 rounded-lg shadow-md mb-4">
    <h1 class="text-5xl text-white font-bold mb-2">${sessionScope.club.clubName}</h1>
</div>
<div class=" text-black-300 p-4 rounded-lg shadow-md ">
        <jsp:include page="description.jsp" />
    </div>
<div class="grid grid-cols-4 sm:grid-cols-2 md:grid-cols-4 gap-6 p-4">
   
    <div class=" p-4 rounded-lg shadow-md bg-white w-full h-full hover:bg-yellow-600 transition duration-300 ease-in-out">
        <jsp:include page="members_card.jsp" />
    </div>
    <div class=" p-4 rounded-lg shadow-md bg-white w-full h-full hover:bg-yellow-500 transition duration-300 ease-in-out">
        <jsp:include page="event_card.jsp" />
    </div>
    
    <div class=" p-4 rounded-lg shadow-md bg-white w-full h-full hover:bg-yellow-600 transition duration-300 ease-in-out">
        <jsp:include page="notice_card.jsp" />
    </div>
    <div class="p-4 rounded-lg shadow-md bg-white w-full h-full hover:bg-yellow-500 transition duration-300 ease-in-out">
        <jsp:include page="feedback.jsp" />
    </div>
</div>

<div class="flex justify-center mt-4">
    <c:choose>
        <c:when test="${empty sessionScope.club}">
            <p class="text-center text-red-500 text-xl font-semibold">No club details available.</p>
        </c:when>
        <c:otherwise>
           
            <div class= "pb-8">
    <button class="text-2xl font-bold bg-blue-500 text-white px-4 py-2 rounded focus:outline-none">
                <a href="JoinClubServlet?clubId=${sessionScope.club.clubId}&userId=${userId}" class="bg-blue-500 hover:bg-blue-600 text-white font-semibold py-2 px-4 rounded transition-all duration-300 mt-6">Join Club</a>
    </button>
</div>
            
                     
        </c:otherwise>
    </c:choose>
</div>
  
</body>
</html>
