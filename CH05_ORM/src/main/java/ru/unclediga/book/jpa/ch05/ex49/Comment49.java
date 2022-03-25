package ru.unclediga.book.jpa.ch05.ex49;

import javax.persistence.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

@Entity
@Table(name = "ex49_comment")
public class Comment49 {

  @Id
  @GeneratedValue
  private Long id;
  private String nickname;
  private String content;
  private Integer note;
  @Column(name = "posted_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date postedDate;


  public Comment49() {
  }

  public Comment49(String nickname, String content, Integer note, String postedDate) {
    this.nickname = nickname;
    this.content = content;
    this.note = note;

    try {
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      this.postedDate = df.parse(postedDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  public Long getId() {
    return id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Integer getNote() {
    return note;
  }

  public void setNote(Integer note) {
    this.note = note;
  }

  public Date getPostedDate(){
    return postedDate;
  }

  public void setPostedDate(Date postedDate){
    this.postedDate = postedDate;
  }

}