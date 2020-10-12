package org.agoncal.fascicle.quarkus.data.bv.ex02;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

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
