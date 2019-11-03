package org.agoncal.fascicle.quarkus.puttingtogether.generator;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
@Path("/numbers")
@Produces(MediaType.TEXT_PLAIN)
//@Api(value = "numbers", description = "Generating all sorts of numbers.")
public class NumberResource {

  private final Logger log = LoggerFactory.getLogger(NumberResource.class);

  private int numberApiFakeTimeout = 0;

  @GET
  @Path("book")
//    @ApiOperation(value = "Generates a book number.", response = String.class)
  public Response generateBookNumber() throws InterruptedException {
    final Config config = ConfigProvider.getConfig();
    config.getOptionalValue("NUMBER_API_FAKE_TIMEOUT", Integer.class).ifPresent(t -> numberApiFakeTimeout = t);
    log.info("Waiting for " + numberApiFakeTimeout + " seconds");
    TimeUnit.SECONDS.sleep(numberApiFakeTimeout);
    log.info("Generating a book number");
    return Response.ok("BK-" + Math.random()).build();
  }

  @GET
  @Path("health")
//    @ApiOperation(value = "Checks the health of this REST endpoint", response = String.class)
  public Response health() {
    log.info("Alive and Kicking !!!");
    return Response.ok().build();
  }
}
