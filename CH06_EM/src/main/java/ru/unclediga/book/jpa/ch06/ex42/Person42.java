package ru.unclediga.book.jpa.ch06.ex42;

import javax.persistence.*;

@Entity
@Table(name = "ex42_person")
public class Person42 {

  @Id
  @GeneratedValue
  protected Long id;
  protected String firstName;
  protected String lastName;

  public Person42() {
  }

  public Person42(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
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


  public String toString(){
    return "Pers[" + id + "]:FN["+ firstName +"] LN[" + lastName + "]"; 
  }
}
