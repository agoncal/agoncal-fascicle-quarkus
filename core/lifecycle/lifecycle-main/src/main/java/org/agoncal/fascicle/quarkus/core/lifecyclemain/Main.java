package org.agoncal.fascicle.quarkus.core.lifecyclemain;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

// tag::adocSnippet[]
@QuarkusMain
public class Main {

  public static void main(String... args) {
    Quarkus.run(MyApplication.class, args);
  }

  public static class MyApplication implements QuarkusApplication {
    @Override
    public int run(String... args) throws Exception {
      System.out.println("Do startup logic here...");
      Quarkus.waitForExit();
      System.out.println("Complete task and then exit...");
      return 0;
    }
  }
}
// end::adocSnippet[]
