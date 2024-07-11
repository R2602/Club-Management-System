<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="javax.servlet.ServletException, javax.servlet.http.HttpServlet, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.http.HttpSession" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.16/dist/tailwind.min.css">

</head>
<body>
<nav class="bg-gray-800">
     

  <div class="mx-auto max-w-7xl px-2 sm:px-6 lg:px-8">
    <div class="relative flex h-16 items-center justify-between">
       <h1 class="text-white text-3xl font-bold">Club</h1><h1 class="text-3xl font-bold text-red-600">Ease</h1>
      <div class="flex flex-1 items-center justify-center sm:items-stretch sm:justify-start">
        
        
      </div>
      <div class="absolute inset-y-0 right-0 flex items-center pr-2 sm:static sm:inset-auto sm:ml-6 sm:pr-0">
      

        <div class="flex items-center space-x-4">
                            
                            <div class="flex-1 min-w-0 text-white text-sm">
                                <p class="text-sm font-medium text-white">
        						<p>Username: <c:out value="${sessionScope.username}" /></p>
                                
                                <p class="text-sm text-white">
        						<p>Email: <c:out value="${sessionScope.email}" /></p>
                                </p>
                            </div>
                        </div>
      </div>
      
       <div class="flex space-x-4 pl-4 ">
            <a href="club_listing.jsp" class="bg-red-500 text-white rounded-md px-3 py-2 text-sm font-medium" aria-current="page">Home</a>
        </div>
      <div class="hidden sm:ml-6 sm:block">
          <div class="flex space-x-4">
            <a href="logout.jsp" class="bg-red-500 text-white rounded-md px-3 py-2 text-sm font-medium" aria-current="page">Logout</a>
          </div>
        </div>
        
       
        
    </div>
  </div>

<a href = userclublisting.jsp>User Clubs</a>
</nav>


</body>
</html>