package org.agoncal.fascicle.quarkus.reactive.mutiny;

import io.smallrye.mutiny.Uni;

public class GettingStarted {

  public static void main(String[] args) {
    Uni.createFrom().item("hello")
      .onItem().transform(s -> s.toUpperCase() + " ")
      .subscribe().with(System.out::print);
//    Multi.createFrom().items("hello", "world")
//      .onItem().transform(s -> s.toUpperCase() + " ")
//      .onCompletion().continueWith("!")
//      .subscribe().with(System.out::print);
  }
}
