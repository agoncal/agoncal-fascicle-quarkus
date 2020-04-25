package org.agoncal.fascicle.quarkus.core.cdi.injection;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import java.util.Random;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Default
@ApplicationScoped
public class IsbnGenerator implements NumberGenerator {

  public String generateNumber() {
    return "13-84356-" + Math.abs(new Random().nextInt());
  }
}
// end::adocSnippet[]
