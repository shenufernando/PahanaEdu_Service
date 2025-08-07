package admin.user;

import db.DBUtilsTest;
import db.PasswordHasher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class useroperations {

    // ✅ Register User
    public static boolean registerUser(user user) {
        System.out.println("registerUser() called with: " + user.getEmail());
        String sql = "INSERT INTO users (fullname, email, username, password, role) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBUtilsTest.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getFullName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, PasswordHasher.hashPassword(user.getPassword()));
            stmt.setString(5, user.getRole());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ✅ Login User
    public static user loginUser(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ?";

        try (Connection conn = DBUtilsTest.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashed = rs.getString("password");
                if (PasswordHasher.checkPassword(password, hashed)) {
                    return new user(
                            rs.getInt("id"),
                            rs.getString("fullname"),
                            rs.getString("email"),
                            rs.getString("username"),
                            null,
                            rs.getString("role")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ✅ Get All Users
    public static List<user> getAllUsers() {
        List<user> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = DBUtilsTest.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                userList.add(new user(
                        rs.getInt("id"),
                        rs.getString("fullname"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    // ✅ Get User by ID
    public static user getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";

        try (Connection conn = DBUtilsTest.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new user(
                        rs.getInt("id"),
                        rs.getString("fullname"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ✅ Update User
    public static boolean updateUser(int id, user user) {
        String sql = "UPDATE users SET fullname = ?, email = ?, username = ?, role = ? WHERE id = ?";

        try (Connection conn = DBUtilsTest.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getFullName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getRole());
            stmt.setInt(5, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ✅ Delete User
    public static boolean deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection conn = DBUtilsTest.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
