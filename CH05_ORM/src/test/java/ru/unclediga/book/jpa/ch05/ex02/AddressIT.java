package ru.unclediga.book.jpa.ch05.ex02;

import ru.unclediga.book.jpa.ch05.AbstractPersistenceTest;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class AddressIT extends AbstractPersistenceTest{

  @Test
  public void test() throws Exception {

    // Creates an instance of book
    Address address = new Address(getRandomId(), "65B Ritherdon Rd", "At James place", "London", "LDN", "7QE554", "UK");

    // Persists the book to the database
    tx.begin();
    em.persist(address);
    tx.commit();
    assertNotNull("ID should not be null", address.getId());
  }
}
