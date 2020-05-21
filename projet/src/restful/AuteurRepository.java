package restful;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import modele.Auteur;

@RepositoryRestResource
public interface AuteurRepository extends JpaRepository<Auteur, String>{}