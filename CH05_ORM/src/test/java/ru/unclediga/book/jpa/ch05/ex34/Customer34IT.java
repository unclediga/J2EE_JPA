package ru.unclediga.book.jpa.ch05.ex34;

import ru.unclediga.book.jpa.ch05.AbstractPersistenceTest;

import org.junit.Test;
import static org.junit.Assert.*;

public class Customer34IT extends AbstractPersistenceTest {

  @Test
  public void t1(){
    Address34 address = new Address34("Michu ave","Mayak st","Zheldor", "Moscow", "123123", "Rus");
    Customer34 customer = new Customer34("Ivan", "Ivanov", "ivan@mail.ru", "1-2-333", address);
    customer.setAge(100);

    tx.begin();
    em.persist(customer);
    em.persist(address);
    tx.commit();
     
    Customer34 customer2 =  em.find(Customer34.class, customer.getId()); 
    assertNotNull(customer2.getId());    
    assertNotNull(customer2.getAddress());
    Address34 address2 = customer2.getAddress();
    assertEquals(address.getStreet1(), address2.getStreet1());

  }
}
