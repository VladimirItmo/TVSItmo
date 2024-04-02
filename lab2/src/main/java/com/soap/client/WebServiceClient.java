package com.soap.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.util.Base64;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;


public class WebServiceClient {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://0.0.0.0:8080/BooksServiceCRUD?wsdl");
        BooksServiceCRUD booksService = new BooksServiceCRUD(url);

        // Выбор метода CRUD
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите метод CRUD (введите CREATE, READ, UPDATE или DELETE) или введите \"exit\" для выхода:");
        String choosenMethod;
        do {
            choosenMethod = scanner.nextLine();
            // проверяем строку на наличие аргумента: если строка не является пустой и не состоит из пробелов, то
            // проверяем на наличие одной из возможных операций CRUD
            if (choosenMethod != null && !choosenMethod.trim().isEmpty()) {

                switch (choosenMethod) {
                    case ("CREATE"):
                        createBooksMethod(booksService);
                        System.out.println("Вот и все! Вы можете выбрать другой метод CRUD или ввести \"exit\" для выхода\"");
                        break;
                    case ("READ"):
                        readBooksMethod(booksService);
                        System.out.println("Вот и все! Вы можете выбрать другой метод CRUD или ввести \"exit\" для выхода\"");
                        break;
                    case ("UPDATE"):
                        updateBooksMethod(booksService);
                        System.out.println("Вот и все! Вы можете выбрать другой метод CRUD или ввести \"exit\" для выхода\"");
                        break;
                    case ("DELETE"):
                        deleteBooksMethod(booksService);
                        System.out.println("Вот и все! Вы можете выбрать другой метод CRUD или ввести \"exit\" для выхода\"");
                        break;
                    case ("exit"):
                        System.out.println("Bye-Bye!");
                        break;
                    default:
                        System.out.println("Вы можете ввести просто CREATE, READ, UPDATE или DELETE!");
                        System.out.println("Повторите попытку или используйте \"exit\" для выхода.");
                        break;
                }
            }
        } while (!Objects.equals(choosenMethod, "exit"));
        scanner.close();
    }

    private static void updateBooksMethod(BooksServiceCRUD booksService) {

        String status = "Bad";

        // Консольный ввод аргументов
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input books ID (integer): ");
        String BooksIDString = scanner.nextLine();
        // Проверяем booksId на число
        int booksId = -1;
        if (BooksIDString != null && !BooksIDString.trim().isEmpty()) {
            try {
                booksId = Integer.parseInt(BooksIDString.trim());
            } catch (NumberFormatException ex) {
                Logger.getLogger(WebServiceClient.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Ваш запрос неверен! ID является целым числом.");
            }
        }

        if (booksId != -1) {

            System.out.println("Какие поля вы хотите обновить для этой строки? \n" +
                    "Выберите поля \"title\", \"authorFirst\", \"authorLast\", \"genre\", \"push_year\" и введите их ниже \n" +
                    " разделяется запятой без пробелов");
            String updateRows = scanner.nextLine();

            // Преобразуем полученную строку в список аргументов
            String[] updateRowsList = updateRows.split(",", -1);

            Map<String, String> updateRowsMap = new HashMap<>();
            updateRowsMap.put("title", "");
            updateRowsMap.put("authorFirst", "");
            updateRowsMap.put("authorLast", "");
            updateRowsMap.put("genre", "");
            updateRowsMap.put("push_year", "");

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
                    case "authorFirst":
                        System.out.println("Введите новое значение для поля \"authorFirst\":");
                        String authorFirst = scanner.nextLine();
                        if (authorFirst != null && !authorFirst.trim().isEmpty()) {
                            updateRowsMap.put("authorFirst", authorFirst);
                        } else {
                            System.out.println("Поле \"authorFirst\" неверно и обновляться не будет!");
                        }
                        break;
                    case "authorLast":
                        System.out.println("Введите новое значение для поля \"authorLast\":");
                        String authorLast = scanner.nextLine();
                        if (authorLast != null && !authorLast.trim().isEmpty()) {
                            updateRowsMap.put("authorLast", authorLast);
                        } else {
                            System.out.println("Поле \"authorLast\" неверно и обновляться не будет!");
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
                    case "push_year":
                        System.out.println("Введите новое значение для поля \"age\" (целое число):");
                        String push_year = scanner.nextLine();
                        try {
                            Integer.parseInt(push_year.trim());
                        } catch (NumberFormatException ex) {
                            Logger.getLogger(WebServiceClient.class.getName()).log(Level.SEVERE, null, ex);
                            push_year = "";
                        }
                        if (!push_year.trim().isEmpty()) {
                            updateRowsMap.put("push_year", push_year);
                        } else {
                            System.out.println("Поле \"push_year\" не является целым числом и обновляться не будет!");
                        }
                        break;


                    default:
                        System.out.println("Неверный запрос. Попробуйте еще раз!");
                        break;
                }
            }

            int i = 0;
            for(String val : updateRowsMap.values()){
                if (val != null && !val.trim().isEmpty()) {
                    i++;
                }
            }

            if (i != 0) {

                System.out.println("Вы вводите новые значения для строки " + booksId + ":\n" + updateRowsMap);
                System.out.println("Вы действительно хотите изменить эти поля для строки " + booksId + "? (y -> yes, other -> no)");
                String agree = scanner.nextLine();
                if (agree.equals("y")) {
                    String title = updateRowsMap.get("title");
                    String author_first_name = updateRowsMap.get("authorFirst");
                    String author_last_name = updateRowsMap.get("authorLast");
                    String genre = updateRowsMap.get("genre");
                    String publication_yearStr = updateRowsMap.get("push_year").trim();
                    int publication_year = publication_yearStr.isEmpty() ? 0 : Integer.parseInt(publication_yearStr);


                    status = booksService.getBooksWebServicePort().updateBooks(booksId, title, author_first_name, author_last_name, genre, publication_year);

                } else {
                    System.out.println("Вы просто отменяете свой запрос. Попробуйте другой запрос или выйдите.");
                }



            } else {
                System.out.println("Все аргументы пусты. Обновление строки не может быть завершено.");
            }
        }
        System.out.println("Status: " + status);
    }


    private static void deleteBooksMethod(BooksServiceCRUD booksService) {
        String status = "Bad";

        // Консольный ввод аргументов
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите идентификатор пользователя (целое число): ");
        String booksIDString = scanner.nextLine();

        try {
            int booksId = Integer.parseInt(booksIDString.trim());
            status = booksService.getBooksWebServicePort().deleteBooks(booksId);
            if (status.equals("1")) status = "Good";
            System.out.println("Status: " + status);
        } catch (NumberFormatException ex) {
            System.out.println("Неверное значение Id! Введите только одно целое число..");
        }
    }


    private static void readBooksMethod(BooksServiceCRUD booksService) {
        List<Books> books = booksService.getBooksWebServicePort().getBooks();
        for (Books book : books) {
            System.out.println(" title: " + book.getTitle() + ", authorFirst: " + book.getAuthorFirstName() + ", authorLast: " +
                    book.getAuthorLastName());
        }
    }

    private static void createBooksMethod(BooksServiceCRUD booksService) {

        String status = "Bad";

        // Консольный ввод аргументов
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название: ");
        String title = scanner.nextLine();
        System.out.print("Введите имя автора: ");
        String author_first_name = scanner.nextLine();
        System.out.print("Введите фамилию: ");
        String author_last_name = scanner.nextLine();
        System.out.print("Введите жанр: ");
        String genre = scanner.nextLine();
        System.out.print("Введите год публикации: ");
        String yearString = scanner.nextLine();


        // проверим ввод на наличие значений: строка не является пустой и не состоит из пробелов
        if ((title != null && !title.trim().isEmpty())  &&
                (author_first_name != null && !author_first_name.trim().isEmpty())  &&
                (author_last_name != null && !author_last_name.trim().isEmpty()) &&
                (yearString != null && !yearString.trim().isEmpty()) &&
                (genre != null && !genre.trim().isEmpty())) {
            try {
                int publication_year = Integer.parseInt(yearString.trim());
                status = booksService.getBooksWebServicePort().createBooks(title, author_first_name, author_last_name,  genre, publication_year);
                if (status.equals("1")) status = "Good";
                System.out.println("Status: " + status);
            } catch (NumberFormatException ex) {
                System.out.println("Неверный год!");
            }
        }
        else {
            System.out.println("Ваш запрос неверен!");
        }
    }
}

