<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mx-auto p-4 flex items-center justify-between">
    <h1 class="text-3xl font-bold mb-4 text-black">Club Members</h1>
</div>
<div class="w-full max-w-md p-4 bg-white border-t-4 border-purple-600 border border-gray-200 rounded-lg shadow sm:p-8 dark:bg-gray-800 dark:border-gray-700">
 
    <div class="overflow-y-auto max-h-60"> <!-- Adjust the max height as needed -->
        <ul role="list" class="divide-y divide-gray-200 dark:divide-gray-700">
            <c:if test="${not empty sessionScope.clubMembers}">
                <c:forEach var="clubMember" items="${sessionScope.clubMembers}">
                    <li class="py-3 sm:py-4">
                        <div class="flex items-center space-x-4">
                            <div class="flex-shrink-0">
                                <div class="relative inline-flex items-center justify-center w-10 h-10 overflow-hidden bg-gray-100 rounded-full dark:bg-gray-600">
                                    <span class="font-medium text-gray-600 dark:text-gray-300" id="userInitials${clubMember.userId}"></span>
                                </div>
                            </div>
                            <div class="flex-1 min-w-0">
                                <p class="text-lg font-medium text-gray-900 truncate dark:text-white">
                                    ${clubMember.memberName}
                                </p>
                                <p class="text-sm text-gray-500 truncate dark:text-gray-400">
                                    ${clubMember.email}
                                </p>
                            </div>
                        </div>
                        <script>
                            // JavaScript code to set user initials
                            const userName${clubMember.userId} = "${clubMember.memberName}";
                            const initials${clubMember.userId} = userName${clubMember.userId}
                                .split(' ')
                                .map(part => part.charAt(0).toUpperCase())
                                .join('');
                            document.getElementById('userInitials${clubMember.userId}').textContent = initials${clubMember.userId};
                        </script>
                    </li>
                </c:forEach>
            </c:if>
            <c:if test="${empty sessionScope.clubMembers}">
                <li class="py-3 sm:py-4">
                    <div class="flex-1 min-w-0">
                        <p class="text-sm text-gray-500 truncate dark:text-gray-400">
                            No club members found.
                        </p>
                    </div>
                </li>
            </c:if>
        </ul>
    </div>
</div>
