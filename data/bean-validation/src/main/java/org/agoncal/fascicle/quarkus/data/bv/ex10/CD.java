package org.agoncal.fascicle.quarkus.data.bv.ex10;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
public class CD {

  // tag::adocAttributes[]
  @NotNull @Size(min = 4, max = 50)
  public String title;
  @NotNull @Positive
  public Float price;
  @Size(min = 10, max = 5000)
  public String description;
  @Pattern(regexp = "[A-Z][a-z]+")
  public String musicCompany;
  @Max(value = 5)
  public Integer numberOfCDs;
  public Float totalDuration;

  // end::adocAttributes[]
  // tag::adocMethodPrice[]
  @NotNull @DecimalMin("5.8")
  public Float calculatePrice(@DecimalMin("1.4") Float discountRate) {
    return price * discountRate;
  }

  // end::adocMethodPrice[]
  // tag::adocMethodVat[]
  @DecimalMin("9.99")
  public Float calculateVAT() {
    return price * 0.196f;
  }
  // end::adocMethodVat[]
  // tag::adocSkip[]
  // @formatter:on

  // ======================================
  // =            Constructors            =
  // ======================================

  public CD() {
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public CD title(String title) {
    this.title = title;
    return this;
  }

  public CD price(Float price) {
    this.price = price;
    return this;
  }

  public CD description(String description) {
    this.description = description;
    return this;
  }

  public CD musicCompany(String musicCompany) {
    this.musicCompany = musicCompany;
    return this;
  }

  public CD numberOfCDs(Integer numberOfCDs) {
    this.numberOfCDs = numberOfCDs;
    return this;
  }

  public CD totalDuration(Float totalDuration) {
    this.totalDuration = totalDuration;
    return this;
  }

  // end::adocSkip[]
}
// end::adocSnippet[]
