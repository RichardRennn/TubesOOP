package com.mycompany.memopic;

import java.sql.*;

public class User extends Account {

    public User(int id, String username, String password, String email) {
        super(id, username, password, email);
    }

    @Override
    void showWelcomeMessage() {
        System.out.println("Selamat datang, " + username + "!");
    }

    public static boolean register(String username,String email, String password) {
        try (Connection conn = DatabaseManager.getConnection()) {
            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

        public static User login(String usernameOrEmail, String password) {
            try (Connection conn = DatabaseManager.getConnection()) {
                String sql = "SELECT * FROM users WHERE username = ? OR email = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, usernameOrEmail);
                stmt.setString(2, usernameOrEmail);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String storedPassword = rs.getString("password");
                    if (password.equals(storedPassword)) {  // cek password plain text
                        return new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            storedPassword,
                            rs.getString("email")
                        );
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

    public int getId() {
    return id;
        }
    public String getUsername() {
    return username;
    } 
}