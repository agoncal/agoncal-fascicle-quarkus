package org.agoncal.fascicle.quarkus.core.configuration.properties;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class InvoiceTest {

  @Inject
  Invoice invoice;

  @Inject
  InvoiceConfiguration invoiceConfiguration;

  @Test
  public void shouldCalculateInvoice() {
    invoice.vatRate = invoiceConfiguration.vatRate;
    invoice.allowsDiscount = invoiceConfiguration.allowsDiscount;
    invoice.terms = invoiceConfiguration.terms;
    invoice.penalties = invoiceConfiguration.penalties;

    invoice.subtotal = 500f;
    invoice.vatAmount = invoice.subtotal * (invoice.vatRate / 100);
    invoice.total = invoice.subtotal + invoice.vatAmount;
    assertEquals(50f, invoice.vatAmount);
    assertEquals(550f, invoice.total);
    assertFalse(invoice.allowsDiscount);
    assertTrue(invoice.terms.startsWith("Payment"));
    assertTrue(invoice.penalties.startsWith("In case"));
  }
}
