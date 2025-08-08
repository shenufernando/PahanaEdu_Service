package admin.items;

import db.DBUtilsTest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class itemOperation {

    public boolean createItem(Item item) {
        String sql = "INSERT INTO books (books_title, books_category, price, avalible_quantity, book_image) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBUtilsTest.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, item.getBookTitle());
            stmt.setString(2, item.getBookCategory());
            stmt.setDouble(3, item.getPrice());
            stmt.setInt(4, item.getAvailableQuantity());
            stmt.setString(5, item.getBookImage());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = DBUtilsTest.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Item item = new Item(
                    rs.getInt("books_id"),
                    rs.getString("books_title"),
                    rs.getString("books_category"),
                    rs.getDouble("price"),
                    rs.getInt("avalible_quantity"),
                    rs.getString("book_image")
                );
                items.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public boolean updateItem(Item item) {
        String sql = "UPDATE books SET books_title = ?, books_category = ?, price = ?, avalible_quantity = ?, book_image = ? WHERE books_id = ?";

        try (Connection conn = DBUtilsTest.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, item.getBookTitle());
            stmt.setString(2, item.getBookCategory());
            stmt.setDouble(3, item.getPrice());
            stmt.setInt(4, item.getAvailableQuantity());
            stmt.setString(5, item.getBookImage());
            stmt.setInt(6, item.getBookId());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteItem(int bookId) {
        String sql = "DELETE FROM books WHERE books_id = ?";

        try (Connection conn = DBUtilsTest.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, bookId);
            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Item getItemById(int bookId) {
        String sql = "SELECT * FROM books WHERE books_id = ?";
        try (Connection conn = DBUtilsTest.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, bookId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Item(
                        rs.getInt("books_id"),
                        rs.getString("books_title"),
                        rs.getString("books_category"),
                        rs.getDouble("price"),
                        rs.getInt("avalible_quantity"),
                        rs.getString("book_image")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Item getItemByCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean addItem(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Item getitemByCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean deleteItem(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
