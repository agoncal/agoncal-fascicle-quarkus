package org.agoncal.fascicle.quarkus.puttingtogether;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class Main {

  public static void main(String[] args) {

    // 1 - Creates an instance of book with tags
    Book book = new Book().title("H2G2").price(12.5F).isbn("1-9754-742-3").nbOfPages(354);
    book.tag("sci-fi").tag("fun").tag("geek");

    // 2 - Obtains an entity manager and a transaction
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("cdbookstorePU");
    EntityManager em = emf.createEntityManager();

    // 3 - Persists the book to the database
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.persist(book);
    tx.commit();

    // 4 - Queries H2G2 books
    book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
    System.out.println(book);

    // 4 - Queries all the books
    int books = em.createNamedQuery("findAllBooks", Book.class).getResultList().size();
    System.out.println("Number of books " + books);

    // 5 - Closes the entity manager and the factory
    em.close();
    emf.close();
  }
}
// end::adocSnippet[]
