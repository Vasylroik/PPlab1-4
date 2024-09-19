package main;

import books.Book;
import java.util.ArrayList;

public class Main {

    public static void printBooksByAuthor(ArrayList<Book> books, String author) {
        System.out.println("Книги автора: " + author);
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
            }
        }
    }

    public static void printBooksByPublisher(ArrayList<Book> books, String publisher) {
        System.out.println("Книги видавництва: " + publisher);
        for (Book book : books) {
            if (book.getPublisher().equalsIgnoreCase(publisher)) {
                System.out.println(book);
            }
        }
    }

    public static void printBooksAfterYear(ArrayList<Book> books, int year) {
        System.out.println("Книги, видані після " + year + " року:");
        for (Book book : books) {
            if (book.getYear() > year) {
                System.out.println(book);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "1984", "Джордж Орвелл", "Видавництво Харків", 1949, 328, 250.0));
        books.add(new Book(2, "Кобзар", "Тарас Шевченко", "Видавництво Київ", 1840, 500, 350.0));
        books.add(new Book(3, "Тіні забутих предків", "Михайло Коцюбинський", "Видавництво Львів", 1911, 300, 250.0));
        books.add(new Book(4, "Захар Беркут", "Іван Франко", "Видавництво Київ", 1883, 250, 200.0));
        books.add(new Book(5, "Собор", "Олесь Гончар", "Видавництво Харків", 1968, 400, 320.0));
        books.add(new Book(6, "Чорний Ворон", "Василь Шкляр", "Видавництво Київ", 2009, 560, 450.0));
        books.add(new Book(7, "Гордість і упередження", "Джейн Остін", "Видавництво Лондон", 1813, 432, 300.0));
        books.add(new Book(8, "Вбити пересмішника", "Гарпер Лі", "J.B. Lippincott & Co.", 1960, 281, 350.0));
        books.add(new Book(9, "Буремний перевал", "Емілі Бронте", "Thomas Cautley Newby", 1847, 416, 320.0));


        printBooksByAuthor(books, "Джордж Орвелл");
        System.out.println();

        printBooksByPublisher(books, "Видавництво Лондон");
        System.out.println();

        printBooksAfterYear(books, 1950);
    }
}
