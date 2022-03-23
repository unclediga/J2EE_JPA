package ru.unclediga.book.jpa.ch05.ex23;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="ex23_book")
public class Book23 {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name="book_title", nullable = false, updatable = false)
  private String title;
  private Float price;
  @Column(length = 2000)
  private String description;
  private String isbn;
  @Column(name="nb_of_page", nullable = false)
  private Integer nbOfPage;
  private Boolean illustrations;
  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name="tag")
  @Column(name="Value")
  private List<String> tags;

  public Book23() {
  }

  public Book23(String title, String description, Float price, String isbn, Integer nbOfPage, Boolean illustrations, List tags) {
    this.title = title;
    this.price = price;
    this.description = description;
    this.isbn = isbn;
    this.nbOfPage = nbOfPage;
    this.illustrations = illustrations;
    this.tags = tags;
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

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
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
    sb.append(", tags=").append(tags);
    sb.append('}');
    return sb.toString();
  }
}