package ru.unclediga.book.jpa.ch06.ex42;

import ru.unclediga.book.jpa.ch06.AbstractPersistenceTest;

import org.junit.Test;
import static org.junit.Assert.*;

public class Customer42IT extends AbstractPersistenceTest {
  
  @Test
  //@Test(expected = IllegalArgumentException.class)
  public void validateFirstName(){
    Customer42 c = new Customer42("", "Ivanov", "iivan@mail.ru", 2000, 2022);
    tx.begin();
    em.persist(c);
    tx.commit();
  }

  @Test
  //@Test(expected = IllegalArgumentException.class)
  public void validateLastName(){
    Customer42 c = new Customer42("Ivan", null, "iivan@mail.ru", 2000, 2022);
    tx.begin();
    em.persist(c);
    tx.commit();
  }  

  @Test
  public void testLifeCycle(){
    Customer42 c = new Customer42("Ivan", "Ivanov", "iivan@mail.ru", 2000, 2022);

    System.out.println(" =>> BEGIN");
    System.out.println("Managed ? :" + isManaged(c));
    assertFalse(em.contains(c));
    
    System.out.println(" =>> PERSIST");
    tx.begin();
    em.persist(c);
    tx.commit();
    System.out.println("Managed ? :" + isManaged(c));
    assertTrue(em.contains(c));


    System.out.println(" =>> FIND");
    em.clear();
    System.out.println("Managed ? :" + isManaged(c));
    assertFalse(em.contains(c));
    c = em.find(Customer42.class, c.getId());
    System.out.println("Managed ? :" + isManaged(c));
    assertTrue(em.contains(c));

    System.out.println(" =>> DETACH");
    System.out.println("Managed ? :" + isManaged(c));
    em.detach(c);
    System.out.println("Managed ? :" + isManaged(c));
    assertFalse(em.contains(c));
    c = em.find(Customer42.class, c.getId());
    System.out.println("Managed ? :" + isManaged(c));
    assertTrue(em.contains(c));

    System.out.println(" =>> REFRESH");
    c.setEmail("New@mail.ru");
    System.out.println("new e-mail:" + c.getEmail());
    tx.begin();
    em.refresh(c);
    tx.commit();
    System.out.println("refresh e-mail:" + c.getEmail());
    assertEquals("iivan@mail.ru", c.getEmail());
    System.out.println("Managed ? :" + isManaged(c));
    assertTrue(em.contains(c));


    System.out.println(" =>> SET");
    tx.begin();
    c.setFirstName("New FN");
    c.setLastName("New LN");
    tx.commit();
    System.out.println("set lName:" + c.getLastName());
    assertEquals("New FN", c.getFirstName());
    assertEquals("New LN", c.getLastName());
    System.out.println("Managed ? :" + isManaged(c));
    assertTrue(em.contains(c));

    System.out.println(" =>> MERGE (UPDATE)");
    System.out.println("Managed ? :" + isManaged(c));
    em.clear();
    System.out.println("Managed ? :" + isManaged(c));
    c.setEmail("New@mail.ru");
    System.out.println("new e-mail:" + c.getEmail());
    tx.begin();
    c = em.merge(c);
    tx.commit();
    System.out.println("new e-mail:" + c.getEmail());
    assertEquals("New@mail.ru", c.getEmail());
    System.out.println("Managed ? :" + isManaged(c));
    assertTrue(em.contains(c));

    System.out.println(" =>> REMOVE");
    System.out.println("Managed ? :" + isManaged(c));
    tx.begin();
    em.remove(c);
    tx.commit();
    System.out.println("Managed ? :" + isManaged(c));
    assertFalse(em.contains(c));
  }  

  private String isManaged(Customer42 c){
    return em.contains(c) ? "managed" : "not managed";
  }

}