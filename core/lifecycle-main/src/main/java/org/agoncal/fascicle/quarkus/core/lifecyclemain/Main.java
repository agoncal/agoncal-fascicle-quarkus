package org.agoncal.fascicle.quarkus.core.lifecyclemain;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

// tag::adocSnippet[]
@QuarkusMain
public class Main implements QuarkusApplication {

  @Override
  public int run(String... args) throws Exception {
    System.out.println("Running main method...");
    Quarkus.waitForExit();
    return 0;
  }
}
// end::adocSnippet[]
