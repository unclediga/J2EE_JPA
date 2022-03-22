package ru.unclediga.book.jpa.ch05.ex06;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.IdClass;
import javax.persistence.Id;


@Entity
@Table(name = "ex06_news")
@IdClass(NewsId.class)
public class News06 {

  @Id
  private String title;
  @Id
  private String language;

  private String content;

  public News06() {
  }

  public News06(String title, String language, String content) {
    this.title = title;
    this.language = language;
    this.content = content;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}