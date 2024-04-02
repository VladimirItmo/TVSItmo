package com.soap;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;


    public LinkedHashSet<Books> getBooks() {
        LinkedHashSet<Books> books = new LinkedHashSet<>();
        try (Connection connection = ConnectionUtil.getConnection()){
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from books");
            while (rs.next()) {
                int books_id = rs.getInt("id");
                String title = rs.getString("title");
                String author_first_name = rs.getString("author_first_name");
                String author_last_name = rs.getString("author_last_name");
                String genre = rs.getString("genre");
                int publication_year = rs.getInt("publication_year");
                Books book = new Books(books_id, title, author_first_name, author_last_name, genre, publication_year);
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

    public LinkedHashSet<Books> getBooksFields(List<String> searchArgs) {
        LinkedHashSet<Books> books = new LinkedHashSet<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement stmt = connection.createStatement();
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
    public String createBooks(String title, String author_first_name, String author_last_name, String genre, int publication_year) {
        String status = "-1";

        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement stmt = connection.createStatement();
            System.out.println("INSERT INTO books(title, author_first_name, author_last_name, genre, publication_year) values ('" +
                    title + "', '" + author_first_name + "', '" + author_last_name + "', " + genre + ", '" + publication_year + "');");
            int rs = stmt.executeUpdate("INSERT INTO books(title, author_first_name, author_last_name, genre, publication_year) values ('" +
                    title+ "', '" + author_first_name + "', '" + author_last_name + "', '" + genre + "', '" + publication_year + "');");
            status = Integer.toString(rs);

        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
        return status;
    }

    public String deleteBooks(int books_id) {
        String status = "-1";

        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement stmt = connection.createStatement();
            int rs = stmt.executeUpdate("DELETE FROM books WHERE id='" + books_id + "';");
            status = Integer.toString(rs);
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
        return status;
    }

    public String updateBooks(int books_id, List<String> updateArgs) {
        String status = "-1";
        String updateFields = String.join(", ", updateArgs);

        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement stmt = connection.createStatement();
            int rs = stmt.executeUpdate("UPDATE books SET " + updateFields + " WHERE id=" + books_id + ";");
            status = Integer.toString(rs);
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
        return status;
    }
}