package ru.unclediga.book.jpa.ch06.ex21;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "ex21_customer")
@NamedQueries({
  @NamedQuery(name = "findAll", query = "SELECT c FROM Customer21 c" ),
  @NamedQuery(name = Customer21.FIND_ALL, query = "SELECT c FROM Customer21 c" ),
  @NamedQuery(name = "withPositionParams", query = "SELECT c FROM Customer21 c WHERE c.address.country = ?1 AND c.phoneNumber LIKE ?2" ),
  @NamedQuery(name = "withNamedParams", query = "SELECT c FROM Customer21 c WHERE c.address.country = :country AND c.phoneNumber LIKE :num" ),
  @NamedQuery(name = "ordered", query = "SELECT c FROM Customer21 c ORDER BY c.address.country,c.firstName" ),
})
public class Customer21 {

  // Queries
  public static final String FIND_ALL = "findAll2";

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
  private Address21 address;


  public Customer21() {
  }

  public Customer21(String firstName, String lastName, String email, String phoneNumber, Address21 address) {
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

  public Address21 getAddress() {
    return address;
  }

  public void setAddress(Address21 address) {
    this.address = address;
  }

  public String toString(){
    return "Cust[" + id + "]:FN["+ firstName +"] age[" + age + "] addr:[" + address + "]"; 
  }
}
