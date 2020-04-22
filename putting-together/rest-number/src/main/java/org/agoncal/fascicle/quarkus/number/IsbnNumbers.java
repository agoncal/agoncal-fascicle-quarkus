package org.agoncal.fascicle.quarkus.number;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;

// tag::adocSnippet[]
@Schema(description = "Several formats of book ISBN numbers")
public class IsbnNumbers {

  @Schema(required = true)
  @JsonbProperty("isbn_10")
  private String isbn10;
  @Schema(required = true)
  @JsonbProperty("isbn_13")
  private String isbn13;

  // tag::adocSkip[]
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

  // ======================================
  // =   Methods hash, equals, toString   =
  // ======================================

  @Override
  public String toString() {
    return "BookNumbers{" +
      "isbn10='" + isbn10 + '\'' +
      ", isbn13='" + isbn13 + '\'' +
      '}';
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
