package ru.unclediga.book.jpa.ch05.ex49;

import ru.unclediga.book.jpa.ch05.AbstractPersistenceTest;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class News49IT extends AbstractPersistenceTest {

  @Test
  public void t1(){

    News49 n1 = new News49("News 1");
    Comment49 c11 = new Comment49("gonzo", "Uraaa!", 1, "2022-01-01");
    Comment49 c12 = new Comment49("rogue", "Yesss!", 2, "2022-02-01");
    Comment49 c13 = new Comment49("gonzo", "Uray!",  3, "2022-01-20");

    n1.addComment(c11);
    n1.addComment(c12);
    n1.addComment(c13);

    News49 n2 = new News49("News 2");
    Comment49 c21 = new Comment49("torro", "U!", 1, "2022-01-01");
    Comment49 c22 = new Comment49("morro", "Y!", 2, "2022-02-01");
    Comment49 c23 = new Comment49("morro", "M!", 3, "2022-03-01");
    n2.addComment(c21);
    n2.addComment(c22);
    n2.addComment(c23);

    tx.begin();
    em.persist(n1);
    em.persist(n2);
    // em.persist(c11);
    // em.persist(c12);
    // em.persist(c13);
    // em.persist(c21);
    // em.persist(c22);
    // em.persist(c23);
    tx.commit();

     // Without the refresh the test will not work
    // The OrderBy annotation specifies the ordering of the elements of a collection valued association at the point when the association is retrieved."
    // The key here is the phrase "when the association is retrieved".  In this case, when your find is executed, the association is still managed and no retrieval logic occurs.
   em.refresh(n1);
   em.refresh(n2);

   assertNotNull(n1.getId());
   assertNotNull(n2.getId());


    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");


    System.out.println("------------- n1 -------------");
    for(Comment49 c : n1.getComments()){
      System.out.println("n1:" + df.format(c.getPostedDate()));
    }
    System.out.println("------------- n2 -------------");
    for(Comment49 c : n2.getComments()){
      System.out.println("n2:" + df.format(c.getPostedDate()));
    }

    assertEquals(2,n1.getComments().get(0).getNote().intValue());
    assertEquals(3,n2.getComments().get(0).getNote().intValue());
  }
}