package ru.unclediga.book.jpa.ch05.ex46;

import ru.unclediga.book.jpa.ch05.AbstractPersistenceTest;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class Artist46IT extends AbstractPersistenceTest {

/*

=== MANY-TO-MANY with @JoinTable =================

[EL Fine]: sql:--CREATE TABLE link_artist_cd (artist_id BIGINT NOT NULL, cd_id BIGINT NOT NULL, PRIMARY KEY (artist_id, cd_id))
[EL Fine]: sql:--ALTER TABLE link_artist_cd ADD CONSTRAINT linkartist_cdcd_id FOREIGN KEY (cd_id) REFERENCES ex46_cd (ID)
[EL Fine]: sql:--ALTER TABLE link_artist_cd ADD CONSTRAINT lnkartistcdrtistid FOREIGN KEY (artist_id) REFERENCES ex46_artist (ID)
[EL Fine]: sql:--CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(15), PRIMARY KEY (SEQ_NAME))
[EL Fine]: sql:--SELECT * FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
[EL Fine]: sql:--INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
[EL Fine]: sql:--UPDATE SEQUENCE SET SEQ_COUNT = SEQ_COUNT + ? WHERE SEQ_NAME = ?
  bind => [50, SEQ_GEN]
[EL Fine]: sql: --SELECT SEQ_COUNT FROM SEQUENCE WHERE SEQ_NAME = ?
  bind => [SEQ_GEN]
[EL Fine]: sql: --INSERT INTO ex46_artist (ID, FIRSTNAME, LASTNAME) VALUES (?, ?, ?)
  bind => [3, C3, CCC]
[EL Fine]: sql: --INSERT INTO ex46_artist (ID, FIRSTNAME, LASTNAME) VALUES (?, ?, ?)
  bind => [2, B2, BBB]
[EL Fine]: sql: --INSERT INTO ex46_artist (ID, FIRSTNAME, LASTNAME) VALUES (?, ?, ?)
  bind => [1, A1, AAA]
[EL Fine]: sql:--INSERT INTO ex46_cd (ID, DESCRIPTION, PRICE, TITLE) VALUES (?, ?, ?, ?)
  bind => [8, All about cd5, 25.5, cd5]
[EL Fine]: sql:--INSERT INTO ex46_cd (ID, DESCRIPTION, PRICE, TITLE) VALUES (?, ?, ?, ?)
  bind => [4, All about cd1, 21.5, cd1]
[EL Fine]: sql:--INSERT INTO ex46_cd (ID, DESCRIPTION, PRICE, TITLE) VALUES (?, ?, ?, ?)
  bind => [6, All about cd3, 23.5, cd3]
[EL Fine]: sql:--INSERT INTO ex46_cd (ID, DESCRIPTION, PRICE, TITLE) VALUES (?, ?, ?, ?)
  bind => [5, All about cd2, 22.5, cd2]
[EL Fine]: sql:--INSERT INTO ex46_cd (ID, DESCRIPTION, PRICE, TITLE) VALUES (?, ?, ?, ?)
  bind => [7, All about cd4, 24.5, cd4]
[EL Fine]: sql:--INSERT INTO link_artist_cd (cd_id, artist_id) VALUES (?, ?)
  bind => [8, 3]
[EL Fine]: sql:--INSERT INTO link_artist_cd (cd_id, artist_id) VALUES (?, ?)
  bind => [5, 2]
[EL Fine]: sql:--INSERT INTO link_artist_cd (cd_id, artist_id) VALUES (?, ?)
  bind => [6, 2]
[EL Fine]: sql:--INSERT INTO link_artist_cd (cd_id, artist_id) VALUES (?, ?)
  bind => [7, 2]
[EL Fine]: sql:--INSERT INTO link_artist_cd (cd_id, artist_id) VALUES (?, ?)
  bind => [4, 1]
[EL Fine]: sql:--INSERT INTO link_artist_cd (cd_id, artist_id) VALUES (?, ?)
  bind => [5, 1]
[EL Fine]: sql:--INSERT INTO link_artist_cd (cd_id, artist_id) VALUES (?, ?)
  bind => [6, 1]
[EL Fine]: sql:--INSERT INTO link_artist_cd (cd_id, artist_id) VALUES (?, ?)
  bind => [7, 1]
[EL Fine]: sql:--INSERT INTO link_artist_cd (cd_id, artist_id) VALUES (?, ?)
  bind => [8, 1]

*/




  @Test
  public void t1(){

    Artist46 a1 = new Artist46("A1", "AAA");
    Artist46 a2 = new Artist46("B2", "BBB");
    Artist46 a3 = new Artist46("C3", "CCC");
    
    CD46 cd_I   = new CD46("cd1",21.5f, "All about cd1");
    CD46 cd_II  = new CD46("cd2",22.5f, "All about cd2");
    CD46 cd_III = new CD46("cd3",23.5f, "All about cd3");
    CD46 cd_IV  = new CD46("cd4",24.5f, "All about cd4");
    CD46 cd_V   = new CD46("cd5",25.5f, "All about cd5");

    a1.appearsOn(cd_I);
    a1.appearsOn(cd_II);
    a1.appearsOn(cd_III);
    a1.appearsOn(cd_IV);
    a1.appearsOn(cd_V);

    a2.appearsOn(cd_II);
    a2.appearsOn(cd_III);
    a2.appearsOn(cd_IV);

    a3.appearsOn(cd_V);
    
    cd_I.createdBy(a1);
    cd_V.createdBy(a3);


    tx.begin();
    em.persist(a1);
    em.persist(a2);
    em.persist(a3);
    em.persist(cd_I);
    em.persist(cd_II);
    em.persist(cd_III);
    em.persist(cd_IV);
    em.persist(cd_V);
    tx.commit();

    assertNotNull(a1.getId());
    assertNotNull(a2.getId());
    assertNotNull(a3.getId());

    assertEquals(5,a1.getAppearsOnCDs().size());
    assertEquals(3,a2.getAppearsOnCDs().size());
    assertEquals(1,a3.getAppearsOnCDs().size());
  }
}