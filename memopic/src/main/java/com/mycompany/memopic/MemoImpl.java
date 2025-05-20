package com.mycompany.memopic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of MemoActions interface to handle memo operations
 */
public class MemoImpl implements MemoActions {
    
    @Override
    public void addEntry(User user, String title, String content, String media_path) {
        try (Connection conn = DatabaseManager.getConnection()) {
            String sql = "INSERT INTO entries (user_id, title, content, media_path) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            stmt.setString(2, title);
            stmt.setString(3, content);
            stmt.setString(4, media_path);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewEntries(User user) {
        // This method is used by the console application
        // For the web app, we use getEntries() instead
        List<Post> entries = getEntries(user);
        for (Post entry : entries) {
            entry.display();
        }
    }
    
    // Additional method for the web application to return entries
    public List<Post> getEntries(User user) {
        List<Post> entries = new ArrayList<>();
        
        try (Connection conn = DatabaseManager.getConnection()) {
            String sql = "SELECT * FROM entries WHERE user_id = ? ORDER BY created_at DESC";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Post post = new Post(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getString("media_path"),
                    rs.getTimestamp("created_at")
                );
                entries.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return entries;
    }
}