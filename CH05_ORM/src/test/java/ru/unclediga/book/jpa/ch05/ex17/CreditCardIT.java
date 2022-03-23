package ru.unclediga.book.jpa.ch05.ex17;

import ru.unclediga.book.jpa.ch05.AbstractPersistenceTest;

import static org.junit.Assert.*;
import org.junit.Test;


public class CreditCardIT extends AbstractPersistenceTest{

  @Test
  public void t1(){
    
    CreditCard cc = new CreditCard("111222333444555", "01/23", 605, CreditCardType.MIR, ChipType.NFC);

    tx.begin();
    em.persist(cc);
    tx.commit();

    tx.begin();
    CreditCard cc2 = em.find(CreditCard.class, cc.getNumber());
    tx.commit();

    assertNotNull(cc2.getNumber());
  }
  
}