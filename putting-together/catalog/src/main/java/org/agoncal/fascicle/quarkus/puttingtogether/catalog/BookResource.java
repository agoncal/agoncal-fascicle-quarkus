/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.agoncal.fascicle.quarkus.puttingtogether.catalog;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

import static java.util.Optional.ofNullable;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.noContent;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;

@ApplicationScoped
@Path("/books")
//@Api(value = "books", description = "Operations for Books.")
public class BookResource {

  private final Logger log = LoggerFactory.getLogger(BookResource.class);

  // ======================================
  // =             Injection              =
  // ======================================
//    @Inject
//    private NumbersApi numbersApi;

  @Inject
  BookRepository bookRepository;

  // ======================================
  // =              Methods               =
  // ======================================

  @GET
  @Path("/{id : \\d+}")
  @Produces(APPLICATION_JSON)
  @Operation(summary = "Find a Book by the Id")
  @APIResponse(responseCode = "200", description = "Book found", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Book.class, required = true)))
  @APIResponse(responseCode = "400", description = "Invalid input")
  @APIResponse(responseCode = "404", description = "Book not found")
  @Counted(name = "countFindById", description = "Counts how many times the findById method has been invoked")
  @Timed(name = "timeFindById", description = "Times how long it takes to invoke the findById method", unit = MetricUnits.MILLISECONDS)
  public Response findById(@Parameter(description = "Book identifier", required = true) @PathParam("id") final Long id) {
    log.info("Getting the book " + id);
    return ofNullable(bookRepository.findById(id))
      .map(Response::ok)
      .orElse(status(NOT_FOUND))
      .build();
  }

  @GET
  @Produces(APPLICATION_JSON)
  @Operation(summary = "Find all Books")
  @APIResponse(responseCode = "200", description = "All books found", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Book.class, type = SchemaType.ARRAY)))
  @APIResponse(responseCode = "404", description = "Books not found")
  @Counted(name = "countFindAll", description = "Counts how many times the findAll method has been invoked")
  @Timed(name = "timeFindAll", description = "Times how long it takes to invoke the findAll method", unit = MetricUnits.MILLISECONDS)
  public Response findAll() {
    log.info("Getting all the books");
    return ok(bookRepository.findAll()).build();
  }

  @POST
  @Consumes(APPLICATION_JSON)
  @Operation(summary = "Create a Book")
  @APIResponse(responseCode = "201", description = "The URI of the created book", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = URI.class)))
  @APIResponse(responseCode = "400", description = "Invalid input")
  @APIResponse(responseCode = "415", description = "Format is not JSon")
  @Counted(name = "countCreate", description = "Counts how many times the create method has been invoked")
  @Timed(name = "timeCreate", description = "Times how long it takes to invoke the create method", unit = MetricUnits.MILLISECONDS)
  // tag::adocSnippet[]
  public Response create(@RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Book.class))) @Valid Book book, @Context UriInfo uriInfo) {
    log.info("Creating the book " + book);

    log.info("Invoking the number-api");
    String isbn = null;//numbersApi.generateBookNumber();
    book.isbn = isbn;

    log.info("Creating the book with ISBN " + book);
    bookRepository.persist(book);
    URI createdURI = uriInfo.getBaseUriBuilder().path(String.valueOf(book.id)).build();
    return Response.created(createdURI).build();
  }
  // end::adocSnippet[]

  @PUT
  @Path("/{id : \\d+}")
  @Consumes(APPLICATION_JSON)
  @Produces(APPLICATION_JSON)
  @Operation(summary = "Updates an exiting  villain")
  @APIResponse(responseCode = "200", description = "The book is updated", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Book.class)))
  @APIResponse(responseCode = "400", description = "Invalid input")
  @Counted(name = "countUpdate", description = "Counts how many times the update method has been invoked")
  @Timed(name = "timeUpdate", description = "Times how long it takes to invoke the update method", unit = MetricUnits.MILLISECONDS)
  public Response update(@RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Book.class))) @Valid Book book) {
    log.info("Updating the book " + book);
    // TODO How to update with a repository
    // return ok(bookRepository.update(book)).build();
    return null;
  }

  @DELETE
  @Path("/{id : \\d+}")
  @Operation(summary = "Deletes an exiting book")
  @APIResponse(responseCode = "204", description = "Book has been deleted")
  @APIResponse(responseCode = "400", description = "Invalid input")
  @Counted(name = "countDelete", description = "Counts how many times the delete method has been invoked")
  @Timed(name = "timeDelete", description = "Times how long it takes to invoke the delete method", unit = MetricUnits.MILLISECONDS)
  public Response delete(@Parameter(description = "Villain identifier", required = true) @PathParam("id") final Long id) {
    log.info("Deleting the book " + id);
    Book book = bookRepository.findById(id);
    bookRepository.delete(book);
    return noContent().build();
  }

  @GET
  @Path("number")
  @APIResponse(responseCode = "200", description = "Wraps the Number API to retrieve a Book Number", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = String.class)))
  public Response number() {
    log.info("Invoking the number-api");
    return Response.ok(/*numbersApi.generateBookNumber()*/).build();
  }
}
