package org.agoncal.fascicle.quarkus.data.panache.rest;

import javax.ws.rs.Path;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Path("/cds")
public class CDResource {

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
//  public Response create(CD entity) {
//    em.persist(entity);
//    return Response.created(UriBuilder.fromResource(CDResource.class).path(String.valueOf(entity.getId())).build()).build();
//  }
//
//  @DELETE
//  @Path("/{id:[0-9][0-9]*}")
//  public Response deleteById(@PathParam("id") Long id) {
//    CD entity = em.find(CD.class, id);
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
//    TypedQuery<CD> findByIdQuery = em.createQuery("SELECT DISTINCT c FROM CD c LEFT JOIN FETCH c.musicians WHERE c.id = :entityId ORDER BY c.id", CD.class);
//    findByIdQuery.setParameter("entityId", id);
//    CD entity;
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
//  public List<CD> listAll(@QueryParam("start") Integer startPosition, @QueryParam("max") Integer maxResult) {
//    TypedQuery<CD> findAllQuery = em.createQuery("SELECT DISTINCT c FROM CD c LEFT JOIN FETCH c.musicians ORDER BY c.id", CD.class);
//    if (startPosition != null) {
//      findAllQuery.setFirstResult(startPosition);
//    }
//    if (maxResult != null) {
//      findAllQuery.setMaxResults(maxResult);
//    }
//    final List<CD> results = findAllQuery.getResultList();
//    return results;
//  }
//
//  @PUT
//  @Path("/{id:[0-9][0-9]*}")
//  @Consumes(MediaType.APPLICATION_JSON)
//  public Response update(CD entity) {
//    entity = em.merge(entity);
//    return Response.noContent().build();
//  }
}
