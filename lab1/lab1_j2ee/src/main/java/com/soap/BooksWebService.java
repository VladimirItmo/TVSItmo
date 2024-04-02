package com.soap;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.sql.DataSource;


@WebService(serviceName = "BooksService")
public class BooksWebService {

    private List<Books> books;
    @Resource(lookup = "jdbc/postgres")
    private DataSource dataSource;

    @WebMethod(operationName = "getBooks")
    public List<Books> getBooks() {
        PostgreSQLDAO dao = getConnection();
        books = dao.getBooks();
        return books;
    }
    private PostgreSQLDAO getConnection(){
        PostgreSQLDAO dao = null;
        try{
            dao = new PostgreSQLDAO(dataSource.getConnection());
        } catch (SQLException ex){
            Logger.getLogger(BooksWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao;
    }
}
