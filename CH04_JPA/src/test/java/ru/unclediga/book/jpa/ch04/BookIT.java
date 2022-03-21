package ru.unclediga.book.jpa.ch04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BookIT {


  private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PUTest");
  private EntityManager em;
  private EntityTransaction tx;

  @Before
  public void initEntityManager() throws Exception {
    em = emf.createEntityManager();
    tx = em.getTransaction();
  }

  @After
  public void closeEntityManager() throws Exception {
    if (em != null) em.close();
  }


  @Test
  public void shouldCreateH2G2Book() throws Exception {

    // Creates an instance of book
    Book book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false);

    // Persists the book to the database
    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull("ID should not be null", book.getId());

    // Retrieves all the books from the database
    List<Book> books = em.createNamedQuery("findBookH2G2", Book.class).getResultList();
    assertTrue(books.size() > 0);
  }

   // @Test(expected = ConstraintViolationException.class)
   // public void shouldRaiseConstraintViolationCauseNullTitle() {

   //   Book book = new Book(null, "Null title, should fail", 12.5F, "1-84023-742-2", 354, false);
   //   em.persist(book);
   // }
}
