package ru.unclediga.book.jpa.ch05.ex20;

import ru.unclediga.book.jpa.ch05.AbstractPersistenceTest;

import org.junit.Test;
import static org.junit.Assert.*;

public class Customer20IT extends AbstractPersistenceTest{

  @Test
  public void shouldCreate() throws Exception {

    Customer20 customer = new Customer20("Ivan", "Ivanov", "ivan@mail.ru", "1-2-333");

    tx.begin();
    em.persist(customer);
    tx.commit();

    customer = em.find(Customer20.class, customer.getId());
    assertNotNull(customer.getLastName());

  }
}
