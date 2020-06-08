package org.agoncal.fascicle.quarkus.core.configuration;

import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@formatter:off
@QuarkusTest
class OptionalInvoiceTest {

  @Inject
  OptionalInvoice invoice;

  @Inject
  Config config;

  @Test
  public void shouldCalculateInvoiceProgrammaticallyOptional() {
    invoice.vatRate = config.getValue("invoice.vatRate", Float.class);
    invoice.allowsDiscount = config.getValue("invoice.allowsDiscount", Boolean.class);
    // tag::adocShouldCalculateInvoiceProgrammaticallyOptional[]
    invoice.terms = config.getOptionalValue("invoice.terms", String.class);
    invoice.penalties = config.getOptionalValue("invoice.penalties", String.class);
    // end::adocShouldCalculateInvoiceProgrammaticallyOptional[]

    invoice.subtotal = 500f;
    invoice.vatAmount = invoice.subtotal * (invoice.vatRate / 100);
    invoice.total = invoice.subtotal + invoice.vatAmount;
    assertEquals(10f, invoice.vatRate);
    assertEquals(50f, invoice.vatAmount);
    assertEquals(550f, invoice.total);
    assertFalse(invoice.allowsDiscount);
    assertTrue(invoice.terms.get().startsWith("Payment"));
    assertTrue(invoice.penalties.get().startsWith("Penalty"));
  }

  @Test
  public void shouldCalculateInvoice() {
    invoice.subtotal = 500f;
    invoice.vatAmount = invoice.subtotal * (invoice.vatRate / 100);
    invoice.total = invoice.subtotal + invoice.vatAmount;
    assertEquals(10f, invoice.vatRate);
    assertEquals(50f, invoice.vatAmount);
    assertEquals(550f, invoice.total);
    assertFalse(invoice.allowsDiscount);
    assertTrue(invoice.terms.get().startsWith("Payment"));
    assertTrue(invoice.penalties.get().startsWith("Penalty"));
  }

  @Test
  public void shouldCalculateInvoiceProgrammatically() {
    Config config = ConfigProvider.getConfig();
    invoice.vatRate = config.getValue("invoice.vatRate", Float.class);
    invoice.allowsDiscount = config.getValue("invoice.allowsDiscount", Boolean.class);
    invoice.terms = config.getOptionalValue("invoice.terms", String.class);
    invoice.penalties = config.getOptionalValue("invoice.penalties", String.class);

    invoice.subtotal = 500f;
    invoice.vatAmount = invoice.subtotal * (invoice.vatRate / 100);
    invoice.total = invoice.subtotal + invoice.vatAmount;
    assertEquals(10f, invoice.vatRate);
    assertEquals(50f, invoice.vatAmount);
    assertEquals(550f, invoice.total);
    assertFalse(invoice.allowsDiscount);
    assertTrue(invoice.terms.get().startsWith("Payment"));
    assertTrue(invoice.penalties.get().startsWith("Penalty"));
  }
}
