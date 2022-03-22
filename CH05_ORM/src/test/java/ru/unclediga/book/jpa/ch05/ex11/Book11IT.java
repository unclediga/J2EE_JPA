package ru.unclediga.book.jpa.ch05.ex11;

import ru.unclediga.book.jpa.ch05.AbstractPersistenceTest;

import org.junit.Test;
import static org.junit.Assert.*;

public class Book11IT extends AbstractPersistenceTest{

  @Test
  public void shouldCreateABook() throws Exception {

    // Creates an instance of book
    Book11 book = new Book11("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false);

    // Persists the book to the database
    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull("ID should not be null", book.getId());
  }

  @Test
  public void shouldNotUpdateTitle() throws Exception {

    Book11 book = new Book11("THGtG", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false);

    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull("ID should not be null", book.getId());
    assertEquals("Title should be 'THGtG'", "THGtG", book.getTitle());
    assertEquals("Price should be '12.5'", 12.5F, book.getPrice().floatValue(), 0.1f);
    System.out.printf("0: title =%s price=%f\n", book.getTitle(), book.getPrice().floatValue(), 0.1f);

    tx.begin();
    book = em.find(Book11.class, book.getId());
    assertEquals("Title should be 'THGtG'", "THGtG", book.getTitle());
    assertEquals("Price should be '12.5'", 12.5F, book.getPrice().floatValue(), 0.1f);
    System.out.printf("01: title =%s price=%f\n", book.getTitle(), book.getPrice().floatValue(), 0.1f);
    book.setTitle("H2G2");
    book.setPrice(25.8f);
    em.persist(book);
    tx.commit();
    assertEquals("Title should be 'H2G2'", "H2G2", book.getTitle());
    assertEquals("Price should be '25.8'", 25.8F, book.getPrice().floatValue(), 0.1f);
    System.out.printf("2: title =%s price=%f\n", book.getTitle(), book.getPrice().floatValue(), 0.1f);


    
    Book11 book2 = em.find(Book11.class, book.getId());
    System.out.printf("3: title =%s price=%f\n", book2.getTitle(), book2.getPrice().floatValue(), 0.1f);
    assertEquals("Title should be 'THGtG'", "THGtG", book2.getTitle());
    assertEquals("Price should be '25.8'", 25.8F, book2.getPrice().floatValue(), 0.1f);

  }
}
