package org.agoncal.fascicle.quarkus.reactive.mutiny;

import io.smallrye.mutiny.Uni;

// @formatter:off
public class CreateUniFromOneItem {

  public static void main(String[] args) {
    Uni.createFrom().item("a")
      .onItem().transform(i -> i.toUpperCase())
      .subscribe().with(
        item -> System.out.println("Received: " + item),
        failure -> System.out.println("Failed with " + failure.getMessage())
      );
  }
}
