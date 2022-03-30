package ru.unclediga.book.jpa.ch06.ex24;

import javax.persistence.*;

@Entity
@Table(name = "ex24_address")
public class Address24 {
  @Id
  @GeneratedValue
  private Long id;
  private String street;
  private String city;
  private String zipcode;
  private String country;

  public Address24() { }

  public Address24(String street, String city, String zipcode, String country) {
    this.street = street;
    this.city = city;
    this.zipcode = zipcode;
    this.country = country;
  }

  public Long getId() {
    return id;
  }

   public void setId(Long id) {
     this.id = id;
   }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String toString(){
    return "Addr[" + getId() + "]:City["+ city +"]"; 
  }
}
  
