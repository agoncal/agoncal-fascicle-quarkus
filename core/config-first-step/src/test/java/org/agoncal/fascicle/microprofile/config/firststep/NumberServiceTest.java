package org.agoncal.fascicle.microprofile.config.firststep;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class NumberServiceTest {

  @Inject
  NumberService numberService;

  @Test
  void shouldGenerateBookNumber() {
    String number = numberService.generateBookNumber();
    assertTrue(number.startsWith("13"));
    assertTrue(number.endsWith("pt"));
  }

  @Test
  void shouldGenerateCDNumber() {
    String number = numberService.generateCDNumber();
    assertTrue(number.endsWith("pt"));
  }
}
