package com.soap;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class ClientApp {
    private static final String URL = "http://localhost:8080/restCRUD/books";
    public static void main(String[] args) {
        Client client = Client.create();

        // Выбор метода CRUD
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите метод CRUD (введите CREATE, READ, SEARCH, UPDATE или DELETE) или введите \"exit\" для выхода:");
        String choosenMethod;
        do {
            choosenMethod = scanner.nextLine();
            // проверяем строку на наличие аргумента: если строка не является пустой и не состоит из пробелов, то
            // проверяем на наличие одной из возможных операций CRUD
            if (choosenMethod != null && !choosenMethod.trim().isEmpty()) {
                switch (choosenMethod) {
                    case ("CREATE"):
                        createBooks(client);
                        System.out.println("Вот и все! Вы можете выбрать другой метод CRUD или ввести \"exit\" для выхода\"");
                        break;
                    case ("READ"):
                        readBooks(client);
                        System.out.println("Вот и все! Вы можете выбрать другой метод CRUD или ввести \"exit\" для выхода\"");
                        break;
                    case ("SEARCH"):
                        searchBooks(client);
                        System.out.println("Вот и все! Вы можете выбрать другой метод CRUD или ввести \"exit\" для выхода\"");
                        break;
                    case ("UPDATE"):
                        updateBooks(client);
                        System.out.println("Вот и все! Вы можете выбрать другой метод CRUD или ввести \"exit\" для выхода\"");
                        break;
                    case ("DELETE"):
                        deleteBooks(client);
                        System.out.println("Вот и все! Вы можете выбрать другой метод CRUD или ввести \"exit\" для выхода\"");
                        break;
                    case ("exit"):
                        System.out.println("Bye-Bye!");
                        break;
                    default:
                        System.out.println("Вы можете ввести просто CREATE, READ, SEARCH, UPDATE или DELETE!");
                        System.out.println("Повторите попытку или используйте \"exit\" для выхода.");
                        break;
                }
            }
        } while (!Objects.equals(choosenMethod, "exit"));
        scanner.close();
    }

    private static void updateBooks(Client client) {
        // Консольный ввод аргументов
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ID книги (целое число): ");
        String BooksIDString = scanner.nextLine();
        // Проверяем booksId на число
        System.out.println("Какие поля вы хотите обновить для этой строки? \n" +
                "Выберите поля \"title\", \"author_first_name\", \"author_last_name\", \"genre\", \"year\" и введите их ниже \n" +
                " разделяется запятой без пробелов");
        String updateRows = scanner.nextLine();

        // Преобразуем полученную строку в список аргументов
        String[] updateRowsList = updateRows.split(",", -1);

        Map<String, String> updateRowsMap = new HashMap<>();
        updateRowsMap.put("title", "");
        updateRowsMap.put("author_first_name", "");
        updateRowsMap.put("author_last_name", "");
        updateRowsMap.put("genre", "");
        updateRowsMap.put("year", "");

        for (String row : updateRowsList) {
            switch (row) {
                case "title":
                    System.out.println("Введите новое значение для поля \"title\":");
                    String title = scanner.nextLine();
                    if (title != null && !title.trim().isEmpty()) {
                        updateRowsMap.put("title", title);
                    } else {
                        System.out.println("Поле \"title\" неверно и обновляться не будет!");
                    }
                    break;
                case "author_first_name":
                    System.out.println("Введите новое значение для поля \"author_first_name\":");
                    String author_first_name = scanner.nextLine();
                    if (author_first_name != null && !author_first_name.trim().isEmpty()) {
                        updateRowsMap.put("author_first_name", author_first_name);
                    } else {
                        System.out.println("Поле \"author_first_name\" неверно и обновляться не будет!");
                    }
                    break;

                case "author_last_name":
                    System.out.println("Введите новое значение для поля \"author_last_name\":");
                    String author_last_name = scanner.nextLine();
                    if (author_last_name != null && !author_last_name.trim().isEmpty()) {
                        updateRowsMap.put("author_last_name", author_last_name);
                    } else {
                        System.out.println("Поле \"author_last_name\" неверно и обновляться не будет!");
                    }
                    break;


                case "genre":
                    System.out.println("Введите новое значение для поля \"genre\":");
                    String genre = scanner.nextLine();
                    if (genre != null && !genre.trim().isEmpty()) {
                        updateRowsMap.put("genre", genre);
                    } else {
                        System.out.println("Поле \"genre\" неверно и обновляться не будет!");
                    }
                    break;

                case "year":
                    System.out.println("Введите новое значение для поля \"year\" (целое число):");
                    String year = scanner.nextLine();
                    try {
                        Integer.parseInt(year.trim());
                    } catch (NumberFormatException ex) {
                        Logger.getLogger(ClientApp.class.getName()).log(Level.SEVERE, null, ex);
                        year = "";
                    }
                    if (!year.trim().isEmpty()) {
                        updateRowsMap.put("year", year);
                    } else {
                        System.out.println("Поле \"year\" не является целым числом и обновляться не будет!");
                    }
                    break;

                default:
                    System.out.println("Неверный запрос. Попробуйте еще раз!");
                    break;
            }
        }


        System.out.println("Вы вводите новые значения для строки " + BooksIDString + ":\n" + updateRowsMap);
        System.out.println("Вы действительно хотите изменить эти поля для строки " + BooksIDString + "? (y -> yes, other -> no)");
        String agree = scanner.nextLine();
        if (agree.equals("y")) {
            String title = updateRowsMap.get("title");
            String author_first_name = updateRowsMap.get("author_first_name");
            String author_last_name = updateRowsMap.get("author_last_name");
            String genre = updateRowsMap.get("genre");
            String year = updateRowsMap.get("year");

            WebResource webResource = client.resource(URL);
            webResource = webResource.queryParam("id",
                    BooksIDString).queryParam("booksTitle", title).queryParam("booksAuthor_first_name",
                    author_first_name).queryParam("booksAuthor_last_name",
                    author_last_name).queryParam("booksGenre", genre).queryParam("booksYear", year);
            ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).put(ClientResponse.class);
            System.out.println(response.getStatus());
            System.out.println(response.getEntity(new GenericType<String>() {
            }));
        } else {
            System.out.println("Все аргументы пусты. Обновление строки не может быть завершено.");
        }
    }


    private static void deleteBooks(Client client) {
        // Консольный ввод аргументов
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите идентификатор пользователя (целое число): ");
        String booksId = scanner.nextLine();

        WebResource webResource = client.resource(URL);
        webResource = webResource.queryParam("id", booksId);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
        System.out.println(response.getStatus());
        System.out.println(response.getEntity(new GenericType<String>() {
        }));
    }

    private static void readBooks(Client client) {
        WebResource webResource = client.resource(URL);
        String query = "";
        webResource = webResource.queryParam("query", query);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Запрос выполнен");
        }
        GenericType<List<Books>> type = new GenericType<List<Books>>() {};

        for (Books books : response.getEntity(type)) {
            System.out.println(books);
        }
    }

    private static void searchBooks(Client client) {
        List<String> searchThis = new ArrayList<>();
        // Консольный ввод аргументов
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввод аргументов для поиска (одна строка = один аргумент, введите 'exit' для выхода, " +
                "после чего выводится список): ");
        String given_arg;
        do {
            given_arg = scanner.nextLine();
            // проверим строку на наличие аргумента
            if (given_arg != null && !given_arg.trim().isEmpty()) {
                searchThis.add(given_arg);
            }
        } while (!Objects.equals(given_arg, "exit"));

        WebResource webResource = client.resource(URL);

        MultivaluedMap<String, String> reqParams = new MultivaluedMapImpl();
        reqParams.put("searchParam", searchThis);
        webResource = webResource.queryParams(reqParams);

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        System.out.println(response.getStatus());
        System.out.println(response.getEntity(new GenericType<String>() {}));
    }

    private static void createBooks(Client client) {
        // Консольный ввод аргументов
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название: ");
        String title = scanner.nextLine();
        System.out.print("Введите имя автора: ");
        String author_first_name = scanner.nextLine();
        System.out.print("Введите фамилию автора: ");
        String author_last_name = scanner.nextLine();
        System.out.print("Введите жанр книги: ");
        String genre = scanner.nextLine();
        System.out.print("Введите год публикации: ");
        String yearString = scanner.nextLine();


        WebResource webResource = client.resource(URL);

        webResource = webResource.queryParam("booksTitle", title).queryParam("booksAuthor_first_name",
                author_first_name).queryParam("booksAuthor_last_name", author_last_name).queryParam("booksGenre", genre).queryParam("booksYear", yearString);

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class);
        System.out.println(response.getStatus());
        System.out.println(response.getEntity(new GenericType<String>() {}));
    }
}