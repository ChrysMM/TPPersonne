package personne.example.tpPersonne.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import personne.example.tpPersonne.entity.Adresse;


public interface AdresseRepository extends JpaRepository<Adresse, Long> {

    Adresse findByNumeroAndRueAndCodePostal(String numero, String rue, String codePostal);
}