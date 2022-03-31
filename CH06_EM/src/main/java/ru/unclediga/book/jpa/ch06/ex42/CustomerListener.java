package ru.unclediga.book.jpa.ch06.ex42;

import javax.persistence.*;

public class CustomerListener {

  @PrePersist
  void onPrePersist(Customer42 customer) {
      System.out.println(customer + " => onPrePersist()");
  }

  @PostPersist
  void onPostPersist(Customer42 customer) {
      System.out.println(customer + " => onPostPersist()");
  }

  @PostLoad
  void onPostLoad(Customer42 customer) {
      System.out.println(customer + " => onPostLoad()");
  }

  @PreUpdate
  void onPreUpdate(Customer42 customer) {
      System.out.println(customer + " => onPreUpdate()");
  }

  @PostUpdate
  void onPostUpdate(Customer42 customer) {
      System.out.println(customer + " => onPostUpdate()");
  }

  @PreRemove
  void onPreRemove(Customer42 customer) {
      System.out.println(customer + " => onPreRemove()");
  }

  @PostRemove
  void onPostRemove(Customer42 customer) {
      System.out.println(customer + " => onPostRemove()");
  }
}