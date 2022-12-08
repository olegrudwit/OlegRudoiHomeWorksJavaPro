package apps.JavaDatabaseConnectivity;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Main {
    /* JDBC driver and URL */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/bookstore";

    /* database credentials */
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        /* Task 1 */
        List<Book> books1 = extractedTask1();
        System.out.println("Task 1\n" +
                "All books from the database and the authors who wrote them:");
        for (Book book : books1) {
            System.out.printf("'%s' %s %s%n",
                    book.getTitle(),
                    book.getAuthor().getName(),
                    book.getAuthor().getLastName());
        }

        /* Task 2 */
        List<Book> books2 = extractedTask2();
        System.out.println();
        System.out.println("Task 2\n" +
                "All books from the database without an author:");
        for (Book book : books2) {
            System.out.printf("'%s'%n",
                    book.getTitle());
        }

        /* Task 3 */
        Map<Author, Integer> counts1 = extractedTask3();
        System.out.println();
        System.out.println("Task 3\n" +
                "All authors from the database and the number of books they wrote:");
        counts1.entrySet().stream().map(e -> e + " books").forEach(System.out::println);

        /* Task 4 */
        Map<Author, Integer> counts2 = extractedTask4();
        System.out.println();
        System.out.println("Task 4\n" +
                "All authors from the database who have written more than two books:");
        counts2.entrySet().stream().map(e -> e + " books").forEach(System.out::println);
    }

    private static List<Book> extractedTask1() {
        List<Book> books = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            String sql = "SELECT \n" +
                    "`b`.`id` AS bookID, \n" +
                    "`b`.`title` AS bookTitle, \n" +
                    "`b`.`author_id` AS authorID, \n" +
                    "`a`.`name` AS authorName, \n" +
                    "`a`.`last_name` AS authorLastName \n" +
                    "FROM `books` AS `b`\n" +
                    "LEFT JOIN `authors` AS `a` ON `b`.`author_id` = `a`.`id`;";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int bookId = rs.getInt("bookID");
                String title = rs.getString("bookTitle");
                int authorId = rs.getInt("authorID");
                Book book = new Book(bookId, title);

                String authorName = rs.getString("authorName");
                String authorLastName = rs.getString("authorLastName");
                Author author = new Author(authorId, authorName, authorLastName);
                book.setAuthor(author);

                books.add(book);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    private static List<Book> extractedTask2() {
        List<Book> books = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            String sql = "SELECT \n" +
                    "`b`.`id` AS bookID, \n" +
                    "`b`.`title` AS bookTitle\n" +
                    "FROM `books` AS `b` WHERE `author_id` IS NULL;";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int bookId = rs.getInt("bookID");
                String title = rs.getString("bookTitle");
                Book book = new Book(bookId, title);

                books.add(book);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    private static Map<Author, Integer> extractedTask3() {
        Map<Author, Integer> counts = new HashMap<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            String sql = "SELECT \n" +
                    "`a`.`id` AS authorID, \n" +
                    "`a`.`name` AS authorName, \n" +
                    "`a`.`last_name` AS authorLastName ,\n" +
                    "COUNT(*) AS count\n" +
                    "FROM `books` AS `b`\n" +
                    "JOIN `authors` AS `a` ON `b`.`author_id` = `a`.`id`\n" +
                    "GROUP BY `author_id`;";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int authorId = rs.getInt("authorID");
                String authorName = rs.getString("authorName");
                String authorLastName = rs.getString("authorLastName");
                int count = rs.getInt("count");

                Author author = new Author(authorId, authorName, authorLastName);

                counts.put(author, count);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return counts;
    }

    private static Map<Author, Integer> extractedTask4() {
        Map<Author, Integer> counts = new HashMap<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            String sql = "SELECT \n" +
                    "`a`.`id` AS authorID, \n" +
                    "`a`.`name` AS authorName, \n" +
                    "`a`.`last_name` AS authorLastName ,\n" +
                    "COUNT(*) AS counter\n" +
                    "FROM `books` AS `b`\n" +
                    "JOIN `authors` AS `a` ON `b`.`author_id` = `a`.`id`\n" +
                    "GROUP BY `author_id` HAVING counter > 2;";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int authorId = rs.getInt("authorID");
                String authorName = rs.getString("authorName");
                String authorLastName = rs.getString("authorLastName");
                int count = rs.getInt("counter");

                Author author = new Author(authorId, authorName, authorLastName);

                counts.put(author, count);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return counts;
    }
}