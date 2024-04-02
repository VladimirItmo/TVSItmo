package com.soap;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@RequestScoped
@Path("/books")
@Produces({MediaType.APPLICATION_JSON})
public class BooksResource {

    @Resource(lookup = "jdbc/postgres")
    private DataSource dataSource;

    @GET
    public LinkedHashSet<Books> getBooks(@QueryParam("searchParams") final List<String> searchArgs) {
        System.out.println(searchArgs);
        return new PostgreSQLDAO(getConnection()).getBooksFields(searchArgs);
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(BooksResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}