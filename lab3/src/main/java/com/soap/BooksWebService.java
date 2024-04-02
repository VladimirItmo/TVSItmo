package com.soap;

import com.soap.error.*;

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
                              @WebParam(name = "bookPush") String publication_year) throws EmptyFieldException, ForIntException {

        String status;

        if (title != null && !title.trim().isEmpty() &&
                author_first_name != null && !author_first_name.trim().isEmpty() &&
                author_last_name != null && !author_last_name.trim().isEmpty() &&
                genre != null && !genre.trim().isEmpty() &&
                publication_year != null && !publication_year.trim().isEmpty()) {

            try {
                int ageInt = Integer.parseInt(publication_year.trim());


                PostgreSQLDAO dao = new PostgreSQLDAO();
                status = dao.createBooks(title, author_first_name, author_last_name, genre, ageInt);


            } catch (NumberFormatException ex) {
                ForIntFault fault = ForIntFault.defaultInstance();
                throw new ForIntException("В классе произошла ошибка: " + BooksWebService.class.getName() +
                        ", метод - createBooks(). \n Мы получаем 'NumberFormatException': " + ex +
                        ", при попытке преобразовать год публикации в целое числа.", fault);
            }


        } else {
            EmptyFieldFault fault = EmptyFieldFault.defaultInstance();
            throw new EmptyFieldException("В классе произошла ошибка " + BooksWebService.class.getName() +
                    ", метод createBooks().", fault);
        }

        return status;
    }

    @WebMethod(operationName = "deleteBooks")
    public String deleteBooks(@WebParam(name = "books_id") String books_id) throws ForIntException, IdNotExistsException {
        String status;
        try {
            int booksIdInt = Integer.parseInt(books_id.trim());
            PostgreSQLDAO dao = new PostgreSQLDAO();
            status = dao.deleteBooks(booksIdInt);
            System.out.println(status);
            if (status.equals("0")) {
                IdNotExistsFault fault = IdNotExistsFault.defaultInstance();
                throw new IdNotExistsException("В классе произошла ошибка: " + BooksWebService.class.getName() +
                        ", метод - deleteBooks(). \n  Такой строки нет в БД " + books_id, fault);
            }

        } catch (NumberFormatException ex) {
            ForIntFault fault = ForIntFault.defaultInstance();
            // Выводим дефолтное сообщение об ошибке
            System.out.println("Ошибка: " + fault.getMessage());
            throw new ForIntException("В классе произошла ошибка: " + BooksWebService.class.getName() +
                    ", метод - deleteBooks(). \n Мы получаем 'NumberFormatException': " + ex +
                    ", при попытке преобразовать строки в int.", fault);        }

        return status;
    }


    @WebMethod(operationName = "updateBooks")
    public String updateBooks(@WebParam(name = "books_id") String books_id,
                              @WebParam(name = "booksTitle") String title,
                              @WebParam(name = "booksAuthorfirst") String author_first_name,
                              @WebParam(name = "booksAuthorlast") String author_last_name,
                              @WebParam(name = "booksGenre") String genre,
                              @WebParam(name = "bookPush") String publication_year) throws EmptyFieldException,
            ForIntException,
            IdNotExistsException {

        String status;

        try {
            int booksIdInt = Integer.parseInt(books_id.trim());

            List<String> updateArgs = new ArrayList<>();

            if (title != null && !title.trim().isEmpty()) updateArgs.add("title = '" + title + "'");
            if (author_first_name != null && !author_first_name.trim().isEmpty()) updateArgs.add("author_first_name = '" + author_first_name + "'");
            if (author_last_name != null && !author_last_name.trim().isEmpty()) updateArgs.add("author_last_name = '" + author_last_name + "'");
            if (genre != null && !genre.trim().isEmpty()) updateArgs.add("genre = '" + genre + "'");
            if (!publication_year.trim().isEmpty()) {
                try {
                    Integer.parseInt(publication_year.trim());
                    updateArgs.add("publication_year = '" + publication_year + "'");
                } catch (NumberFormatException ex) {
                    ForIntFault fault = ForIntFault.defaultInstance();
                    throw new ForIntException("В классе произошла ошибка: " + BooksWebService.class.getName() +
                            ", метод - updateBooks(). \n Мы получаем 'NumberFormatException': " + ex +
                            ", при попытке преобразовать \"publication_year\" в \"число\".", fault);
                }
            }

            int i = 0;
            for (String param : updateArgs) {
                if (param != null && !param.trim().isEmpty()) {
                    i++;
                }
            }
            if (i > 0) {

                PostgreSQLDAO dao = new PostgreSQLDAO();
                status = dao.updateBooks(booksIdInt, updateArgs);

            } else {
                EmptyFieldFault fault = EmptyFieldFault.defaultInstance();
                fault.setMessage("Все необходимые параметры пусты. Пожалуйста, введите хотя бы один из них.");
                throw new EmptyFieldException("В классе произошла ошибка " + BooksWebService.class.getName() +
                        ", метод updateBooks().", fault);
            }

            if (status.equals("0")) {
                IdNotExistsFault fault = IdNotExistsFault.defaultInstance();
                throw new IdNotExistsException("В классе произошла ошибка " + BooksWebService.class.getName() +
                        ", метод - updateBooks(). \n Мы получаем 'status = 0' при попытки изменить эту строку в БД " + books_id, fault);
            }

        } catch (NumberFormatException ex) {
            ForIntFault fault = ForIntFault.defaultInstance();
            throw new ForIntException("В классе произошла ошибка " + BooksWebService.class.getName() +
                    ", метод - updateBooks(). \n Мы получаем 'NumberFormatException': " + ex +
                    ", при попытке преобразовать строки в int.", fault);
        }

        return status;
    }
}