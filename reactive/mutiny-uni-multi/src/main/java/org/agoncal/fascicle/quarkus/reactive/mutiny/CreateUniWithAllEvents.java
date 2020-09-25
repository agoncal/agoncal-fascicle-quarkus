package org.agoncal.fascicle.quarkus.reactive.mutiny;

import io.smallrye.mutiny.Uni;

public class CreateUniWithAllEvents {

  public static void main(String[] args) {

    // tag::adocSnippet[]
    Uni.createFrom().item("Carla Bley")
      .onItem().invoke(item -> System.out.println("Received   " + item))
      .onFailure().invoke(failure -> System.out.println("Completed with failure " + failure.getMessage()))
      .subscribe().with(item -> System.out.println("Subscriber " + item));
    // end::adocSnippet[]
  }
}
