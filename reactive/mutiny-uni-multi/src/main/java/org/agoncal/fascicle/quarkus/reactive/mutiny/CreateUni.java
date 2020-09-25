package org.agoncal.fascicle.quarkus.reactive.mutiny;

import io.smallrye.mutiny.Uni;

public class CreateUni {

  public static void main(String[] args) {
    System.out.println("#### fromItem()");
    fromItem();
    System.out.println("#### lazy()");
    lazy();
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
}
