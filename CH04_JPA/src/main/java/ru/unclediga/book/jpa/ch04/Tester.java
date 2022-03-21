package ru.unclediga.book.jpa.ch04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.eclipse.persistence.jpa.PersistenceProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import static org.eclipse.persistence.config.PersistenceUnitProperties.*;
import org.eclipse.persistence.config.TargetServer;
import javax.persistence.spi.PersistenceUnitTransactionType;

import java.net.URL;
import java.net.URLClassLoader;


import org.eclipse.persistence.internal.jpa.deployment.JPAInitializer;

public class Tester{


  public void printCP(URLClassLoader cl){
    System.out.println("All URLs is...");
    for (URL u : cl.getURLs()){
      System.out.println("  * "+ u);
    }  
  }

  private void testClass(String className, ClassLoader cl){
    System.out.println("finding "+ className + " ....");
    try{
      Class cz = cl.loadClass(className);    
      System.out.println("finded " + cz);
    }catch(ClassNotFoundException cnf){
      System.out.println("ClassNotFoundException!");
    }
  }

  

  public void saveBook(Book book){


/*
    Map properties = new HashMap();
    // Ensure that no server-platform is configured
    properties.put(TARGET_SERVER, TargetServer.None);
    properties.put(LOGGING_LEVEL, "FINEST");
    properties.put(TRANSACTION_TYPE, PersistenceUnitTransactionType.RESOURCE_LOCAL.name());

  properties.put(JDBC_DRIVER, "org.apache.derby.jdbc.ClientDriver");
  properties.put(JDBC_URL, "jdbc:derby://localhost:1527/chapter04DB;create=true");
  properties.put(JDBC_USER, "APP");
  properties.put(JDBC_PASSWORD, "APP");

  // properties.put(JDBC_DRIVER, "oracle.jdbc.OracleDriver");
  // properties.put(JDBC_URL, "jdbc:oracle:thin:@localhost:1521:ORCL");
  // properties.put(JDBC_USER, "scott");
  // properties.put(JDBC_PASSWORD, "tiger");

  properties.put(LOGGING_LEVEL, "FINE");
  properties.put(LOGGING_TIMESTAMP, "false");
  properties.put(LOGGING_THREAD, "false");
  properties.put(LOGGING_SESSION, "false");

  // Ensure that no server-platform is configured
  properties.put(TARGET_SERVER, TargetServer.None);

  /*
    PersistenceProvider pp = new PersistenceProvider();
    pp.getClassLoader("chapter04PU", properties);
    System.out.println("PP = " + pp);
    System.out.println("CL = " + pp.getClassLoader("chapter04PU", new HashMap()));
 */
    System.out.println("Thread:" + getClass() + " ClassLoader:" + getClass().getClassLoader());
    //System.out.println("Thread CL:" + Thread.currentThread().setContextClassLoader(getClass().getClassLoader()));

     PersistenceProvider pp = new PersistenceProvider();
     
     JPAInitializer initializer = pp.getInitializer("chapter04PU", new HashMap());
    // System.out.println("PP classloader = " + pp.getClassLoader("chapter04PU", new HashMap()));

    //URL url = null;

    // URLClassLoader cl = ( URLClassLoader) pp.getClassLoader("chapter04PU", new HashMap());
    ClassLoader cl = getClass().getClassLoader();

    
    testClass("org.eclipse.persistence.jpa.PersistenceProvider",cl);    
    testClass("org.eclipse.persistence.config.TargetServer", cl);    
    testClass("ru.unclediga.book.jpa.ch04.Book", cl);    


    EntityManagerFactory emf = null;
    try{
      emf = Persistence.createEntityManagerFactory("chapter04PU");
      if( emf == null ){
        System.out.print("\nEMF -> ========= emf = null ==========");
        return;
      }else{
        System.out.print("\nEMF ->  ============= All Good!!! ================\n");
      }
    }catch(Exception e){
      System.err.print("\nEMF -> ========== E R R O R ===========!!!\n");
      e.printStackTrace();
      return;
    }

    /*
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.persist(book);
    tx.commit();

    List res = em.createNamedQuery("findBookH2G2", Book.class).getResultList();
    for(Object b : res){

        Book bo = (Book)b;
    //book = getSingleResult();

       System.out.println("######### " + bo);
    };   

    em.close();
    */
    emf.close();
    
  }
}    
