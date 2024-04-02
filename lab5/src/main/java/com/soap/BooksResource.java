package com.soap;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/books")
@Produces({MediaType.APPLICATION_JSON})

public class BooksResource {

    @GET
    public LinkedHashSet<Books> getBooks(@QueryParam("query") String query, @QueryParam("searchParam") final List<String> searchArgs) {
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
            throw new IllegalArgumentException("Должен быть указан параметр 'query' или 'searchParam'.");
        }
    }

    @POST
    public String createBooks(
            @QueryParam("booksTitle") String title,
            @QueryParam("booksAuthor_first_name") String author_first_name,
            @QueryParam("booksAuthor_last_name") String author_last_name,
            @QueryParam("booksGenre") String genre,
            @QueryParam("booksYear") String publication_year) {
        return new PostgreSQLDAO().createBooks(title, author_first_name, author_last_name,  genre, Integer.parseInt(publication_year));
    }

    @DELETE
    public String deleteBooks(@QueryParam("id") String books_id) {
        return new PostgreSQLDAO().deleteBooks(Integer.parseInt(books_id));
    }

    @PUT
    public String updateBooks(
            @QueryParam("id") String books_id,
            @QueryParam("booksTitle") String title,
            @QueryParam("booksAuthor_first_name") String author_first_name,
            @QueryParam("booksAuthor_last_name") String author_last_name,
            @QueryParam("booksGenre") String genre,
            @QueryParam("booksYear") String publication_year) {

        List<String> updateArgs = new ArrayList<>();

        if (title != null && !title.trim().isEmpty()) updateArgs.add("title = '" + title + "'");
        if (author_first_name != null && !author_first_name.trim().isEmpty())
            updateArgs.add("author_first_name = '" + author_first_name + "'");
        if (author_last_name != null && !author_last_name.trim().isEmpty())
            updateArgs.add("author_last_name = '" + author_last_name + "'");
        if (genre != null && !genre.trim().isEmpty()) updateArgs.add("genre = '" + genre + "'");
        if (publication_year != null && !publication_year.trim().isEmpty()) updateArgs.add("year = '" + publication_year + "'");

        return new PostgreSQLDAO().updateBooks(Integer.parseInt(books_id), updateArgs);
    }

}