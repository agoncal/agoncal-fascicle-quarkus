package org.agoncal.fascicle.quarkus.data.panacherepository.service;

import io.quarkus.hibernate.orm.panache.Panache;
import org.agoncal.fascicle.quarkus.data.panacherepository.model.Author;
import org.agoncal.fascicle.quarkus.data.panacherepository.repository.AuthorRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static jakarta.transaction.Transactional.TxType.REQUIRED;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(SUPPORTS)
public class AuthorService {

  @Inject
  AuthorRepository repository;

  @Transactional(REQUIRED)
  public Author persist(Author author) {
    repository.persist(author);
    return author;
  }

  public List<Author> findAll() {
    return repository.listAll();
  }

  public Optional<Author> findByIdOptional(Long id) {
    return repository.findByIdOptional(id);
  }

  @Transactional(REQUIRED)
  public Author update(Author author) {
    return Panache.getEntityManager().merge(author);
  }

  @Transactional(REQUIRED)
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

  public Optional<Author> findByName(String name) {
    return repository.findByName(name);
  }

  public List<Author> findAllOrderByName() {
    return repository.findAllOrderByName();
  }
}
