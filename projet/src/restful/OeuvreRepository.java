package restful;

import modele.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OeuvreRepository extends CrudRepository<Oeuvre, String>{}