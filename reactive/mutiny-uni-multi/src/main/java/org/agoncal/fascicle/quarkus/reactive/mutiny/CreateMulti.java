package org.agoncal.fascicle.quarkus.reactive.mutiny;

import io.smallrye.mutiny.Multi;

// @formatter:off
public class CreateMulti {

  public static void main(String[] args) {
    System.out.println("#### fromItems()");
    fromItems();
    System.out.println("#### toUni()");
    toUni();
    System.out.println("#### withFailure()");
    withFailure();
  }

  private static void fromItems() {
    // tag::adocFromItems[]
    Multi.createFrom().items("Carla Bley", "John Coltrane", "Juliette Gréco")
      .onItem().transform(i -> i.toUpperCase())
      .subscribe().with(System.out::println);
    // end::adocFromItems[]
  }

  private static void toUni() {
    // tag::adocToUni[]
    Multi.createFrom().items("Carla Bley", "John Coltrane", "Juliette Gréco")
      .onItem().transform(i -> i.toUpperCase())
      .toUni()
      .subscribe().with(System.out::println);
    // end::adocToUni[]
  }

  private static void withFailure() {
    // tag::adocWithFailure[]
    Multi.createFrom().items("Carla Bley", "John Coltrane", "Juliette Gréco")
      .onItem().transform(i -> i.toUpperCase())
      .subscribe().with(
        item -> System.out.println("Received: " + item),
        failure -> System.out.println("Failed with " + failure.getMessage())
    );
    // end::adocWithFailure[]
  }
}
