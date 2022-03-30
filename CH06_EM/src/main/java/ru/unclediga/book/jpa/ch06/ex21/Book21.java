package ru.unclediga.book.jpa.ch06.ex21;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="ex21_book")
@NamedQuery(name = "Book21.findAll", query = "SELECT b FROM Book21 b")
// @NamedQuery(name = "findAll", query = "SELECT b FROM Book21 b")
// Exception Description: Predeployment of PersistenceUnit [chapter06PUTest] failed.
// Internal Exception: Exception [EclipseLink-7299] org.eclipse.persistence.exceptions.ValidationException
// Exception Description: Conflicting annotations with the same name [findAll] were found. 
// The first one [@javax.persistence.NamedQuery({query=SELECT b FROM Book21 b, name=findAll})] was found 
// within [class ru.unclediga.book.jpa.ch06.ex21.Book21] 
// and the second [@javax.persistence.NamedQuery({query=SELECT c FROM Customer21 c, name=findAll})] was found 
// within [class ru.unclediga.book.jpa.ch06.ex21.Customer21]. 
// Named annotations must be unique across the persistence unit.

public class Book21 {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private Float price;
  private String description;
  private String isbn;
  private Integer nbOfPage;
  private Boolean illustrations;

  public Book21() {
  }

  public Book21(String title, String description, Float price, String isbn, Integer nbOfPage, Boolean illustrations) {
    this.title = title;
    this.price = price;
    this.description = description;
    this.isbn = isbn;
    this.nbOfPage = nbOfPage;
    this.illustrations = illustrations;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Integer getNbOfPage() {
    return nbOfPage;
  }

  public void setNbOfPage(Integer nbOfPage) {
    this.nbOfPage = nbOfPage;
  }

  public Boolean getIllustrations() {
    return illustrations;
  }

  public void setIllustrations(Boolean illustrations) {
    this.illustrations = illustrations;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Book11");
    sb.append("{id=").append(id);
    sb.append(", title='").append(title).append('\'');
    sb.append(", price=").append(price);
    sb.append(", description='").append(description).append('\'');
    sb.append(", isbn='").append(isbn).append('\'');
    sb.append(", nbOfPage=").append(nbOfPage);
    sb.append(", illustrations=").append(illustrations);
    sb.append('}');
    return sb.toString();
  }
}