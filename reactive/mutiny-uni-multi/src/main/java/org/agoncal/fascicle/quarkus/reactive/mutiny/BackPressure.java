package org.agoncal.fascicle.quarkus.reactive.mutiny;

import io.smallrye.mutiny.Multi;

import java.util.concurrent.Executor;

// @formatter:off
public class BackPressure {

  public static void main(String[] args) {
    System.out.println("#### fromItems()");
    fromItems();
  }

  private static void fromItems() {
    Multi<String> multi = Multi.createFrom().items("Carla Bley", "John Coltrane", "Juliette Gréco");
    //Infrastructure.setDefaultExecutor();
    Executor executor = new MyExecutor();

    // tag::adocFromItems[]
    String res1 = multi
      .emitOn(executor)
      .onOverflow().buffer(10)
      .collect().first()
      .await().indefinitely();
    // end::adocFromItems[]
  }

  static class MyExecutor implements Executor {

    @Override
    public void execute(Runnable command) {

    }
  }
}
