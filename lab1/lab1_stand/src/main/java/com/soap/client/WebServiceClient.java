package com.soap.client;

import com.soap.client.Books;
import com.soap.client.BooksService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class WebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/BooksService?wsdl");
        BooksService booksService = new BooksService(url);

        List<Books> books = booksService.getBooksWebServicePort().getBooks();
        for (Books book : books) {
            System.out.println("title: " + book.getTitle() + ", author name: " + book.getAuthorFirstName() +
                    ", author last: " + book.getAuthorLastName() + ", publication year: " +
                    book.getPublicationYear());
        }
    }
}

