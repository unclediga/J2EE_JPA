package ru.unclediga.book.jpa.ch04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;

public class Main{
  public static void main(String[] args){


    Book book = new Book("H2G2", "Автостопом по Галактике", 12.5F, "1-84023-742-2", 354, false);
    System.out.println(book);


    //new Tester().saveBook(book); 


    /*  EclipseLink 2.6 don't work with code from MAVEN ->  mvn exec:java

Local Exception Stack:
Exception [EclipseLink-30005] (Eclipse Persistence Services - 2.6.2.v20151217-774c696): org.eclipse.persistence.exceptions.PersistenceUnitLoadingException
Exception Description: An exception was thrown while searching for persistence archives with ClassLoader: java.net.URLClassLoader@422b8438
Internal Exception: java.lang.NullPointerException
        at org.eclipse.persistence.exceptions.PersistenceUnitLoadingException.exceptionSearchingForPersistenceResources(PersistenceUnitLoadingException.java:127)
        at org.eclipse.persistence.jpa.PersistenceProvider.createEntityManagerFactoryImpl(PersistenceProvider.java:115)
        at org.eclipse.persistence.jpa.PersistenceProvider.createEntityManagerFactory(PersistenceProvider.java:188)
        at javax.persistence.Persistence.createEntityManagerFactory(Persistence.java:79)
        at javax.persistence.Persistence.createEntityManagerFactory(Persistence.java:54)
        at ru.unclediga.book.jpa.ch04.Tester.saveBook(Tester.java:100)
        at ru.unclediga.book.jpa.ch04.Main.main(Main.java:11)
        at org.codehaus.mojo.exec.ExecJavaMojo$1.run(ExecJavaMojo.java:254)    
    */ 
    
     /*  EclipseLink 2.7 work fine!  */

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PU");    
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.persist(book);
    tx.commit();

    List res = em.createNamedQuery("findBookH2G2", Book.class).getResultList();
    //book = getSingleResult();
    for(Object b : res){
      Book bo = (Book)b;
      System.out.println("######### " + bo);
    };   

    em.close();
    emf.close();
  }
}