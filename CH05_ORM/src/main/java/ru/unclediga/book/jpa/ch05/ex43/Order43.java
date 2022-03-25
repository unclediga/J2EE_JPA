package ru.unclediga.book.jpa.ch05.ex43;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ex43_order")
public class Order43 {

  @Id
  @GeneratedValue
  private Long id;
  @Temporal(TemporalType.TIMESTAMP)
  private Date creationDate;
  @OneToMany
  @JoinTable(
    name = "ex43_link_ord_ordline",
    joinColumns = @JoinColumn(name="ordline_id"),
    inverseJoinColumns = @JoinColumn(name="ord_id"))

  private List<OrderLine43> orderLines;

  public Order43() {
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

  public List<OrderLine43> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(List<OrderLine43> orderLines) {
    this.orderLines = orderLines;
  }
}