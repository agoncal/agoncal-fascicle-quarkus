package org.agoncal.fascicle.quarkus.data.panache.rest;

import javax.ws.rs.Path;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Path("/musicians")
public class MusicianResource {

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
//  public Response create(Musician entity) {
//    em.persist(entity);
//    return Response.created(UriBuilder.fromResource(MusicianResource.class).path(String.valueOf(entity.getId())).build()).build();
//  }
//
//  @DELETE
//  @Path("/{id:[0-9][0-9]*}")
//  public Response deleteById(@PathParam("id") Long id) {
//    Musician entity = em.find(Musician.class, id);
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
//    TypedQuery<Musician> findByIdQuery = em.createQuery("SELECT DISTINCT m FROM Musician m LEFT JOIN FETCH m.cds WHERE m.id = :entityId ORDER BY m.id", Musician.class);
//    findByIdQuery.setParameter("entityId", id);
//    Musician entity;
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
//  public List<Musician> listAll(@QueryParam("start") Integer startPosition, @QueryParam("max") Integer maxResult) {
//    TypedQuery<Musician> findAllQuery = em.createQuery("SELECT DISTINCT m FROM Musician m LEFT JOIN FETCH m.cds ORDER BY m.id", Musician.class);
//    if (startPosition != null) {
//      findAllQuery.setFirstResult(startPosition);
//    }
//    if (maxResult != null) {
//      findAllQuery.setMaxResults(maxResult);
//    }
//    final List<Musician> results = findAllQuery.getResultList();
//    return results;
//  }
//
//  @PUT
//  @Path("/{id:[0-9][0-9]*}")
//  @Consumes(MediaType.APPLICATION_JSON)
//  public Response update(Musician entity) {
//    entity = em.merge(entity);
//    return Response.noContent().build();
//  }
}
