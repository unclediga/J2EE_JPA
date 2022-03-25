package ru.unclediga.book.jpa.ch05.ex45;

import ru.unclediga.book.jpa.ch05.AbstractPersistenceTest;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class Order45IT extends AbstractPersistenceTest {

/*


[EL Fine]: sql:--CREATE TABLE ex45_order (ID BIGINT NOT NULL, CREATIONDATE TIMESTAMP, PRIMARY KEY (ID))
[EL Fine]: sql:--CREATE TABLE ex45_order_line (ID BIGINT NOT NULL, ITEM VARCHAR(255), QUANTITY INTEGER, UNITPRICE FLOAT, ordline_id BIGINT, PRIMARY KEY (ID))
[EL Fine]: sql:--ALTER TABLE ex45_order_line ADD CONSTRAINT x45rderlinerdlneid FOREIGN KEY (ordline_id) REFERENCES ex45_order (ID)
[EL Fine]: sql:--INSERT INTO ex45_order (ID, CREATIONDATE) VALUES (?, ?)
  bind => [3, 2022-03-25 14:21:20.751]
[EL Fine]: sql:--INSERT INTO ex45_order_line (ID, ITEM, QUANTITY, UNITPRICE) VALUES (?, ?, ?, ?)
  bind => [1, H2G2, 1000, 25.5]
[EL Fine]: sql:--INSERT INTO ex45_order_line (ID, ITEM, QUANTITY, UNITPRICE) VALUES (?, ?, ?, ?)
  bind => [2, Кино, 1000, 35.5]
[EL Fine]: sql:--UPDATE ex45_order_line SET ordline_id = ? WHERE (ID = ?)
  bind => [3, 1]
[EL Fine]: sql:--UPDATE ex45_order_line SET ordline_id = ? WHERE (ID = ?)
  bind => [3, 2]


*/


  @Test
  public void t1(){
    Order45 order = new Order45();
    OrderLine45 itm1 = new OrderLine45("H2G2", 25.5, 1000);
    OrderLine45 itm2 = new OrderLine45("Кино", 35.5, 1000);
    List<OrderLine45> itms = new ArrayList<>();
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

    Order45 order2 = em.find(Order45.class, order.getId());
    itms = order2.getOrderLines();
    assertNotNull(itms);
    assertEquals(2,itms.size());
  }
}