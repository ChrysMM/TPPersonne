package personne.example.tpPersonne.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personne.example.tpPersonne.entity.Activite;
import personne.example.tpPersonne.repository.ActiviteRepository;

import java.util.List;

@Service
public class ActiviteService {

    @Autowired
    ActiviteRepository activiteRepository;

    public List<Activite> getActivites() {

        return activiteRepository.findAll();
    }


    public String addActivite(Activite activite){

        activiteRepository.save(activite);

        return activite + " ajouté à la base";
    }

    public String update(Long id, Activite newActivite) {
        // Recup l'activite
        Activite oldActivite = activiteRepository.getById(id);
        oldActivite.setLibelle(newActivite.getLibelle());
        oldActivite.setDescription(newActivite.getDescription());
        activiteRepository.save(oldActivite);

        return "Update de l'activite" + id;
    }


    public void delete(Long id) {
        Activite activite = activiteRepository.getById(id);
        activiteRepository.delete(activite);
    }

    public Activite finByLibelleAndDescription(String libelle, String description) {
        return activiteRepository.findByLibelleAndDescription(libelle, description);
    }

    public void save(Activite activite) {
        activiteRepository.save(activite);
    }
}
