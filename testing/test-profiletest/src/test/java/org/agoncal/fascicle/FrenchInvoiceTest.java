package org.agoncal.fascicle;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
@TestProfile(FrenchTestProfile.class)
class FrenchInvoiceTest {

  @Inject
  Invoice invoice;

  @Test
  public void shouldCalculateInvoice() {
    invoice.subtotal = 500f;
    assertEquals(20f, invoice.vatRate);
    assertEquals(100f, invoice.caclculateVatAmount());
    assertEquals(600f, invoice.caclculateTotal());
    assertTrue(invoice.allowsDiscount);
    assertTrue(invoice.terms.startsWith("Payment"));
    assertTrue(invoice.penalties.startsWith("Penalty"));
  }
}
