package org.agoncal.fascicle.quarkus.reactive.mutiny;

import io.smallrye.mutiny.Uni;

public class CreateUniLazily {

  public static void main(String[] args) {
    // Lazily creates a Uni
    Uni<String> uni = Uni.createFrom().item("hello")
      .onItem().transform(s -> s.toUpperCase() + " ");

    // Subscribes to it
    uni.subscribe().with(System.out::print);
  }
}
