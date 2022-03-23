package ru.unclediga.book.jpa.ch05.ex24;

import javax.persistence.*;

import java.util.Map;
import java.util.HashMap;


@Entity
@Table(name="ex24_cd")
public class CD {

  @Id
  @GeneratedValue
  private Long id;
  private String title;
  private Float price;
  private String description;
  @Lob
  private byte[] cover;
  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name="ex28_track")
  private Map<Integer, String> tracks = new HashMap<>();

  public CD() {
  }

  public CD(String title, Float price, String description, Map<Integer, String> tracks) {
    this.title = title;
    this.price = price;
    this.description = description;
    this.tracks = tracks;
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

  public byte[] getCover() {
    return cover;
  }

  public void setCover(byte[] cover) {
    this.cover = cover;
  }

  public Map<Integer, String> getTracks() {
    return tracks;
  }

  public void setTracks(Map<Integer, String> tracks) {
    this.tracks = tracks;
  }
}