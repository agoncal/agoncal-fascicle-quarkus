package org.agoncal.fascicle.quarkus.data.bv.ex02;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
public class Book {

  @NotNull
  public String title;
  @Digits(integer = 4, fraction = 2)
  public Float price;
  @Size(max = 2000)
  public String description;
  public Integer isbn;
  @Positive
  public Integer nbOfPages;
  @Email
  public String authorEmail;
}
// end::adocSnippet[]
