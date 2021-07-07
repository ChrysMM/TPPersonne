package personne.example.tpPersonne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class AnnuaireController {
    @Autowired
    PersonneService personneService;



    @GetMapping("personnes")
    public List<Personne> afficherLesPersonnes(){

        return personneService.getPersonnes();
}


    @PostMapping("personnePost")
    public void createPersonne(@RequestBody Personne nouvelPersonne) {
        personneService.addPersonne(nouvelPersonne);
    }

        @PostMapping("adresse")
    public void createAdresse(@RequestBody Adresse nouvelleAdresse) { personneService.addAdresse(nouvelleAdresse); }
}
