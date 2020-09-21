package org.agoncal.fascicle.quarkus.reactive.messages.kafka.model;

import javax.json.bind.annotation.JsonbProperty;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public abstract class Person {

  @JsonbProperty("first_name")
  public String firstName;
  @JsonbProperty("last_name")
  public String lastName;
  @JsonbProperty("shipping_address")
  public Address shippingAddress;
}
