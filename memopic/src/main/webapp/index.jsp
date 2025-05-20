<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.mycompany.memopic.Post" %>
<!DOCTYPE html>
<html lang="id">
<head>
  <meta charset="UTF-8" />
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Home</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
  <div id="posts-list">
    <!-- Daftar postingan -->
    <%
      List<Post> posts = (List<Post>) request.getAttribute("posts");
      if (posts != null && !posts.isEmpty()) {
        for (Post p : posts) {
    %>
      <div class="post-card">
        <h3><%= p.getTitle() %></h3>
        <p><%= p.getContent() %></p>
        <span class="date"><%= p.getCreatedAt() %></span>
        <hr/>
      </div>
    <%
        }
      } else {
    %>
      <p>Tidak ada postingan.</p>
    <%
      }
    %>
  </div>

  <div class="index-logo">
    <i class="fas fa-book-open"></i>
  </div>
  <div class="index-container">
    <div class="index-header">
      <h2>For You</h2>
    </div>
    <div id="home-container" class="home-container">
      <div class="search">
        <input type="text" id="searchbar" placeholder="Search Posts">
        <button class="searchbtn" id="searchbtn">Search</button>
      </div>
    </div>
    <div class="navbar">
      <a href="index.jsp"><i class="fas fa-home"></i></a>
      <a href="post.jsp"><i class="fas fa-plus"></i></a>
      <a href="#"><i class="fas fa-user"></i></a>
    </div>
  </div>

  <button class="new-entry-button" id="quick-new-entry" onclick="location.href='post.jsp'">
    <i class="fas fa-pen"></i>
  </button>
</body>
</html>
