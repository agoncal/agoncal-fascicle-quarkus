package org.agoncal.fascicle;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// tag::adocSnippet[]
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
    assertEquals(587.5f, invoice.caclculateTotal());
    assertTrue(invoice.discount);
  }
}
// end::adocSnippet[]
