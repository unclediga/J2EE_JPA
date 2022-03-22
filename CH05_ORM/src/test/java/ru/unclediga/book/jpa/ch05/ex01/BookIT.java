package ru.unclediga.book.jpa.ch05.ex01;

import ru.unclediga.book.jpa.ch05.AbstractPersistenceTest;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class BookIT extends AbstractPersistenceTest{

  @Test
  public void shouldCreateH2G2Book() throws Exception {

    // Creates an instance of book
    Book book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false);

    // Persists the book to the database
    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull("ID should not be null", book.getId());
  }
}
