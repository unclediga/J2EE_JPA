package ru.unclediga.book.jpa.ch06.ex39;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class AgeCalcListener {
  @PostLoad
  @PostUpdate
  @PostPersist
  public void calcAge(Customer39 customer) {
    if(customer.getNowYear() == null || customer.getNowYear().intValue() < 0){
      customer.setAge(null);
    } else if (customer.getBirthYear() == null || customer.getBirthYear().intValue() < 0) {
      customer.setAge(null);
    } else {
      customer.setAge(customer.getNowYear().intValue() - customer.getBirthYear().intValue());
    }  
  }
}