<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container mx-auto p-4 flex items-center justify-between">
    <h1 class="text-3xl font-bold mb-4 text-black">Events</h1>
</div>
<div class=" bg-white w-full max-w-md p-4 border-t-4 border-purple-600 border border-gray-200 rounded-lg shadow">

    <div class=" max-h-60"> <!-- Adjust the max height as needed -->
        <ul role="list" class="divide-y divide-gray-200 dark:divide-gray-700">
            <c:choose>
                <c:when test="${not empty sessionScope.events}">
                    <c:forEach var="event" items="${sessionScope.events}">
                        <li class="py-3 sm:py-4">
                            <div class="flex items-center space-x-4">
                                <div class="flex-1 min-w-0">
                                    <p class="text-sm font-medium text-gray-900 truncate dark:text-white">
                                        Event Date: ${event.eventDate}
                                    </p>
                                    <p class="text-sm text-gray-500">
                                        ${event.eventDescription}
                                    </p>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <li class="py-3 sm:py-4">
                        <div class="flex-1 min-w-0">
                            <p class="text-sm text-gray-500 truncate dark:text-gray-400">
                                No events found.
                            </p>
                        </div>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>
