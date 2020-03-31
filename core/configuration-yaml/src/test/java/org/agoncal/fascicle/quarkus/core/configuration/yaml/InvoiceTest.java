package org.agoncal.fascicle.quarkus.core.configuration.yaml;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class InvoiceTest {

  @Inject
  Invoice invoice;

  @Test
  public void shouldCalculatePO() {
    invoice.subtotal = 500f;
    invoice.total = invoice.subtotal * (invoice.vatRate / 100);
    assertEquals(550f, invoice.total);
    assertTrue(invoice.allowsDiscount);
  }
}
