package ru.unclediga.book.jpa.ch06.ex24;

public class CustomerDTO {


  public Long id;
  public String firstName;
  public String lastName;

  public CustomerDTO() {
  }

  public CustomerDTO(Long id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}  
