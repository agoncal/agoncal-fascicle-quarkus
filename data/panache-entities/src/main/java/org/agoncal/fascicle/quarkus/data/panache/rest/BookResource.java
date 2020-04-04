package org.agoncal.fascicle.quarkus.data.panache.rest;

import javax.transaction.Transactional;
import javax.ws.rs.Path;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Transactional
@Path("/books")
public class BookResource {

//  // ======================================
//  // =             Attributes             =
//  // ======================================
//
//  @PersistenceContext(unitName = "module07PU")
//  private EntityManager em;
//
//  // ======================================
//  // =           Public Methods           =
//  // ======================================
//
//  @POST
//  @Consumes(MediaType.APPLICATION_JSON)
//  public Response create(Book entity) {
//    em.persist(entity);
//    return Response.created(UriBuilder.fromResource(BookResource.class).path(String.valueOf(entity.getId())).build()).build();
//  }
//
//  @DELETE
//  @Path("/{id:[0-9][0-9]*}")
//  public Response deleteById(@PathParam("id") Long id) {
//    Book entity = em.find(Book.class, id);
//    if (entity == null) {
//      return Response.status(Status.NOT_FOUND).build();
//    }
//    em.remove(entity);
//    return Response.noContent().build();
//  }
//
//  @GET
//  @Path("/{id:[0-9][0-9]*}")
//  @Produces(MediaType.APPLICATION_JSON)
//  public Response findById(@PathParam("id") Long id) {
//    TypedQuery<Book> findByIdQuery = em.createQuery("SELECT DISTINCT b FROM Book b LEFT JOIN FETCH b.authors LEFT JOIN FETCH b.publisher WHERE b.id = :entityId ORDER BY b.id", Book.class);
//    findByIdQuery.setParameter("entityId", id);
//    Book entity;
//    try {
//      entity = findByIdQuery.getSingleResult();
//    } catch (NoResultException nre) {
//      entity = null;
//    }
//    if (entity == null) {
//      return Response.status(Status.NOT_FOUND).build();
//    }
//    return Response.ok(entity).build();
//  }
//
//  @GET
//  @Produces(MediaType.APPLICATION_JSON)
//  public List<Book> listAll(@QueryParam("start") Integer startPosition, @QueryParam("max") Integer maxResult) {
//    TypedQuery<Book> findAllQuery = em.createQuery("SELECT DISTINCT b FROM Book b LEFT JOIN FETCH b.authors LEFT JOIN FETCH b.publisher ORDER BY b.id", Book.class);
//    if (startPosition != null) {
//      findAllQuery.setFirstResult(startPosition);
//    }
//    if (maxResult != null) {
//      findAllQuery.setMaxResults(maxResult);
//    }
//    final List<Book> results = findAllQuery.getResultList();
//    return results;
//  }
//
//  @PUT
//  @Path("/{id:[0-9][0-9]*}")
//  @Consumes(MediaType.APPLICATION_JSON)
//  public Response update(Book entity) {
//    entity = em.merge(entity);
//    return Response.noContent().build();
//  }
}
