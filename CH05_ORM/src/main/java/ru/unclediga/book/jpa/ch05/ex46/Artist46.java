package ru.unclediga.book.jpa.ch05.ex46;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ex46_artist")
public class Artist46 {

  @Id
  @GeneratedValue
  private Long id;
  private String firstName;
  private String lastName;
  private List<CD46> appearsOnCDs;

  public Artist46() {
  }

  public Artist46(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
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

  public List<CD46> getAppearsOnCDs() {
    return appearsOnCDs;
  }

  public void setAppearsOnCDs(List<CD46> appearsOnCDs) {
    this.appearsOnCDs = appearsOnCDs;
  }

  public void appearsOn(CD46 cd) {
    if (appearsOnCDs == null)
      appearsOnCDs = new ArrayList<CD46>();
    appearsOnCDs.add(cd);
  }

}