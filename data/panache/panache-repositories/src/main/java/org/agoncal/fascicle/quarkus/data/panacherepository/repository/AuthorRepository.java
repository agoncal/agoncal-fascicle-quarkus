package org.agoncal.fascicle.quarkus.data.panacherepository.repository;

import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import org.agoncal.fascicle.quarkus.data.panacherepository.model.Author;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AuthorRepository implements PanacheRepository<Author> {

  public Author update(Author author) {
    return Panache.getEntityManager().merge(author);
  }

  public Optional<Author> findByName(String name) {
    return find("lastName", name).firstResultOptional();
  }

  public List<Author> findAllOrderByName() {
    return listAll(Sort.by("firstName").and("lastName"));
  }
}
