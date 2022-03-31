package ru.unclediga.book.jpa.ch06.ex42;

import javax.persistence.*;

@Entity
@EntityListeners(CustomerListener.class)
public class Customer42 extends Person42 {

  private String email;
  @Transient
  private Integer age;
  private Integer birthYear;
  private Integer nowYear;


  public Customer42() {
  }

  public Customer42(String firstName, String lastName, String email, Integer birthYear, Integer nowYear) {
    super(firstName, lastName);
    this.email = email;
    this.birthYear = birthYear;
    this.nowYear = nowYear;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Integer getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(Integer birthYear) {
    this.birthYear = birthYear;
  }

  public Integer getNowYear() {
    return nowYear;
  }

  public void setNowYear(Integer nowYear) {
    this.nowYear = nowYear;
  }

  public String toString(){
    return "Cust[" + getId() + "]:FN["+ getFirstName() +"] age[" + age + "]"; 
  }
}
