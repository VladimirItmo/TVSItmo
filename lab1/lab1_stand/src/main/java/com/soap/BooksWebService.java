package com.soap;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService(serviceName = "BooksService")
public class BooksWebService {
    @WebMethod(operationName = "getBooks")
    public List<Books> getBooks() {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<Books> books = dao.getBooks();
        return books;
    }
}