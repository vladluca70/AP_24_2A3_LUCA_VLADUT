package org.example;

import org.example.Book;
import org.example.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = BookRepository.getEntityManager();

        createBooksTable(entityManager);

        // Adăugăm un autor și o carte
        AuthorDAO authorDAO = new AuthorDAO();
        authorDAO.addAuthor("Mihai Eminescu");

        Book book1 = new Book();
        book1.setTitle("Plumb");
        book1.setAuthor("George Bacovia");
        book1.setLanguage("Limba Romana");
        // Setăm data de publicare și numărul de pagini
        // ...

        BookRepository bookRepository = new BookRepository();
        bookRepository.create(book1);

        // Găsim o carte după id
        Book foundBook = bookRepository.findById(1);
        if (foundBook != null) {
            System.out.println("Found book: " + foundBook.getTitle());
        }

        // Găsim cărți după nume
        List<Book> books = bookRepository.findByName("Plumb");
        for (Book book : books) {
            System.out.println("Book found by name: " + book.getTitle());
        }

        entityManager.close();
    }

    private static void createBooksTable(EntityManager entityManager) {
        // Implementarea metodei de creare a tabelului 'books' din baza de date
        // ...
    }
}
