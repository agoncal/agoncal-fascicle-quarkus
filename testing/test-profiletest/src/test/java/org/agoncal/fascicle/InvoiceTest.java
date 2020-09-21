package org.agoncal.fascicle;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@QuarkusTest
class InvoiceTest {

  @Inject
  Invoice invoice;

  @Test
  public void shouldCalculateInvoice() {
    invoice.subtotal = 500f;
    assertEquals(10f, invoice.vatRate);
    assertEquals(50f, invoice.caclculateVatAmount());
    assertEquals(550f, invoice.caclculateTotal());
    assertFalse(invoice.discount);
  }
}
