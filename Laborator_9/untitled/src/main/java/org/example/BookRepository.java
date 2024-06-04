package org.example;

import org.example.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookRepository {
    private static final String PERSISTENCE_UNIT_NAME = "bookPersistenceUnit";
    private static EntityManagerFactory factory;

    private BookRepository() {}

    public static EntityManager getEntityManager() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory.createEntityManager();
    }

    public void create(Book book) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Book findById(int id) {
        EntityManager entityManager = getEntityManager();
        return entityManager.find(Book.class, id);
    }

    public List<Book> findByName(String namePattern) {
        EntityManager entityManager = getEntityManager();
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b WHERE b.title LIKE :namePattern", Book.class);
        query.setParameter("namePattern", "%" + namePattern + "%");
        return query.getResultList();
    }
}
