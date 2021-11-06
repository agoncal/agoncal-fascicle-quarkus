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

  // tag::adocSnippet[]
  @Inject
  InvoiceConfiguration invoiceConfiguration;

  // tag::adocSkip[]
  @Test
  public void shouldCalculateInvoice() {
    // end::adocSkip[]
    invoice.vatRate = invoiceConfiguration.vatRate();
    invoice.allowsDiscount = invoiceConfiguration.allowsDiscount();
    invoice.terms = invoiceConfiguration.terms();
    invoice.penalties = invoiceConfiguration.penalties();
    // end::adocSnippet[]

    invoice.subtotal = 500f;
    invoice.vatAmount = invoice.subtotal * (invoice.vatRate / 100);
    invoice.total = invoice.subtotal + invoice.vatAmount;
    assertEquals(10f, invoice.vatRate);
    assertEquals(50f, invoice.vatAmount);
    assertEquals(550f, invoice.total);
    assertFalse(invoice.allowsDiscount);
    assertTrue(invoice.terms.startsWith("Payment"));
    assertTrue(invoice.penalties.startsWith("Penalty"));
  }
}
