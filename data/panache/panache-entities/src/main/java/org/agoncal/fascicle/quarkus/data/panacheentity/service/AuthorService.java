package org.agoncal.fascicle.quarkus.data.panacheentity.service;

import io.quarkus.hibernate.orm.panache.Panache;
import org.agoncal.fascicle.quarkus.data.panacheentity.model.Author;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static jakarta.transaction.Transactional.TxType.REQUIRED;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(SUPPORTS)
public class AuthorService {

  @Transactional(REQUIRED)
  public Author persist(Author author) {
    Author.persist(author);
    return author;
  }

  public List<Author> findAll() {
    return Author.listAll();
  }

  public Optional<Author> findByIdOptional(Long id) {
    return Author.findByIdOptional(id);
  }

  @Transactional(REQUIRED)
  public Author update(Author author) {
    return Panache.getEntityManager().merge(author);
  }

  @Transactional(REQUIRED)
  public void deleteById(Long id) {
    Author.deleteById(id);
  }

  public Optional<Author> findByName(String name) {
    return Author.findByName(name);
  }

  public List<Author> findAllOrderByName() {
    return Author.findAllOrderByName();
  }
}
