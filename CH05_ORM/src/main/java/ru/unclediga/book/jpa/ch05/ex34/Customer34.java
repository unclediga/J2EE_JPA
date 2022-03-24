package ru.unclediga.book.jpa.ch05.ex34;

import javax.persistence.*;

@Entity
@Table(name = "ex34_customer")
@Access(AccessType.PROPERTY)
public class Customer34 {

  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private Integer age;
  private Address34 address;


  public Customer34() {
  }

  public Customer34(String firstName, String lastName, String email, String phoneNumber, Address34 address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.address = address;
  }

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

   public void setId(Long id) {
     this.id = id;
   }

  @Column(name = "first_name", nullable = false, length = 50)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Column(name = "last_name", nullable = false, length = 50)
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

  @Column(name = "phone_number", length = 15)
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  @Transient
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Address34 getAddress() {
    return address;
  }

  public void setAddress(Address34 address) {
    this.address = address;
  }
}
