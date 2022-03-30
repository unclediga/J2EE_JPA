package ru.unclediga.book.jpa.ch06.ex21;

import ru.unclediga.book.jpa.ch06.AbstractPersistenceTest;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Arrays;

import javax.persistence.*;

public class Query21IT extends AbstractPersistenceTest {


  private Address21 a1 = new Address21("Mayak st","Zheldor", "123450", "RU");
  private Customer21 c1 = new Customer21("Ivan", "Ivanov", "iivan@mail.ru", "1-2-333", a1);
  private Address21 a2 = new Address21("Mayak st","Zheldor", "123451", "RU");
  private Customer21 c2 = new Customer21("Petro", "Petrov", "pivan@mail.ru", "1-2-333", a2);
  private Address21 a3 = new Address21("Mayak st","Moscow", "123452", "RU");
  private Customer21 c3 = new Customer21("Sidor", "Sidorov", "sivan@mail.ru", "1-2-333", a3);
  private Address21 a4 = new Address21("Baiker st","London", "333-333", "UK");
  private Customer21 c4 = new Customer21("Oleg", "Ivanov", "oivan@mail.ru", "1-2-333-1", a4);
  private Address21 a5 = new Address21("Libertadt st","Sagunt", "44-44-44", "ES");
  private Customer21 c5 = new Customer21("Igor", "Ivanov", "iivan@mail.ru", "1-2-333-2", a5);
  private Address21 a6 = new Address21("Octubre st","Valencia", "44-44-50", "ES");
  private Customer21 c6 = new Customer21("Ingvar", "Ivanov", "iivan@mail.ru", "1-2-333-3", a6);

  private Book21 b1 = new Book21("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false);
  private Book21 b2 = new Book21("W&P", "War And Peace", 36.62F, "978-0679405733", 354, false);



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
  public void useDynamicQuery(){
    
    Query query = null;
    List<Customer21> list = null;

    query = em.createQuery("SELECT c FROM Customer21 c");
    list = query.getResultList();
    assertEquals(SIZE, list.size());

    query = em.createQuery("SELECT c FROM Customer21 c");
    query.setMaxResults(3);
    list = query.getResultList();
    assertEquals(3, list.size());

    query = em.createQuery("SELECT c FROM Customer21 c WHERE c.address.country = ?1 AND c.phoneNumber LIKE ?2");
    query.setParameter(1,"RU");
    query.setParameter(2,"1-2-33%");
    list = query.getResultList();
    assertEquals(3, list.size());

    query = em.createQuery("SELECT c FROM Customer21 c WHERE c.address.country = :country AND c.phoneNumber LIKE :num");
    query.setParameter("country","RU");
    query.setParameter("num","1-2-33%");
    list = query.getResultList();
    assertEquals(3, list.size());

    query = em.createQuery("SELECT c FROM Customer21 c ORDER BY c.address.country,c.firstName");
    query.setFirstResult(2);
    query.setMaxResults(2);
    list = query.getResultList();
    assertEquals(2, list.size());
    assertEquals("Ivan", list.get(0).getFirstName());
    assertEquals("Petro", list.get(1).getFirstName());

  }

  @Test
  public void useTypedQuery(){
    
    TypedQuery<Customer21> query = null;
    List<Customer21> list = null;

    query = em.createQuery("SELECT c FROM Customer21 c", Customer21.class);
    list = query.getResultList();
    assertEquals(SIZE, list.size());

    query = em.createQuery("SELECT c FROM Customer21 c", Customer21.class);
    query.setMaxResults(3);
    list = query.getResultList();
    assertEquals(3, list.size());

    query = em.createQuery("SELECT c FROM Customer21 c WHERE c.address.country = ?1 AND c.phoneNumber LIKE ?2", Customer21.class);
    query.setParameter(1,"RU");
    query.setParameter(2,"1-2-33%");
    list = query.getResultList();
    assertEquals(3, list.size());

    query = em.createQuery("SELECT c FROM Customer21 c WHERE c.address.country = :country AND c.phoneNumber LIKE :num", Customer21.class);
    query.setParameter("country","RU");
    query.setParameter("num","1-2-33%");
    list = query.getResultList();
    assertEquals(3, list.size());

    query = em.createQuery("SELECT c FROM Customer21 c ORDER BY c.address.country,c.firstName", Customer21.class);
    query.setFirstResult(2);
    query.setMaxResults(2);
    list = query.getResultList();
    assertEquals(2, list.size());
    assertEquals("Ivan", list.get(0).getFirstName());
    assertEquals("Petro", list.get(1).getFirstName());

  }  

  @Test
  public void useNamedQuery(){
    
    Query query = null;
    TypedQuery<Customer21> tquery = null;
    List<Customer21> list = null;

    tquery = em.createNamedQuery("findAll", Customer21.class);
    list = tquery.getResultList();
    assertEquals(SIZE, list.size());

    tquery = em.createNamedQuery(Customer21.FIND_ALL, Customer21.class);
    list = tquery.getResultList();
    assertEquals(SIZE, list.size());


    TypedQuery<Book21> tquery2 = em.createNamedQuery("Book21.findAll", Book21.class);
    List<Book21> list2 = tquery2.getResultList();
    assertEquals(2, list2.size());

// @NamedQuery(name = "findAll", query = "SELECT b FROM Book21 b")

// query = em.createNamedQuery("findAll");
// list = query.getResultList();
// assertEquals(SIZE, list.size());
// ... AND  ...
// TypedQuery<Book21> tquery2 = em.createNamedQuery("findAll", Book21.class);
// List<Book21> list2 = tquery2.getResultList();
// assertEquals(SIZE, list2.size());

// Exception Description: Predeployment of PersistenceUnit [chapter06PUTest] failed.
// Internal Exception: Exception [EclipseLink-7299] org.eclipse.persistence.exceptions.ValidationException
// Exception Description: Conflicting annotations with the same name [findAll] were found. 
// The first one [@javax.persistence.NamedQuery({query=SELECT b FROM Book21 b, name=findAll})] was found 
// within [class ru.unclediga.book.jpa.ch06.ex21.Book21] 
// and the second [@javax.persistence.NamedQuery({query=SELECT c FROM Customer21 c, name=findAll})] was found 
// within [class ru.unclediga.book.jpa.ch06.ex21.Customer21]. 
// Named annotations must be unique across the persistence unit.

    query = em.createNamedQuery(Customer21.FIND_ALL, Customer21.class);
    query.setMaxResults(3);
    list = query.getResultList();
    assertEquals(3, list.size());


    query = em.createNamedQuery("withPositionParams", Customer21.class);
    query.setParameter(1,"RU");
    query.setParameter(2,"1-2-33%");
    list = query.getResultList();
    assertEquals(3, list.size());

    query = em.createNamedQuery("withNamedParams", Customer21.class);
    query.setParameter("country","RU");
    query.setParameter("num","1-2-33%");
    list = query.getResultList();
    assertEquals(3, list.size());

    query = em.createNamedQuery("ordered", Customer21.class);
    query.setFirstResult(2);
    query.setMaxResults(2);
    list = query.getResultList();
    assertEquals(2, list.size());
    assertEquals("Ivan", list.get(0).getFirstName());
    assertEquals("Petro", list.get(1).getFirstName());

  }

  @Test
  public void useNativeQuery(){
    
    Query query = null;
    List<Object[]> list = null;

    query = em.createNativeQuery("SELECT c.firstName,c.lastName FROM ex21_customer c JOIN ex21_address a ON c.address_fk = a.id WHERE a.country = 'UK'");
    list = query.getResultList();
    assertEquals(1, list.size());
    Object[] customer = list.get(0);
    assertEquals("Oleg", customer[0]);
    assertEquals("Ivanov", customer[1]);
  }

  @Test
  public void useUpdateDelete(){
    tx.begin();
    Query query = em.createQuery("UPDATE Customer21 c SET c.phoneNumber = '5222-10' WHERE c.address.country = 'UK'");
    int cnt = query.executeUpdate();
    assertEquals(1, cnt);
    tx.commit();

    tx.begin();
    query = em.createQuery("DELETE FROM Customer21 c WHERE c.address.country IN ('UK','ES')");
    cnt = query.executeUpdate();
    assertEquals(3, cnt);
    tx.commit();
  }

  @Test
  public void useOtherReturnTypes(){
    
    TypedQuery query = em.createQuery("SELECT NEW ru.unclediga.book.jpa.ch06.ex21.CustomerDTO(c.id,c.firstName, c.lastName) FROM Customer21 c ORDER BY c.firstName",CustomerDTO.class);
    List<CustomerDTO> list = query.getResultList();
    assertEquals(6, list.size());
    assertEquals("Igor", list.get(0).firstName);
  }
}