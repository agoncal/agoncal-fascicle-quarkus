package org.agoncal.fascicle.quarkus.reactive.mutiny;

import io.smallrye.mutiny.Multi;

import java.time.Duration;
import java.util.Arrays;
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
    //fromTicks();
  }

  private static void fromItems() {
    // tag::adocFromItems[]
    Multi.createFrom().items("Carla Bley", "John Coltrane", "Juliette Gréco")
      .onItem().transform(i -> i.toUpperCase())
      .subscribe().with(System.out::println);
    // end::adocFromItems[]
  }

  private static void array() {
    List<String> artists = Arrays.asList("Carla Bley", "John Coltrane", "Juliette Gréco");
    Multi.createFrom().items(artists)
      .onItem().transform(l -> l.iterator().next())
      .subscribe().with(System.out::println);
  }

  private static void toUni() {
    // tag::adocToUni[]
    Multi.createFrom().items("Carla Bley", "John Coltrane", "Juliette Gréco")
      .onItem().transform(i -> i.toUpperCase())
      .toUni()
      .subscribe().with(System.out::println);
    // end::adocToUni[]
  }

  private static void withFailure() {
    // tag::adocWithFailure[]
    Multi.createFrom().items("Carla Bley", "John Coltrane", "Juliette Gréco")
      .onItem().transform(i -> i.toUpperCase())
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
      .transform().byTakingFirstItems(3)
      .subscribe().with(System.out::println);
    // end::adocFromMulti[]
  }

  private static void fromTicks() {
    // tag::adocFromTick[]
    Multi.createFrom().ticks().every(Duration.ofMillis(1))
      .transform().byTakingFirstItems(2);
    // end::adocFromTick[]
  }
}
