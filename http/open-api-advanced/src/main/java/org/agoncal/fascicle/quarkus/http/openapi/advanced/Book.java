package org.agoncal.fascicle.quarkus.http.openapi.advanced;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;

// tag::adocSchema[]
@Schema(name = "Book", description = "Book representation")
public class Book {

  @Schema(required = true, readOnly = true)
  public Long id;
  @Schema(required = true)
  public String title;
  @Schema(required = true, example = "9798629562115")
  public String isbn;
  public String author;
  public BigDecimal price;
  public String description;
}
// end::adocSchema[]
