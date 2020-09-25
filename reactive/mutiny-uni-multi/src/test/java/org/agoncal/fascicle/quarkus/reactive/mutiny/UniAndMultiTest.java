package org.agoncal.fascicle.quarkus.reactive.mutiny;

import io.smallrye.mutiny.operators.UniNever;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
class UniAndMultiTest {

  UniAndMulti uniAndMulti = new UniAndMulti();

  @Test
  void shouldCreateUniFromNothing() {
    assertEquals(UniNever.INSTANCE, uniAndMulti.createUniFromNothing());
  }

  @Test
  void shouldCreateUniFromFailure() {
    assertEquals("Hello world", uniAndMulti.createUniFromItem());
  }
}
