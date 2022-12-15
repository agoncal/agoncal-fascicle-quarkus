package org.agoncal.fascicle.quarkus.http.jaxrs.ex01;

import org.agoncal.fascicle.quarkus.http.jaxrs.Customer;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyWriter;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Provider
@Produces("custom/format")
public class CustomCustomerWriter implements MessageBodyWriter<Customer> {

  @Override
  public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
    return Customer.class.isAssignableFrom(type);
  }

  @Override
  public void writeTo(Customer customer, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream outputStream) throws IOException, WebApplicationException {
    outputStream.write(customer.getId().getBytes());
    outputStream.write('/');
    outputStream.write(customer.getFirstName().getBytes());
    outputStream.write('/');
    outputStream.write(customer.getLastName().getBytes());
  }

  @Override
  public long getSize(Customer customer, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
    return customer.getId().length() + 1 + customer.getFirstName().length() + 1 + customer.getLastName().length();
  }
}
