package org.agoncal.fascicle.quarkus.observability.metrics.application;

import java.math.BigDecimal;
import java.net.URL;

public class Book {

  public Long id;
  public String title;
  public String isbn13;
  public String isbn10;
  public String author;
  public Integer yearOfPublication;
  public Integer nbOfPages;
  public Integer rank;
  public BigDecimal price;
  public URL smallImageUrl;
  public URL mediumImageUrl;
  public String description;

  public static Book findRandom() {
    return null;
  }
}
