package ru.unclediga.book.jpa.ch06.ex39;

import ru.unclediga.book.jpa.ch06.AbstractPersistenceTest;

import org.junit.Test;
import static org.junit.Assert.*;

public class Customer39IT extends AbstractPersistenceTest {

  @Test
  public void testProcedureCalcAge(){
    Customer39 c = new Customer39("Ivan", "Ivanov", "iivan@mail.ru", 2000, 2022);
    c.calcAge();
    assertEquals(22, c.getAge().intValue());
  }


  @Test
  public void shoudAge22(){
    Customer39 c = new Customer39("Ivan", "Ivanov", "iivan@mail.ru", 2000, 2022);
    tx.begin();
    em.persist(c);
    tx.commit();
    assertEquals(22, c.getAge().intValue());
  }
    
  @Test
  public void shoudAgeNull(){
    Customer39 c = null;
    c = new Customer39("Ivan", "Ivanov", "iivan@mail.ru", null, 2022);
    tx.begin();
    em.persist(c);
    tx.commit();
    assertNull(c.getAge());

    c = new Customer39("Ivan", "Ivanov", "iivan@mail.ru", 2000, null);
    tx.begin();
    em.persist(c);
    tx.commit();
    assertNull(c.getAge());
  }  

  @Test(expected = IllegalArgumentException.class)
  public void validateFirstName(){
    Customer39 c = new Customer39("", "Ivanov", "iivan@mail.ru", 2000, 2022);
    tx.begin();
    em.persist(c);
    tx.commit();
  }

  @Test(expected = IllegalArgumentException.class)
  public void validateLastName(){
    Customer39 c = new Customer39("Ivan", null, "iivan@mail.ru", 2000, 2022);
    tx.begin();
    em.persist(c);
    tx.commit();
  }  
}