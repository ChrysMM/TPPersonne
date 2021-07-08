package personne.example.tpPersonne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import personne.example.tpPersonne.Service.PersonneService;
import personne.example.tpPersonne.entity.Personne;

import java.util.List;

public class PersonneControllerHtml {
    @Autowired
    PersonneService personneService;

    @GetMapping("/")
    public String accueil(){

        return "index";
    }


    /**
     * la liste des personnes
     * @return La liste des personnes
     */
    @GetMapping("listpersonnes")
    public String getPersonnes(Model model){
        List<Personne> personnes = personneService.getPersonnes();
        model.addAttribute("personnes", personnes);

        return "personnes";
    }



    @GetMapping("ajoutpersonne")
    public String personneForm(Model model) {
        model.addAttribute("personne", new Personne());
        return "ajoutpersonne";
    }

    @PostMapping("ajoutpersonne")
    public String addPersonne(@ModelAttribute Personne personne, Model model) {
        personneService.addPersonne(personne);
        List<Personne> personnes = personneService.getPersonnes();
        model.addAttribute("personnes", personnes);
        return "personnes";
    }

}
