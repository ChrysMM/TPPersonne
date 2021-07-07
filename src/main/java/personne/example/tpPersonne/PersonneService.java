package personne.example.tpPersonne;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import personne.example.tpPersonne.entity.Activite;
import personne.example.tpPersonne.entity.Adresse;
import personne.example.tpPersonne.entity.Personne;
import personne.example.tpPersonne.repository.ActiviteRepository;
import personne.example.tpPersonne.repository.AdresseRepository;
import personne.example.tpPersonne.repository.PersonneRepository;


import java.util.ArrayList;
import java.util.List;

@Service

public class PersonneService {

    @Autowired
    PersonneRepository personneRepository;
    @Autowired
    AdresseRepository adresseRepository;
    @Autowired
    static
    ActiviteRepository activiteRepository;

    private  List<Personne> toutesLesPersonnes =   new ArrayList<Personne>();


    public  List<Personne> getPersonnes(){
        return personneRepository.findAll() ;
    }

    public void addPersonne(Personne nouvelPersonne) {
        personneRepository.save(nouvelPersonne);
    }
    public void addAdresse(Adresse nouvelleAdresse) {
        adresseRepository.save(nouvelleAdresse);
 }
    public void delete(Long id) {
        Personne p = personneRepository.getById(id);
        personneRepository.delete(p);
    }

    public Personne getPersonne(Long id) {
        return personneRepository.findById(id).get();
    }

    public List<Activite> getActivites() {

        return activiteRepository.findAll();
    }


    public static String addActivite(Activite activite){

        activiteRepository.save(activite);

        return activite + " a bien été ajouté à la base";
    }
    public void deleteActivite(Long id) {
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



