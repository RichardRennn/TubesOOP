<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login - Memopic</title>
  <link rel="stylesheet" href="css/style.css" />
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
    <div class="auth-form" id="login-form">
      <div class="form-title">Login to Memopic</div>

      <form action="login" method="post">
        <div class="form-group">
          <label for="login-username">Username or Email</label>
          <input type="text" name="username" id="login-username" placeholder="Enter username or Email" required>
        </div>
        <div class="form-group">
          <label for="login-password">Password</label>
          <input type="password" name="password" id="login-password" placeholder="Enter password" required>
        </div>
        <input type="submit" value="Login" class="btn-submit">
        
        <% if (request.getAttribute("error") != null) { %>
          <p style="color: red;"><%= request.getAttribute("error") %></p>
        <% } %>
      </form>

      <p class="form-switch">
        Don't have an account? <a href="register.jsp">Sign Up</a>
      </p>
    </div>
  </div>
</div>
</body>
</html>
