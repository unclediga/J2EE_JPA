package ru.unclediga.book.jpa.ch06.ex24;

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

public class CriteriaQuery24IT extends AbstractPersistenceTest {


  private Address24 a1 = new Address24("Mayak st","Zheldor", "123450", "RU");
  private Customer24 c1 = new Customer24("Ivan", "Ivanov", "iivan@mail.ru", "1-2-333", a1);
  private Address24 a2 = new Address24("Mayak st","Zheldor", "123451", "RU");
  private Customer24 c2 = new Customer24("Petro", "Petrov", "pivan@mail.ru", "1-2-333", a2);
  private Address24 a3 = new Address24("Mayak st","Moscow", "123452", "RU");
  private Customer24 c3 = new Customer24("Sidor", "Sidorov", "sivan@mail.ru", "1-2-444", a3);
  private Address24 a4 = new Address24("Baiker st","London", "333-333", "UK");
  private Customer24 c4 = new Customer24("Oleg", "Ivanov", "oivan@mail.ru", "1-2-333-1", a4);
  private Address24 a5 = new Address24("Libertadt st","Sagunt", "44-44-44", "ES");
  private Customer24 c5 = new Customer24("Igor", "Ivanov", "iivan@mail.ru", "1-2-333-2", a5);
  private Address24 a6 = new Address24("Octubre st","Valencia", "44-44-50", "ES");
  private Customer24 c6 = new Customer24("Ingvar", "Ivanov", "iivan@mail.ru", "1-2-333-3", a6);

  private Book24 b1 = new Book24("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false);
  private Book24 b2 = new Book24("W&P", "War And Peace", 36.62F, "978-0679405733", 354, false);



  private static final int SIZE = 6;

  @Before
  public void initTest(){
    tx.begin();
    em.persist(c1);
    em.persist(c2);
    em.persist(c3);
    em.persist(c4);
    em.persist(c5);
    em.persist(c6);
    em.persist(b1);
    em.persist(b2);
    tx.commit();
  }

  @After
  public void closeTest(){
    
    if(tx.isActive()){
      tx.rollback();
    };

    tx.begin();
    List list = Arrays.asList(c1,c2,c3,c4,c5,c6,b1,b2);
    for(Object o : list){
      if (em.contains(o)){
        em.remove(o);
      }
    };

    tx.commit();
  }

  @Test
  public void selectAll(){
    
    Query query = null;
    CriteriaQuery q = null;
    List<Customer24> list = null;
    CriteriaBuilder cb = em.getCriteriaBuilder();

    q = cb.createQuery(Customer24.class);
    query = em.createQuery(q);
    // Root<Customer24> c = q.from(Customer24.class);
    list = query.getResultList();
    assertEquals(SIZE, list.size());

    q = cb.createQuery(Customer24.class);
    query = em.createQuery(q);
    query.setMaxResults(3);
    list = query.getResultList();
    assertEquals(3, list.size());
  }

  @Test
  public void selectWithWhere(){
    
    Query query = null;
    CriteriaQuery q = null;
    List<Customer24> list = null;
    CriteriaBuilder cb = em.getCriteriaBuilder();
    Root<Customer24> c = null;

    q = cb.createQuery(Customer24.class);
    c = q.from(Customer24.class);
    q.select(c).where(cb.equal(c.get("firstName"),"Oleg"));
    query = em.createQuery(q);
    list = query.getResultList();
    assertEquals(1, list.size());
    
    q = cb.createQuery(Customer24.class);
    c = q.from(Customer24.class);
    q.select(c).where(
      cb.and(
        cb.equal(c.get("address").get("country"),"RU"),
        cb.like(c.get("phoneNumber"),"1-2-3%")));
    query = em.createQuery(q);
    list = query.getResultList();
    assertEquals(2, list.size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void selectWithWhere_WrongFieldName(){
    
    Query query = null;
    CriteriaQuery q = null;
    List<Customer24> list = null;
    CriteriaBuilder cb = em.getCriteriaBuilder();

    q = cb.createQuery(Customer24.class);
    Root<Customer24> c = q.from(Customer24.class);
    // !!!!!!!!!       must be       "firstName"  !!!!!!!!!!!!!
    q.select(c).where(cb.equal(c.get("firstname"),"Oleg"));
    query = em.createQuery(q);
    list = query.getResultList();
  }

  public void selectWithModel(){
    
    Query query = null;
    CriteriaQuery q = null;
    List<Customer24> list = null;
    CriteriaBuilder cb = em.getCriteriaBuilder();

    Customer24_ c_ = new Customer24_();
    q = cb.createQuery(Customer24.class);
    Root<Customer24> c = q.from(Customer24.class);
    q.select(c).where(cb.equal(c.get(c_.firstName),"Oleg"));
    query = em.createQuery(q);
    list = query.getResultList();
  }
}