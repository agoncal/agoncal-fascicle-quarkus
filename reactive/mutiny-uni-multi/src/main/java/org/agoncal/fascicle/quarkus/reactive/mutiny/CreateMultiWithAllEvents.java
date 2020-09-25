package org.agoncal.fascicle.quarkus.reactive.mutiny;

import io.smallrye.mutiny.Multi;

public class CreateMultiWithAllEvents {

  public static void main(String[] args) {

    // tag::adocSnippet[]
    Multi.createFrom().items("Carla Bley", "John Coltrane", "Miles Davis", "Juliette Gréco")
      .onItem().invoke(item -> System.out.println("Received   " + item))
      .onCompletion().invoke(() -> System.out.println("Completed"))
      .onFailure().invoke(failure -> System.out.println("Completed with failure " + failure.getMessage()))
      .subscribe().with(item -> System.out.println("Subscriber " + item));
    // end::adocSnippet[]
  }
}
