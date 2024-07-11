<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script
      src="https://kit.fontawesome.com/64d58efce2.js"
      crossorigin="anonymous"
    ></script>
    <link rel="stylesheet" href="style1.css" />
    <title>Sign in & Sign up Form</title>
   
  </head>
  <body>
  
    <div class="container">
      <div class="forms-container">
        <div class="signin-signup">
          <form action="login" class="sign-in-form" method = "post">
            <h2 class="title" style="color: white;">Sign in</h2>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="Username" name = "username" />
            </div>
            <div class="input-field">
              <i class="fas fa-lock"></i>
              <input type="password" placeholder="Password" name = "password" />
            </div>
            <input type="submit" value="Login" class="btn solid" />
          </form>
          <div style="display: flex; align-items: center;">
   				  <p style="color: white; margin-right: 10px;">New member?</p>
                  <button style=" margin-right: 120px;" class="btn transparent" id="sign-up-btn">Sign up</button>
    
			</div>
          
          <form action="register" class="sign-up-form" method = "post">
            <h2 class="title" style="color: white;">Sign up</h2>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="Username" name = "username"/>
            </div>
            <div class="input-field">
              <i class="fas fa-envelope"></i>
              <input type="email" placeholder="Email" name = "email"/>
            </div>
              <div class="input-field">
        <i class="fas fa-clipboard"></i> 
              <input type="text" placeholder="Department Name" />
            </div>
              <div class="input-field">
             <i class="fas fa-book"></i>
              <input type="text" placeholder="Course" />
            </div>
            <div class="input-field">
              <i class="fas fa-lock"></i>
              <input type="password" placeholder="Password" name = "password"/>
            </div>
            <input type="submit" class="btn" value="Sign up" />
              <p style="color: white; margin-right: 10px;">Already a member?</p>
              <button style="margin-right:150px;" class="btn transparent" id="sign-in-btn">
              Sign in
            </button>
          </form>
          </div>
          </div>
        </div>

      <div class="panels-container">
        <div class="panel left-panel">
          <div class="content">
            <h1 style="font-size: 45px; color: black;">Welcome to ClubEase</h1><br>
            <h4 style="margin-top:15px font-family: 'Franklin Gothic Medium';">
            Unlock the doors to a vibrant community of like-minded individuals. 
            At ClubEase, we believe in fostering connections that go beyond the ordinary. 
            Our aim is to provide hub for creativity, innovation, and shared passions.
            </h4>
          
          </div>
          <img src="img/12.jpg" class="image" alt="" />
        </div>
        <div class="panel right-panel">
          <div class="content">
            <h1 style="color: black;">Embark on a journey of discovery and collaboration</h1>
            <h4>
             Get ready to explore exciting events, connect with like-minded individuals, and contribute to a dynamic and inclusive club atmosphere. 
             Register now to be a part of something extraordinary!
            </h4>
        
          </div>
          <img src="img/12.jpg" class="image" alt="" />
        </div>
      </div>
    </div>

    <script >
    const sign_in_btn = document.querySelector("#sign-upb -btn");
    const sign_up_btn = document.querySelector("#sign-up-btn");
    const container = document.querySelector(".container");

    sign_up_btn.addEventListener("click", () => {
      container.classList.add("sign-up-mode");
    });

    sign_in_btn.addEventListener("click", () => {
      container.classList.remove("sign-in-mode");
    });
    </script>
  </body>
</html>