package ru.unclediga.book.jpa.ch06.ex39;

import javax.persistence.PreUpdate;
import javax.persistence.PrePersist;

public class NameValidateListener{

  @PreUpdate
  @PrePersist
  public void validate(Customer39 customer) {
    if(customer.getFirstName() == null || customer.getFirstName().equals("")){
      throw new IllegalArgumentException("first name is empty!");
    }
    if(customer.getLastName() == null || customer.getLastName().equals("")){
      throw new IllegalArgumentException("first name is empty!");
    }
  }
}