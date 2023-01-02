package org.agoncal.fascicle.quarkus.http.jsonp.dflt;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@ApplicationScoped
public class CustomerService {

  // ======================================
  // =           Public Methods           =
  // ======================================

  // tag::adocGetCustomer[]
  public JsonObject getCustomer() {
    JsonObject customer = Json.createObjectBuilder()
      .add("firstName", "Antonio")
      .add("lastName", "Goncalves")
      .add("email", "agoncal.fascicle@gmail.com")
      .build();
    return customer;
  }
  // end::adocGetCustomer[]

  // tag::adocGetCustomerDetails[]
  public JsonObject getCustomerDetails() {
    JsonObject customer = Json.createObjectBuilder()
      .add("firstName", "Antonio")
      .add("lastName", "Goncalves")
      .add("email", "agoncal.fascicle@gmail.com")
      .add("address", Json.createObjectBuilder()
        .add("street", "21 Ritherdon Rd")
        .add("city", "Brighton")
        .add("country", "UK"))
      .add("phoneNumbers", Json.createArrayBuilder()
        .add(Json.createObjectBuilder()
          .add("type", "mobile")
          .add("number", "+33 123 456"))
        .add(Json.createObjectBuilder()
          .add("type", "home")
          .add("number", "+33 646 555")))
      .build();
    return customer;
  }
  // end::adocGetCustomerDetails[]

  // tag::adocGetPhones[]
  public JsonArray getPhones() {
    JsonArray phones =  Json.createArrayBuilder()
      .add(Json.createObjectBuilder()
        .add("type", "mobile")
        .add("number", "+33 123 456"))
      .add(Json.createObjectBuilder()
        .add("type", "home")
        .add("number", "+33 646 555"))
      .build();
    return phones;
  }
  // end::adocGetPhones[]
}
