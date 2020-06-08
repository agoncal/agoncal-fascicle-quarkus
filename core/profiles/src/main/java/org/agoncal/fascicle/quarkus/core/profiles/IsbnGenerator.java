package org.agoncal.fascicle.quarkus.core.profiles;


import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@ApplicationScoped
public class IsbnGenerator implements NumberGenerator {

  @ConfigProperty(name = "isbn.prefix")
  String prefix;

  public String generateNumber() {
    return prefix + Math.abs(new Random().nextInt());
  }
}
// end::adocSnippet[]
