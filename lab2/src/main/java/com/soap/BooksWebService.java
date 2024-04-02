package com.soap;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.WebParam;
import java.util.ArrayList;

@WebService(serviceName = "BooksServiceCRUD")
public class BooksWebService {
    @WebMethod(operationName = "getBooks")
    public List<Books> getBooks() {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<Books> books = dao.getBooks();
        return books;
    }

    @WebMethod(operationName = "createBooks")
    public String createBooks(@WebParam(name = "booksTitle") String title,
                               @WebParam(name = "booksAuthorfirst") String author_first_name,
                               @WebParam(name = "booksAuthorlast") String author_last_name,
                               @WebParam(name = "booksGenre") String genre,
                               @WebParam(name = "bookPush") int publication_year) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.createBooks(title, author_first_name, author_last_name, genre, publication_year);
    }

    @WebMethod(operationName = "deleteBooks")
    public String deleteBooks(@WebParam(name = "books_id") int books_id) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.deleteBooks(books_id);
    }

    @WebMethod(operationName = "updateBooks")
    public String updateBooks(@WebParam(name = "books_id") int books_id,
                               @WebParam(name = "booksTitle") String title,
                               @WebParam(name = "booksAuthorfirst") String author_first_name,
                               @WebParam(name = "booksAuthorlast") String author_last_name,
                               @WebParam(name = "booksGenre") String genre,
                               @WebParam(name = "bookPush") int publication_year) {

        List<String> updateArgs = new ArrayList<>();

        if (title != null && !title.trim().isEmpty()) updateArgs.add("title = '" + title + "'");
        if (author_first_name != null && !author_first_name.trim().isEmpty())
            updateArgs.add("author_first_name = '" + author_first_name + "'");
            if (author_last_name != null && !author_last_name.trim().isEmpty())
                updateArgs.add("author_last_name = '" + author_last_name + "'");
        if (genre != null && !genre.trim().isEmpty()) updateArgs.add("genre = '" + genre + "'");
        if (publication_year != 0) updateArgs.add("publication_year = '" + publication_year + "'");


        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.updateBooks(books_id, updateArgs);
    }
}
