package ru.unclediga.book.jpa.ch05.ex14;

import ru.unclediga.book.jpa.ch05.AbstractPersistenceTest;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Date;

public class Customer14IT extends AbstractPersistenceTest{
  @Test
  public void shoudSaveDateTime(){
    
    Customer14 customer = new Customer14("Ivan", "Ivanov", "ivan@mail.ru", "1-2-333", new Date(1970,1,1), new Date());

    tx.begin();
    em.persist(customer);
    tx.commit();

    customer = em.find(Customer14.class, customer.getId());
    assertEquals(new Date(1970,1,1), customer.getDateOfBirth());

  }

  @Test
  public void shoudTransientAge(){
    Customer14 customer = new Customer14("Ivan", "Ivanov", "ivan@mail.ru", "1-2-333", new Date(1970,1,1), new Date());
    customer.setAge(100);

    tx.begin();
    em.persist(customer);
    tx.commit();

    customer = em.find(Customer14.class, customer.getId());
    assertNull(customer.getAge());
    
  }
}
