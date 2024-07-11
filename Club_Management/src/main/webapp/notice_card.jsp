<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<style>
/* Custom scrollbar styling for the scroll panel and thumb */
.custom-scrollbar::-webkit-scrollbar-track {
    background-color: #E5E7EB; /* Scroll panel background color */
    border-radius: 8px; /* Rounded corners */
}

.custom-scrollbar::-webkit-scrollbar-thumb {
    background-color: #6B7280; /* Scrollbar thumb color */
    border-radius: 4px; /* Rounded corners */
    border: 2px dotted #4B5563; /* Dotted border style */
    animation: moveDots 2s linear infinite; /* Adding a moving dots animation */
}

@keyframes moveDots {
    0% {
        background-position: 0 0;
    }
    100% {
        background-position: 40px 0; /* Move the dots horizontally */
    }
}

.custom-scrollbar::-webkit-scrollbar-thumb:hover {
    background-color: #4B5563; /* Hover color */
}
</style>
<body>
    <div class="container mx-auto p-2">
        <div class="container mx-auto p-4 flex items-center justify-between">
            <h1 class="text-3xl font-bold mb-4 text-black">Notices</h1>
        </div>
        <div class="flex overflow-x-auto" style="scroll-behavior: smooth;">
            <c:forEach var="notice" items="${sessionScope.notices}">
                <div class="w-64 h-64 flex-shrink-0 dark:bg-gray-800 bg-white border-t-4 border-purple-600 border border-gray-400 mb-6 mx-2 py-5 px-4 custom-scrollbar">
                    <h2 class="text-black text-xl font-bold mb-3">${notice.noticeName}</h2>
                    <h4 class="text-gray-500 text-4sm">${notice.noticeDate}</h4>
                    <p class="text-black font-light text-lg">${notice.noticeDescription}</p>
                    
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
