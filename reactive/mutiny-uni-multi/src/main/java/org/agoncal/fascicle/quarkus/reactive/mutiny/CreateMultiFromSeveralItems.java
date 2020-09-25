package org.agoncal.fascicle.quarkus.reactive.mutiny;

import io.smallrye.mutiny.Multi;

// @formatter:off
public class CreateMultiFromSeveralItems {

  public static void main(String[] args) {
    Multi.createFrom().items("a", "b", "c")
      .onItem().transform(i -> i.toUpperCase())
      .subscribe().with(
        item -> System.out.println("Received: " + item),
        failure -> System.out.println("Failed with " + failure.getMessage())
      );
  }
}
