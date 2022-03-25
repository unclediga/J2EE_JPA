package ru.unclediga.book.jpa.ch05.ex43;

import ru.unclediga.book.jpa.ch05.AbstractPersistenceTest;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class Order43IT extends AbstractPersistenceTest {

  /*




[EL Fine]: sql: --CREATE TABLE ex40_order (ID BIGINT NOT NULL, CREATIONDATE TIMESTAMP, PRIMARY KEY (ID))
[EL Fine]: sql: --CREATE TABLE ex40_order_line (ID BIGINT NOT NULL, ITEM VARCHAR(255), QUANTITY INTEGER, UNITPRICE FLOAT, PRIMARY KEY (ID))
[EL Fine]: sql: --CREATE TABLE ex43_link_ord_ordline (ordline_id BIGINT NOT NULL, ord_id BIGINT NOT NULL, PRIMARY KEY (ordline_id, ord_id))
[EL Fine]: sql:--ALTER TABLE ex43_link_ord_ordline ADD CONSTRAINT x43lnkrdordlinerdd FOREIGN KEY (ord_id) REFERENCES ex43_order_line (ID)
[EL Fine]: sql:--ALTER TABLE ex43_link_ord_ordline ADD CONSTRAINT x43lnkrdrdlnerdlnd FOREIGN KEY (ordline_id) REFERENCES ex43_order (ID)
[EL Fine]: sql: --CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(15), PRIMARY KEY (SEQ_NAME))
[EL Fine]: sql: --SELECT * FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
[EL Fine]: sql: --INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
[EL Fine]: sql: --UPDATE SEQUENCE SET SEQ_COUNT = SEQ_COUNT + ? WHERE SEQ_NAME = ?
  bind => [50, SEQ_GEN]
[EL Fine]: sql:--SELECT SEQ_COUNT FROM SEQUENCE WHERE SEQ_NAME = ?
  bind => [SEQ_GEN]
[EL Fine]: sql:--INSERT INTO ex40_order (ID, CREATIONDATE) VALUES (?, ?)
  bind => [3, 2022-03-25 13:41:14.95]
[EL Fine]: sql:--INSERT INTO ex40_order_line (ID, ITEM, QUANTITY, UNITPRICE) VALUES (?, ?, ?, ?)
  bind => [2, Кино, 1000, 35.5]
[EL Fine]: sql:--INSERT INTO ex40_order_line (ID, ITEM, QUANTITY, UNITPRICE) VALUES (?, ?, ?, ?)
  bind => [1, H2G2, 1000, 25.5]
[EL Fine]: sql:--INSERT INTO ex43_link_ord_ordline (ord_id, ordline_id) VALUES (?, ?)
  bind => [1, 3]
[EL Fine]: sql:--INSERT INTO ex43_link_ord_ordline (ord_id, ordline_id) VALUES (?, ?)
  bind => [2, 3]

  */



  @Test
  public void t1(){
    Order43 order = new Order43();
    OrderLine43 itm1 = new OrderLine43("H2G2", 25.5, 1000);
    OrderLine43 itm2 = new OrderLine43("Кино", 35.5, 1000);
    List<OrderLine43> itms = new ArrayList<>();
    itms.add(itm1);
    itms.add(itm2);
    order.setOrderLines(itms);
    
    tx.begin();
    em.persist(itm1);
    em.persist(itm2);
    em.persist(order);
    tx.commit();

    assertNotNull(order.getId());
    assertNotNull(itm1.getId());
    assertNotNull(itm2.getId());

    Order43 order2 = em.find(Order43.class, order.getId());
    itms = order2.getOrderLines();
    assertNotNull(itms);
    assertEquals(2,itms.size());
  }
}