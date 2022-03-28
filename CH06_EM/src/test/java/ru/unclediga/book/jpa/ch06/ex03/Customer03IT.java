package ru.unclediga.book.jpa.ch06.ex03;

import ru.unclediga.book.jpa.ch06.AbstractPersistenceTest;

import org.junit.Test;
import static org.junit.Assert.*;

public class Customer03IT extends AbstractPersistenceTest {

  @Test
  public void shouldFindACustomer(){
    Address03 address = new Address03("Michu ave","Mayak st","Zheldor", "Moscow", "123123", "Rus");
    Customer03 customer = new Customer03("Ivan", "Ivanov", "ivan@mail.ru", "1-2-333", address);
    customer.setAge(100);

    tx.begin();
    em.persist(customer);
    em.persist(address);
    tx.commit();
    
    em.clear();

    Customer03 customer2 =  em.find(Customer03.class, customer.getId()); 
    assertNotNull(customer2.getId());    
    assertNotNull(customer2.getAddress());
    Address03 address2 = customer2.getAddress();
    assertEquals(address.getStreet1(), address2.getStreet1());

  }

  @Test
  public void shouldGetAReference(){
    
    Address03 address = new Address03("Michu ave","Mayak st","Zheldor", "Moscow", "123123", "Rus");
    Customer03 customer = new Customer03("Ivan", "Ivanov", "ivan@mail.ru", "1-2-333", address);
    customer.setAge(100);

    tx.begin();
    em.persist(customer);
    em.persist(address); // unnecessary -> set have cascade 
    tx.commit();
    
    em.clear();

    Customer03 customer2 =  em.getReference(Customer03.class, customer.getId()); 
    assertNotNull(customer2.getId());    
    assertNotNull(customer2.getAddress());
    Address03 address2 = customer2.getAddress();
    assertEquals(address.getStreet1(), address2.getStreet1());

  }

   @Test
  public void shouldRemoveAReference(){
    
    Address03 address = new Address03("Michu ave","Mayak st","Zheldor", "Moscow", "123123", "Rus");
    Customer03 customer = new Customer03("Ivan", "Ivanov", "ivan@mail.ru", "1-2-333", address);
    customer.setAge(100);

    System.out.println("== before {PERSIST} ==");
    System.out.println(customer);
    System.out.println(address);

    tx.begin();
    em.persist(customer);
    // em.persist(address);
    tx.commit();
    
    System.out.println("== {PERSIST} ==");
    System.out.println(customer);
    System.out.println(address);

    Customer03 customer2 =  em.find(Customer03.class, customer.getId()); 
    Address03  address2 =  em.find(Address03.class, address.getId()); 

    System.out.println(customer2);
    System.out.println(address2);

    assertNotNull(customer2);    
    assertNotNull(address2);
    
    tx.begin();
    em.remove(customer);
    tx.commit();

    System.out.println("== {REMOVE} ==");
    System.out.println(customer);
    System.out.println(address);
    assertEquals("Ivan", customer.getFirstName());
    assertEquals("Zheldor", address.getCity());
    
    customer2 =  em.find(Customer03.class, customer.getId()); 
    address2 =  em.find(Address03.class, address.getId()); 

    System.out.println(customer2);
    System.out.println(address2);

    assertNotNull(customer);    
    assertNotNull(address);
    assertNull(customer2);    
    assertNull(address2);
  }

  @Test
  public void shouldSetAndRefreshACustomer(){
    Address03 address = new Address03("Michu ave","Mayak st","Zheldor", "Moscow", "123123", "Rus");
    Customer03 customer = new Customer03("Ivan", "Ivanov", "ivan@mail.ru", "1-2-333", address);
    customer.setAge(100);

    tx.begin();
    em.persist(customer);
    tx.commit();
    
    customer =  em.find(Customer03.class, customer.getId()); 
    assertEquals("Ivan",customer.getFirstName());    
    customer.setFirstName("Simon");
    assertEquals("Simon",customer.getFirstName());    
    em.refresh(customer);
    assertEquals("Ivan",customer.getFirstName());    

  }

  @Test
  public void shouldCheckIfContain(){
    Address03 address = new Address03("Michu ave","Mayak st","Zheldor", "Moscow", "123123", "Rus");
    Customer03 customer = new Customer03("Ivan", "Ivanov", "ivan@mail.ru", "1-2-333", address);
    customer.setAge(100);

    tx.begin();
    em.persist(customer);
    tx.commit();
    
    assertTrue(em.contains(customer));

    tx.begin();
    em.remove(customer);
    assertFalse(em.contains(customer));
    tx.commit();
    
    assertFalse(em.contains(customer));
  }

  @Test
  public void shouldDetach(){
    Address03 address = new Address03("Michu ave","Mayak st","Zheldor", "Moscow", "123123", "Rus");
    Customer03 customer = new Customer03("Ivan", "Ivanov", "ivan@mail.ru", "1-2-333", address);
    customer.setAge(100);

    tx.begin();
    em.persist(customer);
    tx.commit();
    
    assertTrue(em.contains(customer));

    em.detach(customer);
    
    assertFalse(em.contains(customer));
  }

  @Test
  public void shouldCleanSetAndMerge(){
    Address03 address = new Address03("Michu ave","Mayak st","Zheldor", "Moscow", "123123", "Rus");
    Customer03 customer = new Customer03("Ivan", "Ivanov", "ivan@mail.ru", "1-2-333", address);
    customer.setAge(100);

    tx.begin();
    em.persist(customer);
    tx.commit();
    assertTrue(em.contains(customer));

    em.clear();
    assertFalse(em.contains(customer));

    customer.setFirstName("Simon");
    tx.begin();
    em.merge(customer);
    tx.commit();

    em.clear();
    assertFalse(em.contains(customer));

    customer = em.find(Customer03.class, customer.getId());
    assertTrue(em.contains(customer));
    assertEquals("Simon", customer.getFirstName());

  }

  @Test
  public void shouldCleanMergeAndSet(){

    Address03 address = new Address03("Michu ave","Mayak st","Zheldor", "Moscow", "123123", "Rus");
    Address03 address2 = new Address03("Michu ave-II","Mayak st-II","Zheldor-II", "MO", "123123", "Rus");
    Customer03 customer = new Customer03("Ivan", "Ivanov", "ivan@mail.ru", "1-2-333", address);
    Customer03 customer2 = new Customer03("Sidor", "Sidorov", "sid@mail.ru", "1-2-555", address2);

    tx.begin();
    em.persist(customer);
    em.persist(customer2);
    tx.commit();
    assertTrue(em.contains(customer));
    assertTrue(em.contains(customer2));

    em.clear();
    assertFalse(em.contains(customer));
    assertFalse(em.contains(customer2));

    tx.begin();
    System.out.println("before TX");
    System.out.println(customer);
    System.out.println(address);
    System.out.println(customer2);
    System.out.println(address2);
    // em.merge(address);   
    // em.merge(address2);  
    em.merge(customer);
    em.merge(customer2);
    customer.setFirstName("Simon");
    customer2.setFirstName("Petro");
    // em.persist(customer);  // no cascade=MERGE -> ...duplicate key value in a unique or 
    //                        // primary key constraint or unique index idefined on 'EX03_ADDRESS'. 
    //                        // because OneToOne!
    em.merge(customer);
    System.out.println("before Commit");
    System.out.println(customer);
    System.out.println(address);
    System.out.println(customer2);
    System.out.println(address2);
    tx.commit();

    em.clear();
    assertFalse(em.contains(customer));
    assertFalse(em.contains(customer2));

    customer = em.find(Customer03.class, customer.getId());
    assertTrue(em.contains(customer));
    assertEquals("Simon", customer.getFirstName());

    customer2 = em.find(Customer03.class, customer2.getId());
    assertTrue(em.contains(customer2));
    assertEquals("Sidor", customer2.getFirstName());
  }
}
