<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
    <style>
        .popup-container {
            display: none; /* Initially hidden */
            position: fixed;
            top: 0;
            left: 0;
            width:55%;
            background-color: rgba(0, 0, 0, 0.5);
            justify-content: center;
            align-items: center;
        }

        /* Styles for the popup content */
        .popup-content {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
            width: 80%; /* Reduce width */
            margin: auto; /* Center the form horizontally */
            position: relative;
        }

        /* Style for the close button text */
        .close-button-text {
            position: absolute;
            top: 10px;
            right: 10px;
            cursor: pointer;
            color: #333; /* Set the color to match your design */
        }
    </style>
</head>
<body>
    <div class="container mx-auto p-4">
        <h1 class="text-3xl font-bold mb-4">Feedback</h1>
        <button id="showPopupButton" class="w-8 h-8 rounded-full bg-gray-800 dark:bg-gray-100 dark:text-gray-800 text-white flex items-center justify-center focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-black" aria-label="edit note" role="button">
            <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-pencil" width="20" height="20" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round">
                <path stroke="none" d="M0 0h24v24H0z"></path>
                <path d="M4 20h4l10.5 -10.5a1.5 1.5 0 0 0 -4 -4l-10.5 10.5v4"></path>
                <line x1="13.5" y1="6.5" x2="17.5" y2="10.5"></line>
            </svg>
        </button>
    </div>
    
    <!-- Popup container -->
    <div class="popup-container" id="popupContainer">
        <div class="popup-content">
            <span class="close-button-text" id="closeButton">Close</span>
<iframe src="https://docs.google.com/forms/d/e/1FAIpQLSf_n20D1FDTKnVdXpQPDwNL4JdR13yqHSu1ZAXNXtfYCeRvig/viewform?embedded=true" width="600" height="700">Loading…</iframe>        </div>
    </div>

    <div class="flex overflow-x-auto">
        <c:forEach var="feedback" items="${sessionScope.feedbacks}">
            <div class="w-64 h-64 flex-shrink-0 dark:bg-gray-800 bg-white dark:border-gray-700 rounded-lg border border-gray-400 mb-6 mx-2 py-5 px-4">
                <h2 class="text-gray-800 dark:text-gray-100 font-bold mb-3">${feedback.name}</h2>
                <h4 class="text-gray-800 dark:text-gray-100 text-sm">${feedback.feedbackText}</h4>
            </div>
        </c:forEach>
    </div>

    <script>
        // JavaScript to toggle the popup
        document.getElementById("showPopupButton").addEventListener("click", function () {
            var popupContainer = document.getElementById("popupContainer");
            popupContainer.style.display = "block";
        });

        // Close the popup when clicking the close button text
        document.getElementById("closeButton").addEventListener("click", function () {
            var popupContainer = document.getElementById("popupContainer");
            popupContainer.style.display = "none";
        });
        
    </script>
</body>
</html>
