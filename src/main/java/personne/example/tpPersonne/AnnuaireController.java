package personne.example.tpPersonne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personne.example.tpPersonne.entity.Activite;
import personne.example.tpPersonne.entity.Adresse;
import personne.example.tpPersonne.entity.Personne;

import java.util.List;

@RestController

public class AnnuaireController {
    @Autowired
    PersonneService personneService;



    @GetMapping("personnes")
    public List<Personne> afficherLesPersonnes(){

        return personneService.getPersonnes();
}
    @GetMapping("annuraire/personne/{id}")
    public Personne getPersonne(@PathVariable("id") Long id){
        System.out.println("getPersonne");
        return personneService.getPersonne(id);
    }

    @PostMapping("personnePost")
    public void createPersonne(@RequestBody Personne nouvelPersonne) {
        personneService.addPersonne(nouvelPersonne);
    }

        @PostMapping("adresse")
    public void createAdresse(@RequestBody Adresse nouvelleAdresse) { personneService.addAdresse(nouvelleAdresse); }


    @DeleteMapping("delete/{id}")
    public String deletePersonne(@PathVariable("id") Long id) {
        personneService.delete(id);
        return "Supression OK";
    }

    @GetMapping("activites")
    public List<Activite> getActivite() {
        return personneService.getActivites();
    }

    @PostMapping("activite")
    public String addActivite(@RequestBody Activite activite){
        return PersonneService.addActivite(activite);
    }
}
