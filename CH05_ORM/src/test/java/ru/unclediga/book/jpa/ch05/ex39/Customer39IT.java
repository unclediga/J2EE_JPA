package ru.unclediga.book.jpa.ch05.ex39;

import ru.unclediga.book.jpa.ch05.AbstractPersistenceTest;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;


public class Customer39IT extends AbstractPersistenceTest {
  @Test
  public void t1(){
    Address39 address = new Address39("Michu ave","Mayak st","Zheldor", "Moscow", "123123", "Rus");
    Customer39 customer = new Customer39("Ivan", "Ivanov", "ivan@mail.ru", "1-2-333", address);

    tx.begin();
    em.persist(address);
    em.persist(customer);
    tx.commit();

  /*
  Call: DROP TABLE ex39_address
--Execute query DataModifyQuery(sql="CREATE TABLE ex39_address (ID BIGINT NOT NULL, CITY VARCHAR(255), COUNTRY VARCHAR(255), STATE VARCHAR(255), STREET1 VARCHAR(255), STREET2 VARCHAR(255), ZIPCODE VARCHAR(255), PRIMARY KEY (ID))")
--Execute query DataModifyQuery(sql="ALTER TABLE ex39_customer ADD CONSTRAINT x39customerddrssfk FOREIGN KEY (address_fk) REFERENCES ex39_address (ID)")
--Thread(Thread[main,5,main])--ALTER TABLE ex39_customer ADD CONSTRAINT x39customerddrssfk FOREIGN KEY (address_fk) REFERENCES ex39_address (ID)
*/
    Customer39 customer2 = em.find(Customer39.class, customer.getId()); 
    assertNotNull(customer2.getId());    
    assertNotNull(customer2.getAddress());
    Address39 address2 = customer2.getAddress();
    assertEquals(address.getStreet1(), address2.getStreet1());
  }
}