package org.agoncal.fascicle.quarkus.data.panache.rest;

import javax.ws.rs.Path;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Path("/authors")
public class AuthorResource {

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
//  public Response create(Author entity) {
//    em.persist(entity);
//    return Response.created(UriBuilder.fromResource(AuthorResource.class).path(String.valueOf(entity.getId())).build()).build();
//  }
//
//  @DELETE
//  @Path("/{id:[0-9][0-9]*}")
//  public Response deleteById(@PathParam("id") Long id) {
//    Author entity = em.find(Author.class, id);
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
//    TypedQuery<Author> findByIdQuery = em.createQuery("SELECT DISTINCT a FROM Author a WHERE a.id = :entityId ORDER BY a.id", Author.class);
//    findByIdQuery.setParameter("entityId", id);
//    Author entity;
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
//  public List<Author> listAll(@QueryParam("start") Integer startPosition, @QueryParam("max") Integer maxResult) {
//    TypedQuery<Author> findAllQuery = em.createQuery("SELECT DISTINCT a FROM Author a ORDER BY a.id", Author.class);
//    if (startPosition != null) {
//      findAllQuery.setFirstResult(startPosition);
//    }
//    if (maxResult != null) {
//      findAllQuery.setMaxResults(maxResult);
//    }
//    final List<Author> results = findAllQuery.getResultList();
//    return results;
//  }
//
//  @PUT
//  @Path("/{id:[0-9][0-9]*}")
//  @Consumes(MediaType.APPLICATION_JSON)
//  public Response update(Author entity) {
//    entity = em.merge(entity);
//    return Response.noContent().build();
//  }
}
