package ru.unclediga.book.jpa.ch06.ex38;

import javax.persistence.*;

@Entity
@Table(name = "ex38_customer")
public class Customer38 {

  @Id
  @GeneratedValue
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  @Transient
  private Integer age;
  private Integer birthYear;
  private Integer nowYear;


  public Customer38() {
  }

  public Customer38(String firstName, String lastName, String email, Integer birthYear, Integer nowYear) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.birthYear = birthYear;
    this.nowYear = nowYear;
  }

  @PostLoad
  @PostUpdate
  @PostPersist
  public void calcAge() {
    System.out.println("===> IN calcAge() Age=" + age);
    if(nowYear == null || nowYear.intValue() < 0){
      age = null;
    } else if (birthYear == null || birthYear.intValue() < 0) {
      age = null;
    } else {
      age = nowYear.intValue() - birthYear.intValue();
    }  
    System.out.println("===> OUT calcAge() Age=" + age);
  }

  public Long getId() {
    return id;
  }

   public void setId(Long id) {
     this.id = id;
   }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
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
    return "Cust[" + id + "]:FN["+ firstName +"] age[" + age + "]"; 
  }
}
