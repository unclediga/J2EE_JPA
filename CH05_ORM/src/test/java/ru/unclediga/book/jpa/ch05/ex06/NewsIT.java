package ru.unclediga.book.jpa.ch05.ex06;

import ru.unclediga.book.jpa.ch05.AbstractPersistenceTest;

import org.junit.Test;
import static org.junit.Assert.*;

public class NewsIT extends AbstractPersistenceTest{
  @Test
  public void shouldCreateANews() throws Exception {

    NewsId key = new NewsId("My news", "RU");
    News06 news = new News06("My news", "RU", "Супер бук!");

    tx.begin();
    em.persist(news);
    tx.commit();

    News06 news2 = em.find(News06.class, key);

    assertEquals("Супер бук!", news2.getContent());
  }  
}
