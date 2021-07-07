package personne.example.tpPersonne;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PersonneRepository extends JpaRepository<Personne, Long> {

    public List<Personne> findAllByNom(String nom);


}

