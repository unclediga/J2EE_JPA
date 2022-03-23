package ru.unclediga.book.jpa.ch05.ex23;

import ru.unclediga.book.jpa.ch05.AbstractPersistenceTest;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

public class Book23IT extends AbstractPersistenceTest{

  @Test
  public void shouldCreateABook() throws Exception {

    List<String> tags = new ArrayList<>();
    tags.add("A");
    tags.add("B");
    tags.add("C");


    // Creates an instance of book
    Book23 book = new Book23("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false, tags);

    // Persists the book to the database
    tx.begin();
    em.persist(book);
    tx.commit();


    tx.begin();
    Book23 book2 = em.find(Book23.class, book.getId());
    tx.commit();
    assertNotNull("ID should not be null", book2.getId());
    assertEquals(book2.getTags().size(), 3);
  }
 } 
