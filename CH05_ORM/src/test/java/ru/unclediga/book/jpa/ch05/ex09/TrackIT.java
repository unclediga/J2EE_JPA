package ru.unclediga.book.jpa.ch05.ex09;

import ru.unclediga.book.jpa.ch05.AbstractPersistenceTest;

import org.junit.Test;
import static org.junit.Assert.*;

public class TrackIT extends AbstractPersistenceTest{
  @Test
  public void shouldCreateATrack() throws Exception {

    final byte[] testArray = new byte[]{'a','b','c'};

    Track track = new Track("Music",2.30f, "Super music");
    track.setWav(testArray);

    tx.begin();
    em.persist(track);
    tx.commit();

    

    Track track2 = em.find(Track.class, track.getId());

    assertNotNull(track2.getWav());
    assertEquals(3,track2.getWav().length);
    assertArrayEquals(testArray, track2.getWav());
  }  

}
