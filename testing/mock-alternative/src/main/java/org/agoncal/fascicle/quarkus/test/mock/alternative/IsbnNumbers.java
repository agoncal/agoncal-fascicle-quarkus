package org.agoncal.fascicle.quarkus.test.mock.alternative;

import javax.json.bind.annotation.JsonbProperty;

public class IsbnNumbers {

  @JsonbProperty("isbn_10")
  private String isbn10;
  @JsonbProperty("isbn_13")
  private String isbn13;

  public String getIsbn10() {
    return isbn10;
  }

  public void setIsbn10(String isbn10) {
    this.isbn10 = isbn10;
  }

  public String getIsbn13() {
    return isbn13;
  }

  public void setIsbn13(String isbn13) {
    this.isbn13 = isbn13;
  }
}
