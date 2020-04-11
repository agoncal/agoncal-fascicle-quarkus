package org.agoncal.fascicle.quarkus.core.cdi.qualifiers;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@EightDigits
@ApplicationScoped
public class IssnGenerator implements NumberGenerator {

  public String generateNumber() {
    return "8-" + Math.abs(new Random().nextInt());
  }
}
// end::adocSnippet[]
