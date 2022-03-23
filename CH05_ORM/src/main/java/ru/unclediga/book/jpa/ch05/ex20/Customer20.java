package ru.unclediga.book.jpa.ch05.ex20;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ex20_customer")
public class Customer20 {

  @Id
  @GeneratedValue
  @Access(AccessType.FIELD)
  private Long id;
  @Column(name = "first_name", nullable = false, length = 50)
  private String firstName;
  @Column(name = "last_name", nullable = false, length = 50)
  private String lastName;
  private String email;
  @Column(name = "phone_number", nullable = false, length = 15)
  private String phoneNumber;

  public Customer20() {
  }

  public Customer20(String firstName, String lastName, String email, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  public Long getId() {
    return id;
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
  
  @Access(AccessType.PROPERTY)
  @Column(name = "phone_number", length = 25)
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
