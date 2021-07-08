package personne.example.tpPersonne.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personne.example.tpPersonne.entity.Activite;
import personne.example.tpPersonne.entity.Adresse;
import personne.example.tpPersonne.entity.Personne;
import personne.example.tpPersonne.repository.ActiviteRepository;
import personne.example.tpPersonne.repository.PersonneRepository;

import java.util.List;
import java.util.Set;

@Service
public class PersonneService {
    @Autowired
    PersonneRepository personneRepository;
    @Autowired
    AdresseService adresseService;

    @Autowired
    ActiviteRepository activiteRepository;

    public List<Personne> getPersonnes() {

        return personneRepository.findAll();
    }


    public String addPersonne(Personne p){

        Adresse adresse = p.getAdresse();
        System.out.println(adresse);
        //Verifie que l'adresse existe;
        Adresse adresseBase = adresseService.findByNumeroAndRueAndCodePostal(adresse.getNumero(),
                adresse.getRue(), adresse.getCodePostal());
        System.out.println("Adresse de la base " + adresseBase);
        if (adresseBase == null){
            adresseService.save(adresse);
            p.setAdresse(adresse);
        }else {
            p.setAdresse(adresseBase);
        }
        personneRepository.save(p);
        return p + "ajouté à la base";
    }

    public String update(Long id, Personne newPersonne) {
        // Recupere la personne
        Personne p = personneRepository.getById(id);
        p.setPrenom(newPersonne.getPrenom());
        p.setNom(newPersonne.getNom());
        p.setAge(newPersonne.getAge());
        p.setSexe(newPersonne.getSexe());
        personneRepository.save(p);
        return " Personne update " + id;
    }


    public void delete(Long id) {
        Personne p = personneRepository.getById(id);
        personneRepository.delete(p);
    }

    public Personne getPersonne(Long id) {
        return personneRepository.findById(id).get();
    }

    public void inscrirePersonneActivite(Long idPersonne, Long idActivite) {
        Personne personne = personneRepository.findById(idPersonne).get();
        Activite activite = activiteRepository.findById(idActivite).get();
        Set<Activite> personneActivites = personne.getActivites();
        personneActivites.add(activite);
        personneRepository.save(personne);
    }
}
