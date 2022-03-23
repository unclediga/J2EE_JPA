package ru.unclediga.book.jpa.ch05.ex24;

import ru.unclediga.book.jpa.ch05.AbstractPersistenceTest;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Map;
import java.util.HashMap;

public class CD_IT extends AbstractPersistenceTest {
   
  @Test
  public void t1(){

    
    Map<Integer, String> tracks = new HashMap<>();
    tracks.put(1,  "Thunderstruck"); 
    tracks.put(2,  "Fire Your Guns" ); 
    tracks.put(3,  "Moneytalks" ); 
    tracks.put(4,  "The Razors Edge"); 
    tracks.put(5,  "Mistress for Christmas" ); 
    tracks.put(6,  "Rock Your Heart Out"); 
    tracks.put(7,  "Are You Ready"); 
    tracks.put(8,  "Got You by the Balls" ); 
    tracks.put(9,  "Shot of Love" ); 
    tracks.put(10, "Let's Make It"); 
    tracks.put(11, "Goodbye & Good Riddance to Bad Luck"); 
    tracks.put(12, "If You Dare");
    CD cd = new CD("The Razors Edge", 25.5f, "Released: 21 September 1990", tracks);

    tx.begin();
    em.persist(cd);
    tx.commit();

    tx.begin();
    CD cd2 = em.find(CD.class, cd.getId());
    tx.commit();

    assertNotNull(cd2.getId());
    assertEquals("Thunderstruck", cd2.getTracks().get(1));
  }
} 