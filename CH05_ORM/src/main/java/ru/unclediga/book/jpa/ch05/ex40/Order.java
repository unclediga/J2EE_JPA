package ru.unclediga.book.jpa.ch05.ex40;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ex40_order")
public class Order {

  @Id
  @GeneratedValue
  private Long id;
  @Temporal(TemporalType.TIMESTAMP)
  private Date creationDate;
  private List<OrderLine> orderLines;

  public Order() {
    this.creationDate = new Date();
  }

  public Long getId() {
    return id;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public List<OrderLine> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(List<OrderLine> orderLines) {
    this.orderLines = orderLines;
  }
}