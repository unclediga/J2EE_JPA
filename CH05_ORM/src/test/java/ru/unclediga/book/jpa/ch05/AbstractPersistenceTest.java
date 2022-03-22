package ru.unclediga.book.jpa.ch05;

import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.Random;

public abstract class AbstractPersistenceTest{

  protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter05PUTest");
  protected EntityManager em;
  protected EntityTransaction tx;

  @Before
  public void initEntityManager() throws Exception {
    em = emf.createEntityManager();
    tx = em.getTransaction();
  }

  @After
  public void closeEntityManager() throws Exception {
    if (em != null) em.close();
  }

  protected long getRandomId(){
    return Math.abs(new Random().nextLong());
  }
}
