package org.agoncal.fascicle.quarkus.reactive.mutiny;

import io.smallrye.mutiny.Uni;

public class UniAndMulti {

  public Uni createUniFromNothing() {
    return Uni.createFrom().nothing();
  }

  public Uni<String> createUniFromFailure() {
    return Uni.createFrom().item("Hello world");
  }
}
