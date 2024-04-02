package com.soap;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PostgreSQLDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    public List<Books> getBooks() {
        List<Books> books = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from books");
            while (rs.next()) {
                String title = rs.getString("title");
                String author_first_name = rs.getString("author_first_name");
                String author_last_name = rs.getString("author_last_name");
                String genre = rs.getString("genre");
                int publication_year = rs.getInt("publication_year");
                Books book = new Books(title, author_first_name, author_last_name, genre, publication_year);
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return books;
    }
}