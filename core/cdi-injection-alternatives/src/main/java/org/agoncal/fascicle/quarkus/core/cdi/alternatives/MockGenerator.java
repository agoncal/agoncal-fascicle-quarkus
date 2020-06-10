package org.agoncal.fascicle.quarkus.core.cdi.alternatives;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Alternative
// tag::adocSkip[]
@Default
// end::adocSkip[]
@ApplicationScoped
public class MockGenerator implements NumberGenerator {

  public String generateNumber() {
    return "MOCK";
  }
}
// end::adocSnippet[]
