package com.soap;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {
    Statement stmt = null;
    ResultSet rs = null;

    public PostgreSQLDAO(){};

    private Connection connection;
    public PostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    public LinkedHashSet<Books> getBooksFields(List<String> searchArgs) {
        LinkedHashSet<Books> books = new LinkedHashSet<>();
        try (Statement stmt = connection.createStatement();) {
            for (String searchArg : searchArgs) {
                ResultSet rs = stmt.executeQuery("SELECT t.* FROM books t WHERE (t.*)::text LIKE '%"
                        + searchArg + "%'");
                while (rs.next()) {
                    int books_id = rs.getInt("id");
                    String title = rs.getString("title");
                    String author_first_name = rs.getString("author_first_name");
                    String author_last_name = rs.getString("author_last_name");
                    String genre = rs.getString("genre");
                    int publication_year = rs.getInt("publication_year");
                    Books book = new Books(books_id, title, author_first_name, author_last_name, genre, publication_year);
                    books.add(book);
                    System.out.println(book);
                }
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
        }
        return books;
    }
}
