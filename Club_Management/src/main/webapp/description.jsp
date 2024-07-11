<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Club Description</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body>

<div class="bg-white p-4 border-t-4 border-purple-500 rounded-lg shadow">
    <c:choose>
        <c:when test="${empty sessionScope.club}">
            <p class="text-center text-red-500 text-xl font-semibold">No club details available.</p>
        </c:when>
        <c:otherwise>
            <p class="text-xl font-bold mb-2 text-black">${sessionScope.club.clubName}</p>
            <p class="text-lg font-light mb-2 text-black">${sessionScope.club.description}</p>
            <p class="text-lg font-semibold mb-2 text-black">Founded Year: ${sessionScope.club.foundedYear}</p>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
