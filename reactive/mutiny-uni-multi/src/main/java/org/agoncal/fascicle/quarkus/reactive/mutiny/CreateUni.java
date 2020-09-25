package org.agoncal.fascicle.quarkus.reactive.mutiny;

import io.smallrye.mutiny.Uni;

// @formatter:off
public class CreateUni {

  public static void main(String[] args) {
    System.out.println("#### fromItem()");
    fromItem();
    System.out.println("#### lazy()");
    lazy();
    System.out.println("#### withFailure()");
    withFailure();
  }

  private static void fromItem() {
    // tag::adocFromItem[]
    Uni.createFrom().item("Terri Lyne Carrington")
      .onItem().transform(s -> s.toUpperCase() + " ")
      .subscribe().with(System.out::println);
    // end::adocFromItem[]
  }

  private static void lazy() {
    // tag::adocLazy[]
    // Lazily creates a Uni
    Uni<String> uni = Uni.createFrom().item("Terri Lyne Carrington")
      .onItem().transform(s -> s.toUpperCase() + " ");

    // Subscribes to it
    uni.subscribe().with(System.out::println);
    // end::adocLazy[]
  }

  private static void withFailure() {
    // tag::adocWithFailure[]
    Uni.createFrom().item("Terri Lyne Carrington")
      .onItem().transform(s -> s.toUpperCase() + " ")
      .subscribe().with(
        item -> System.out.println("Received: " + item),
        failure -> System.out.println("Failed with " + failure.getMessage())
    );
    // end::adocWithFailure[]
  }
}
