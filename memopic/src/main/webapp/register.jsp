<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register - Memopic</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <div class="header">
      <div class="logo">
          <i class="fas fa-book-open"></i>
          <h1>Memopic</h1>
      </div>
  </div>
  <div id="auth-container" class="auth-container">
      <div class="auth-form" id="register-form">
        <div class="form-title">Sign Up to Memopic</div>
        
        <form action="register" method="post">
          <div class="form-group">
              <label for="register-username">Username</label>
              <input type="text" id="register-username" name="username" placeholder="Enter your username" required>
          </div>
          <div class="form-group">
              <label for="register-email">Email</label>
              <input type="email" id="register-email" name="email" placeholder="Enter your Email" required>
          </div>
          <div class="form-group">
              <label for="register-password">Password</label>
              <input type="password" id="register-password" name="password" placeholder="Enter your password" required>
          </div>
          <input type="submit" value="Sign Up" class="btn-submit">
          
          <% if (request.getAttribute("error") != null) { %>
            <p style="color: red;"><%= request.getAttribute("error") %></p>
          <% } %>
        </form>
        
        <p class="form-switch">
          Already have an account? <a href="login.jsp">Login</a>
        </p>
      </div>
  </div>
</div>
</body>
</html>