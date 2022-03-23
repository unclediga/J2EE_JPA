package ru.unclediga.book.jpa.ch05.ex29;

import ru.unclediga.book.jpa.ch05.AbstractPersistenceTest;

import static org.junit.Assert.*;
import org.junit.Test;

public class Customer29IT extends AbstractPersistenceTest{
  @Test
  public void t1(){
    Address29 address = new Address29("Michu ave","Mayak st","Zheldor", "Moscow", "123123", "Rus");
    Customer29 customer = new Customer29("Ivan", "Ivanov", "ivan@mail.ru", "1-2-333", address);
    customer.setAge(100);

    tx.begin();
    em.persist(customer);
    tx.commit();

    tx.begin();
    Customer29 customer2 = em.find(Customer29.class, customer.getId());
    tx.commit();
    assertEquals(customer.getId(), customer2.getId());
    assertEquals(customer.getAddress().getCity(), customer2.getAddress().getCity());

    System.out.printf("[transient] Age = %d\n",customer2.getAge());
  }
}
