<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    // Retrieve the existing session
    HttpSession Session = request.getSession(false);

    // Check if the session exists before invalidating it
    if (session != null) {
        // End the session
        session.invalidate();
    }

    // Redirect to a login page or any other page after logout
    response.sendRedirect("index.jsp");
%>
