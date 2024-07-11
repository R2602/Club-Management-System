<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ClubEase</title>
    <link rel="stylesheet" href="style.css">
    <style>
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.8); /* Changed to black with some transparency */
        }

        .modal-content {
            background-color: #1a1a1a; /* Darker background color for the modal content */
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
            max-width: 400px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.4); /* Added a subtle shadow */
            color: #fff; 
            text-align:center;
            
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
            cursor: pointer;
        }

        .close:hover,
        .close:focus {
            color: #fff; /* Text color for the close button */
            text-decoration: none;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #fff; /* Text color for labels */
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            color: #333; /* Text color for input */
            background-color: #fff; /* Background color for input */
        }

        .adminbutton {
            background-color:  #808080;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
    
        }

        .adminbutton:hover {
            background-color:#FF6347;
         
        }
    
        h1 {
            color: white; /* Dark blue color for the heading */
            margin-bottom: 10px;
        }
        button:hover {
    background: rgb(0, 0, 0);
    transition: 0.5s;
}
    </style>
</head>
<body>
    <div class="banner">
        <video autoplay loop muted plays-inline>
            <source src="img/video2.mp4" type="video/mp4">
        </video>
        <div class="navbar">
            <img class="logo" src="img/logo3.png">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="#" onclick="openModal()">Admin</a></li>
                <li><a href="#">Contact Us</a></li>
            </ul>
        </div>
        <div class="content">
            <h1>Club<span style="color: #FA5F55;">Ease</span></h1>
            <div>
                <a href="signinup.jsp"><button type="button" id="getStartedBtn">Get Started</button></a>
            </div>
        </div>
    </div>
    <div id="adminModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <h2 style="color: #FF6347; text-align: center;">Admin Login</h2>
            <form id="adminLoginForm" action = "AdminLoginServlet" method = "post">
                <label for="adminId" style="text-align: left;">Admin ID:</label>
                <input type="text" id="adminId" name="username" required>

                <label for="adminPassword" style="text-align: left;">Password:</label>
                <input type="password" id="adminPassword" name="password" required>
				<input class="adminbuttion" type = "submit" value = "login">
            </form>
        </div>
    </div>
    <script>
        function openModal() {
          document.getElementById("adminModal").style.display = "block";
        }

        function closeModal() {
          document.getElementById("adminModal").style.display = "none";
        }

        // Close the modal if the user clicks outside of it
        window.onclick = function(event) {
          if (event.target == document.getElementById("adminModal")) {
            closeModal();
          }
        };
    </script>
</body>
</html>
