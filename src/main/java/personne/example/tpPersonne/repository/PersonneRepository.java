package personne.example.tpPersonne.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import personne.example.tpPersonne.entity.Personne;

import java.util.List;

public interface PersonneRepository extends JpaRepository<Personne, Long> {

    public List<Personne> findAllByNom(String nom);



}

