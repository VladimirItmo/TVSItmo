package com.soap;

import javax.xml.ws.Endpoint;
public class App {
    public static void main(String[] args) {
        String url = "http://0.0.0.0:8080/BooksServiceCRUD";
        Endpoint.publish(url, new BooksWebService());
    }
}