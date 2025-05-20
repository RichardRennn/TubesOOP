package com.mycompany.memopic;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SavePostServlet")
public class SavePostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SavePostServlet() {
    super(); // Ini mencegah error NoSuchMethodException
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        String title = request.getParameter("postTitle");
        String content = request.getParameter("postContent");
        
        // Create MemoActions implementation for saving entry
        MemoImpl memo = new MemoImpl();
        memo.addEntry(user, title, content, null); // No media path for now
        
        response.sendRedirect("ViewPostsServlet");
    }
}