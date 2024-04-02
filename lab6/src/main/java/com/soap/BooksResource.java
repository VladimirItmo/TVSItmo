package com.soap;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.soap.error.*;

@Path("/books")
@Produces({MediaType.APPLICATION_JSON})

public class BooksResource {

    @GET
    public LinkedHashSet<Books> getBooks(@QueryParam("query") String query, @QueryParam("searchParam") final List<String> searchArgs) throws EmptyFieldException {
        if (query != null) {
            // Обработать случай, когда присутствует параметр запроса
            System.out.println("Вывод всех людей" + query);
            return new PostgreSQLDAO().getBooks();
        } else if (searchArgs != null) {
            // Обработать случай, когда присутствует параметр searchParam
            System.out.println("Search parameters: " + searchArgs);
            return new PostgreSQLDAO().getBooksFields(searchArgs);
        } else {
            // Обработать случай, когда нет ни query, ни searchParam
            throw new EmptyFieldException("Должен быть указан параметр 'query' или 'searchParam'.");
        }
    }


    @POST
    public String createBooks(
            @QueryParam("booksTitle") String title,
            @QueryParam("booksAuthor_first_name") String author_first_name,
            @QueryParam("booksAuthor_last_name") String author_last_name,
            @QueryParam("booksGenre") String genre,
            @QueryParam("booksYear") String publication_year)
            throws EmptyFieldException, CastIntException {

        String status = "-1";

        if (title != null && !title.trim().isEmpty() &&
                author_first_name != null && !author_first_name.trim().isEmpty() &&
                author_last_name != null && !author_last_name.trim().isEmpty() &&
                genre != null && !genre.trim().isEmpty()
                && publication_year != null && !publication_year.trim().isEmpty()) {

            try {
                Integer.parseInt(publication_year.trim());

                status = new PostgreSQLDAO().createBooks(title, author_first_name, author_last_name,  genre, Integer.parseInt(publication_year));

            } catch (NumberFormatException ex) {
                throw new CastIntException("Произошла ошибка при попытке преобразовать 'publication_year' в целые числа.");
            }

        } else {
            throw EmptyFieldException.DEFAULT_INSTANCE;
        }

        return status;

    }

    @DELETE
    public String deleteBooks(@QueryParam("id") String books_id)
            throws EmptyFieldException, RowNotExistsException, CastIntException {
        String status;
        if (books_id != null && !books_id.trim().isEmpty()) {
            try {
                status = new PostgreSQLDAO().deleteBooks(Integer.parseInt(books_id));
                if (status.equals("0")) {
                    throw RowNotExistsException.DEFAULT_INSTANCE;
                }
            } catch (NumberFormatException ex) {
                throw new CastIntException("Произошла ошибка при попытке преобразовать 'ID' в целое число.");
            }
        } else {
            throw EmptyFieldException.DEFAULT_INSTANCE;
        }
        return status;
    }


    @PUT
    public String updateBooks(
            @QueryParam("id") String books_id,
            @QueryParam("booksTitle") String title,
            @QueryParam("booksAuthor_first_name") String author_first_name,
            @QueryParam("booksAuthor_last_name") String author_last_name,
            @QueryParam("booksGenre") String genre,
            @QueryParam("booksYear") String publication_year)
            throws EmptyFieldException, CastIntException, RowNotExistsException {

        String status;
        List<String> updateArgs = new ArrayList<>();

        if (books_id != null && !books_id.trim().isEmpty()) {
            if ((title != null && !title.trim().isEmpty()) ||
                    (author_first_name != null && !author_first_name.trim().isEmpty()) ||
                    (author_last_name != null && !author_last_name.trim().isEmpty()) ||
                    (genre != null && !genre.trim().isEmpty()) ||
                    (publication_year != null && !publication_year.trim().isEmpty())) {

                try {
                    Integer.parseInt(books_id.trim());
                    if (title != null && !title.trim().isEmpty()) updateArgs.add("title = '" + title + "'");
                    if (author_first_name != null && !author_first_name.trim().isEmpty()) updateArgs.add("author_first_name = '" + author_first_name + "'");
                    if (author_last_name != null && !author_last_name.trim().isEmpty()) updateArgs.add("author_first_name = '" + author_last_name + "'");
                    if (genre != null && !genre.trim().isEmpty()) updateArgs.add("genre = '" + genre + "'");
                    try {
                        if (publication_year != null && !publication_year.trim().isEmpty()) {
                            Integer.parseInt(publication_year.trim());
                            updateArgs.add("publication_year = '" + publication_year + "'");
                        }
                    } catch (NumberFormatException e) {
                        throw new CastIntException("Произошла ошибка при попытке преобразования " +
                                "'publication_year' преобразуется в целое число. ");
                    }
                } catch (NumberFormatException e) {
                    throw new CastIntException("Произошла ошибка при попытке преобразовать 'id' в целое число.");
                }
            } else {
                throw EmptyFieldException.DEFAULT_INSTANCE;
            }
        } else {
            throw new EmptyFieldException("ID не может быть пустым!");
        }

        status = new PostgreSQLDAO().updateBooks(Integer.parseInt(books_id), updateArgs);
        if (status.equals("0")) {
            throw RowNotExistsException.DEFAULT_INSTANCE;
        }

        return status;
    }
}