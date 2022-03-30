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

    tx.begin();
    em.persist(c);
    tx.commit();
    assertNotNull(c.getAge());
    assertEquals(22, c.getAge().intValue());

    Customer38 c2 = em.find(Customer38.class,c.getId());
    assertNotNull(c2.getAge());
    assertEquals(22, c2.getAge().intValue());

    c.setAge(100);
    assertEquals(100, c.getAge().intValue());        
    tx.begin();
    em.merge(c);
    tx.commit();
    em.refresh(c);
    assertNotNull(c.getAge());
    assertEquals(100, c.getAge().intValue());
    em.detach(c);
    c2 = em.find(Customer38.class,c.getId());
    assertNotNull(c2.getAge());
    assertEquals(22, c2.getAge().intValue());

    tx.begin();
    c.setBirthYear(1990);
    em.merge(c);
    tx.commit();
    em.refresh(c);

    assertNotNull(c.getAge());
    assertEquals(32, c.getAge().intValue());

    c2 = em.find(Customer38.class,c.getId());
    assertNotNull(c2.getAge());
    assertEquals(32, c2.getAge().intValue());

  }
}