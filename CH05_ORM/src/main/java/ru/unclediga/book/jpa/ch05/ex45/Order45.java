package ru.unclediga.book.jpa.ch05.ex45;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ex45_order")
public class Order45 {

  @Id
  @GeneratedValue
  private Long id;
  @Temporal(TemporalType.TIMESTAMP)
  private Date creationDate;
  @OneToMany
  @JoinColumn(name="ordline_id")

  private List<OrderLine45> orderLines;

  public Order45() {
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

  public List<OrderLine45> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(List<OrderLine45> orderLines) {
    this.orderLines = orderLines;
  }
}