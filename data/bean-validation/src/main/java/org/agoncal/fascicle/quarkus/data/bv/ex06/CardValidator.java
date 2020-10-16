package org.agoncal.fascicle.quarkus.data.bv.ex06;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
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
      Character lastDigit = number.charAt(number.length() - 1);
      if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
        return true;
      } else {
        return false;
      }
    }
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
