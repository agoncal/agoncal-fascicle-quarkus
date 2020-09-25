package org.agoncal.fascicle.quarkus.reactive.mutiny;

import io.smallrye.mutiny.Uni;

public class CreateUniLazily {

  public static void main(String[] args) {
    // tag::adocSnippet[]
    // Lazily creates a Uni
    Uni<String> uni = Uni.createFrom().item("Terri Lyne Carrington")
      .onItem().transform(s -> s.toUpperCase() + " ");

    // Subscribes to it
    uni.subscribe().with(System.out::print);
  }
  // end::adocSnippet[]
}
