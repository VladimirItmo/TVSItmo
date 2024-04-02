package com.soap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import java.util.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

public class ClientApp {
    private static final String URL = "http://localhost:8080/rest/books";

    public static void main(String[] args) {
        Client client = Client.create();

        List<String> searchThis = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввод аргументов для поиска (одна строка = один аргумент, введите 'exit' для выхода): ");
        String given_arg;
        do {
            given_arg = scanner.nextLine();
            if (given_arg != null && !given_arg.trim().isEmpty()) {
                searchThis.add(given_arg);
            }
        } while (!Objects.equals(given_arg, "exit"));

        for (Books books : searchBooksByFields(client, searchThis)) {
            System.out.println(books);
        }
    }

    private static List<Books> searchBooksByFields(Client client, List<String> searchParams) {
        WebResource webResource = client.resource(URL);
        if (searchParams != null) {
            MultivaluedMap<String, String> reqParams = new MultivaluedMapImpl();
            reqParams.put("searchParams", searchParams);
            webResource = webResource.queryParams(reqParams);

        }
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<List<Books>> type = new GenericType<List<Books>>() {};
        return response.getEntity(type);
    }

}
