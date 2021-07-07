package personne.example.tpPersonne.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import personne.example.tpPersonne.entity.Activite;

public interface ActiviteRepository extends JpaRepository<Activite, Long> {
    Activite findByLibelleAndDescription(String libelle, String description);
}

