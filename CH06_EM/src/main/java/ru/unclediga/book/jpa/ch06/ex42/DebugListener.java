package ru.unclediga.book.jpa.ch06.ex42;

import javax.persistence.*;

public class DebugListener {

  @PrePersist
  void onPrePersist(Object object) {
      System.out.println(".onPrePersist()");
  }

  @PostPersist
  void onPostPersist(Object object) {
      System.out.println(".onPostPersist()");
  }

  @PostLoad
  void onPostLoad(Object object) {
      System.out.println(".onPostLoad()");
  }

  @PreUpdate
  void onPreUpdate(Object object) {
      System.out.println(".onPreUpdate()");
  }

  @PostUpdate
  void onPostUpdate(Object object) {
      System.out.println(".onPostUpdate()");
  }

  @PreRemove
  void onPreRemove(Object object) {
      System.out.println(".onPreRemove()");
  }

  @PostRemove
  void onPostRemove(Object object) {
      System.out.println(".onPostRemove()");
  }
}