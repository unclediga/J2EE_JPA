package ru.unclediga.book.jpa.ch05.ex04;

import ru.unclediga.book.jpa.ch05.AbstractPersistenceTest;

import org.junit.Test;
import static org.junit.Assert.*;

public class NewsIT extends AbstractPersistenceTest{
  @Test
  public void shouldCreateANews() throws Exception {

    NewsId key = new NewsId("My news", "RU");
    News news = new News(key, "Супер бук!");

    tx.begin();
    em.persist(news);
    tx.commit();

    News news2 = em.find(News.class, key);

    assertEquals("Супер бук!", news2.getContent());
  }  

}
