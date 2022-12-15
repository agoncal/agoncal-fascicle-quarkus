package org.agoncal.fascicle.quarkus.data.bv.ex06;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
public class CardValidator {

  private ValidationAlgorithm algorithm;

  public CardValidator(@NotNull ValidationAlgorithm algorithm) {
    this.algorithm = algorithm;
  }

  @AssertTrue
  public boolean validate(@NotNull CreditCard creditCard) {
    return algorithm.validate(creditCard.getNumber(), creditCard.getControlNumber());
  }

  @AssertTrue
  public boolean validate(@NotNull String number,
                          @Future  Date expiryDate,
                          @NotNull Integer controlNumber) {
    return algorithm.validate(number, controlNumber);
  }
  // tag::adocSkip[]

  public CardValidator() {
  }

  private class ValidationAlgorithm {

    public boolean validate(String number, Integer controlNumber) {
      char lastDigit = number.charAt(number.length() - 1);
      return Integer.parseInt(Character.toString(lastDigit)) % 2 == 0;
    }
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
