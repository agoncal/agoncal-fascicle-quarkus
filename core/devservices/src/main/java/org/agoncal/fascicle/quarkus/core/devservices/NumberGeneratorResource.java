package org.agoncal.fascicle.quarkus.core.devservices;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Random;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Path("/numbers")
@Produces(MediaType.TEXT_PLAIN)
public class NumberGeneratorResource {

  @GET
  public int getNumber() {
    return Math.abs(new Random().nextInt());
  }
}
