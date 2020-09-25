package org.agoncal.fascicle.quarkus.reactive.mutiny;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public class EventUniMulti {

  public static void main(String[] args) {
    System.out.println("#### uniEvent()");
    uniEvent();
    System.out.println("#### multiEvent()");
    multiEvent();
  }

  private static void uniEvent() {
    // tag::adocUniEvent[]
    Uni.createFrom().item("Carla Bley")
      .onItem().invoke(item -> System.out.println("Received   " + item))
      .onFailure().invoke(failure -> System.out.println("Completed with failure " + failure.getMessage()))
      .subscribe().with(item -> System.out.println("Subscriber " + item));
    // end::adocUniEvent[]
  }

  private static void multiEvent() {
    // tag::adocMultiEvent[]
    Multi.createFrom().items("Carla Bley", "John Coltrane", "Miles Davis", "Juliette Gréco")
      .onItem().invoke(item -> System.out.println("Received   " + item))
      .onCompletion().invoke(() -> System.out.println("Completed"))
      .onFailure().invoke(failure -> System.out.println("Completed with failure " + failure.getMessage()))
      .subscribe().with(item -> System.out.println("Subscriber " + item));
    // end::adocMultiEvent[]
  }
}
