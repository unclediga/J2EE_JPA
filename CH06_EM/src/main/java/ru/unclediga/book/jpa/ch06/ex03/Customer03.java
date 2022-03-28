package ru.unclediga.book.jpa.ch06.ex03;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "ex03_customer")
public class Customer03 {

  @Id
  @GeneratedValue
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private Integer age;
  @OneToOne(fetch = FetchType.LAZY, cascade = {PERSIST, REMOVE})
  @JoinColumn(name = "address_fk")
  private Address03 address;


  public Customer03() {
  }

  public Customer03(String firstName, String lastName, String email, String phoneNumber, Address03 address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.address = address;
  }

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

  public Address03 getAddress() {
    return address;
  }

  public void setAddress(Address03 address) {
    this.address = address;
  }

  public String toString(){
    return "Cust[" + id + "]:FN["+ firstName +"] age[" + age + "] addr:[" + address + "]"; 
  }
}
