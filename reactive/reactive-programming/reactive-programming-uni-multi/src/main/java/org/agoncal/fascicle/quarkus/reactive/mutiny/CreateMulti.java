package org.agoncal.fascicle.quarkus.reactive.mutiny;

import io.smallrye.mutiny.Multi;

import java.time.Duration;
import java.util.List;

// @formatter:off
public class CreateMulti {

  public static void main(String[] args) {
    System.out.println("#### fromItems()");
    fromItems();
    System.out.println("#### array()");
    array();
    System.out.println("#### toUni()");
    toUni();
    System.out.println("#### withFailure()");
    withFailure();
    System.out.println("#### fromMulti()");
    fromMulti();
  }

  private static void fromItems() {
    // tag::adocFromItems[]
    Multi.createFrom().items("Carla Bley", "John Coltrane", "Juliette Gréco")
      .onItem().transform(String::toUpperCase)
      .subscribe().with(System.out::println);
    // end::adocFromItems[]
  }

  private static void array() {
    List<String> artists = List.of("Carla Bley", "John Coltrane", "Juliette Gréco");
    Multi.createFrom().items(artists)
      .onItem().transform(l -> l.iterator().next())
      .subscribe().with(System.out::println);
  }

  private static void toUni() {
    // tag::adocToUni[]
    Multi.createFrom().items("Carla Bley", "John Coltrane", "Juliette Gréco")
      .onItem().transform(String::toUpperCase)
      .toUni()
      .subscribe().with(System.out::println);
    // end::adocToUni[]
  }

  private static void withFailure() {
    // tag::adocWithFailure[]
    Multi.createFrom().items("Carla Bley", "John Coltrane", "Juliette Gréco")
      .onItem().transform(String::toUpperCase)
      .subscribe().with(
        item -> System.out.println("Received: " + item),
        failure -> System.out.println("Failed with " + failure.getMessage())
    );
    // end::adocWithFailure[]
  }

  private static void fromMulti() {
    // tag::adocFromMulti[]
    Multi<Long> ticks = Multi.createFrom().ticks().every(Duration.ofSeconds(1));

    Multi.createFrom().publisher(ticks)
      .select().first(3)
      .subscribe().with(System.out::println);
    // end::adocFromMulti[]
  }
}
