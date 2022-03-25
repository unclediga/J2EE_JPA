package ru.unclediga.book.jpa.ch05.ex45;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ex45_order_line")
public class OrderLine45 {

  @Id
  @GeneratedValue
  private Long id;
  private String item;
  private Double unitPrice;
  private Integer quantity;

  public OrderLine45() {
  }

  public OrderLine45(String item, Double unitPrice, Integer quantity) {
    this.item = item;
    this.unitPrice = unitPrice;
    this.quantity = quantity;
  }

  public Long getId() {
    return id;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public Double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}