<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.ServletException, javax.servlet.http.HttpServlet, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.http.HttpSession" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Club Listing</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.16/dist/tailwind.min.css">
    <style>
        /* Custom CSS for card layout */
        
         .read-more-content {
        display: none;
    }

    .read-more-toggle {
        color: blue;
        cursor: pointer;
    }
        .club-card {
            width: 80%;
            margin: 4%;
            display: inline-block;
            border-top: 10px solid #6B46C1; /* Purple border */
            border-radius: 8px 8px 0 0; /* Half-rounded border */
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.5);
            padding: 1.5rem;
            background-color: #FFF; /* White card background */
            transition: transform 0.2s ease-in-out, box-shadow 0.2s ease-in-out;
        }

        .club-card:hover {
            transform: scale(1.03);
            box-shadow: 0 6px 8px rgba(0, 0, 0, 0.2);
        }

        .text-purple {
            color: #6B46C1; /* Purple text color */
        }

        .text-yellow {
            color: #FFD700; /* Yellow text color */
        }

        .bg-purple {
            background-color: #6B46C1; /* Purple background color */
        }
    </style>
</head>
<body class="bg-gray-100 font-sans"style="background-image: url('img/club.jpg');">
<div class="w-full">
<jsp:include page = "navbar_l.jsp" />
</div>
    <div class="container mx-auto py-8">
        <h1 class="text-4xl font-bold text-center pb-8 text-white">Club Listing</h1>
  <div class="fixed bottom-0 right-0 p-4">
   
</div>

        <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-3 gap-4 font-serif">
            <c:if test="${not empty clubs}">
                <c:forEach var="club" items="${clubs}">
                    <div class="club-card bg-white text-black">
                        <a href="ClubDetailsServlet?clubId=${club.clubId}" class=" mt-4 inline-block">
                        <h2 class="text-xl font-semibold mb-2">${club.clubName}</h2>
						<p class="text-black-300 mb-4" id="clubDescription">
    					Description: 
    					<span class="read-more-content">${club.description}</span>
    					<span class="read-more-toggle" onclick="toggleReadMore('clubDescription')">Read more</span>
						</p>

                        <p class="text-black-300">Founded Year: ${club.foundedYear}</p>
                        <p class="text-black-300">Join Club</p>
                        </a>
                    </div>
                </c:forEach>
            </c:if>

            <c:if test="${empty clubs}">
                <p class="text-2xl font-semibold text-center mt-4 text-purple">No clubs found.</p>
            </c:if>
        </div>
    </div>
	
<script>
    function toggleReadMore(elementId) {
        const description = document.getElementById(elementId).querySelector('.read-more-content');
        const toggleButton = document.getElementById(elementId).querySelector('.read-more-toggle');

        if (description.style.display === 'none' || description.style.display === '') {
            description.style.display = 'inline';
            toggleButton.innerText = 'Read less';
        } else {
            description.style.display = 'none';
            toggleButton.innerText = 'Read more';
        }
    }
</script>
	</body>
</html>
