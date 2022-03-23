package ru.unclediga.book.jpa.ch05.ex25;

import ru.unclediga.book.jpa.ch05.AbstractPersistenceTest;

import org.junit.Test;
import static org.junit.Assert.*;

public class Book25IT extends AbstractPersistenceTest{

  @Test
  public void shouldCreateABook() throws Exception {

    Book25 book = new Book25("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false);

    tx.begin();
    em.persist(book);
    tx.commit();


    tx.begin();
    Book25 book2 = em.find(Book25.class, book.getId());
    tx.commit();
    assertNotNull("ID should not be null", book2.getId());
    assertEquals(book.getId(), book2.getId());
  }
 } 
