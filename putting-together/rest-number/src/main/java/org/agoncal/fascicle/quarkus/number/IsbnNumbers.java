package org.agoncal.fascicle.quarkus.number;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;

// tag::adocSnippet[]
// tag::adocOpenAPI[]
@Schema(description = "Several formats of book ISBN numbers")
// end::adocOpenAPI[]
public class IsbnNumbers {

  // tag::adocOpenAPI[]
  @Schema(required = true)
  // end::adocOpenAPI[]
  // tag::adocJSONB[]
  @JsonbProperty("isbn_10")
  // end::adocJSONB[]
  private String isbn10;
  // tag::adocOpenAPI[]
  @Schema(required = true)
  // end::adocOpenAPI[]
  // tag::adocJSONB[]
  @JsonbProperty("isbn_13")
  // end::adocJSONB[]
  private String isbn13;

  // Getters and setters
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
