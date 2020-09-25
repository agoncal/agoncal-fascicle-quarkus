package org.agoncal.fascicle.quarkus.reactive.mutiny;

import io.smallrye.mutiny.Multi;

// @formatter:off
public class CreateMulti {

  public static void main(String[] args) {
    System.out.println("#### fromItems()");
    fromItems();
  }

  private static void fromItems() {
    // tag::adocFromItems[]
    Multi.createFrom().items("Carla Bley", "John Coltrane", "Miles Davis", "Juliette Gréco")
      .onItem().transform(i -> i.toUpperCase())
      .subscribe().with(System.out::println);
    // end::adocFromItems[]
  }

  private static void withFailure() {
    // tag::adocWithFailure[]
    Multi.createFrom().items("Carla Bley", "John Coltrane", "Miles Davis", "Juliette Gréco")
      .onItem().transform(i -> i.toUpperCase())
      .subscribe().with(
        item -> System.out.println("Received: " + item),
        failure -> System.out.println("Failed with " + failure.getMessage())
    );
    // end::adocWithFailure[]
  }
}
