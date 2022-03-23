package ru.unclediga.book.jpa.ch05.ex17;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ex17_creditcard")
public class CreditCard {

  @Id
  private String number;
  private String expiryDate;
  private Integer controlNumber;
  @Enumerated(EnumType.STRING)
  private CreditCardType creditCardType;
//  @Enumerated(EnumType.ORDINAL)
  @Enumerated
  private ChipType chipType;

  public CreditCard() {
  }

  public CreditCard(String number, String expiryDate, Integer controlNumber, CreditCardType creditCardType, ChipType chipType) {
    this.number = number;
    this.expiryDate = expiryDate;
    this.controlNumber = controlNumber;
    this.creditCardType = creditCardType;
    this.chipType = chipType;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }

  public Integer getControlNumber() {
    return controlNumber;
  }

  public void setControlNumber(Integer controlNumber) {
    this.controlNumber = controlNumber;
  }

  public CreditCardType getType() {
    return creditCardType;
  }

  public void setType(CreditCardType creditCardType) {
    this.creditCardType = creditCardType;
  }

  public ChipType getChipType() {
    return chipType;
  }

  public void setChipType(ChipType chipType) {
    this.chipType = chipType;
  }
}
