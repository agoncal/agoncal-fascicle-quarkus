package org.agoncal.fascicle.quarkus.transactionsorm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

  private static final Pattern zipPattern = Pattern.compile("\\d{5}(-\\d{5})?");

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null)
      return true;

    Matcher m = zipPattern.matcher(value);
    if (!m.matches())
      return false;
    return true;
  }
}
// end::adocSnippet[]
