<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>New Memo</title>
  <link rel="stylesheet" href="css/style.css" />
</head>
<body>
  <div class="post-container">
    <div class="post-header">
      <h2 id="formTitle">New Memo</h2>
    </div>
    <div class="post-form">
      <form action="SavePostServlet" method="post">
        <input type="text" name="postTitle" placeholder="Judul" required /><br />
        <textarea name="postContent" maxlength="400" placeholder="Isi" required></textarea><br />
        <div class="buttonGroup">
          <button type="submit" id="savePostBtn">Simpan</button>
          <button type="button" id="backBtn" onclick="window.location.href='index.jsp'">Kembali</button>
        </div>
      </form>
    </div>
  </div>

  <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  <script src="js/script.js"></script>
</body>
</html>
