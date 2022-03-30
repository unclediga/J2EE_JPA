package ru.unclediga.book.jpa.ch06.ex38;

import ru.unclediga.book.jpa.ch06.AbstractPersistenceTest;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Arrays;

import javax.persistence.Query;
import javax.persistence.criteria.*;

import javax.persistence.metamodel.EntityType;

public class Customer38IT extends AbstractPersistenceTest {


  @Test
  public void shoudCalcAge22(){
    Customer38 c = new Customer38("Ivan", "Ivanov", "iivan@mail.ru", 2000, 2022);
    c.calcAge();
    assertEquals(22, c.getAge().intValue());
  }


  @Test
  public void shoudAge22(){
    Customer38 c = new Customer38("Ivan", "Ivanov", "iivan@mail.ru", 2000, 2022);
    assertNull(c.getAge());

    System.out.println("=> PERSIST ");
    tx.begin();
    em.persist(c);
    tx.commit();
    assertNotNull(c.getAge());
    assertEquals(22, c.getAge().intValue());

    System.out.println("=> FIND ");
    Customer38 c2 = em.find(Customer38.class,c.getId());
    assertNotNull(c2.getAge());
    assertEquals(22, c2.getAge().intValue());

    System.out.println("=> SET AGE(100) ");
    c.setAge(100);
    assertEquals(100, c.getAge().intValue());        
    tx.begin();
    System.out.println("=> MERGE ");
    em.merge(c);
    tx.commit();
    
    System.out.println("=> REFRESH ");
    em.refresh(c);
    assertNotNull(c.getAge());
    assertEquals(100, c.getAge().intValue());
    System.out.println("=> DETACH ");
    em.detach(c);

    System.out.println("=> FIND ");
    c2 = em.find(Customer38.class,c.getId());
    assertNotNull(c2.getAge());
    assertEquals(22, c2.getAge().intValue());

    tx.begin();
    System.out.println("=> SET setBirthYear(1990) ");
    c.setBirthYear(1990);
    System.out.println("=> MERGE ");
    em.merge(c);
    tx.commit();

    System.out.println("=> FIND ");
    c = em.find(Customer38.class,c.getId());
    System.out.println("=> REFRESH ");
    em.refresh(c);

    assertNotNull(c.getAge());
    assertEquals(32, c.getAge().intValue());

    System.out.println("=> FIND ");
    c2 = em.find(Customer38.class,c.getId());
    assertNotNull(c2.getAge());
    assertEquals(32, c2.getAge().intValue());

    System.out.println("=> REFRESH ");
    em.refresh(c2);

    System.out.println("=> REMOVE ");
    em.remove(c2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void validateFirstName(){
    Customer38 c = new Customer38("", "Ivanov", "iivan@mail.ru", 2000, 2022);

    tx.begin();
    em.persist(c);
    tx.commit();
  }
  @Test(expected = IllegalArgumentException.class)
  public void validateLastName(){
    Customer38 c = new Customer38("Ivan", null, "iivan@mail.ru", 2000, 2022);

    tx.begin();
    em.persist(c);
    tx.commit();
  }  
}