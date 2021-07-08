package personne.example.tpPersonne.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personne.example.tpPersonne.Service.PersonneService;
import personne.example.tpPersonne.entity.Personne;

import java.util.List;

/**
 * Controller personne
 * @author  ChrystelleMM
 */

@RestController
public class PersonneController {

    @Autowired
    PersonneService personneService;

    /**
     * la liste des personnes
     * @return La liste des personnes
     */
    @GetMapping("personnes")
    public List<Personne> getPersonnes(){

        return personneService.getPersonnes();
    }

    @GetMapping("annuraire/personne/{id}")
    public Personne getPersonne(@PathVariable("id") Long id){
        System.out.println("getPersonne");
        return personneService.getPersonne(id);
    }

    @PostMapping("personne")
    public String addPersonne(@RequestBody Personne p) {
        return personneService.addPersonne(p);
    }

    @PutMapping("personne/{id}")
    public String updatePersonne(@PathVariable("id") Long id, @RequestBody Personne newPersonne){
        return personneService.update(id, newPersonne);
    }

    @DeleteMapping("delete/{id}")
    public String deletePersonne(@PathVariable("id") Long id) {
        personneService.delete(id);
        return  "OK";
    }

    @PutMapping("personne/{idPersonne}/activite/{idActivite}")
    public void inscrirePersonneActivite(@PathVariable("idPersonne") Long idPersonne,
                                         @PathVariable("idActivite") Long idActivite) {
        personneService.inscrirePersonneActivite(idPersonne, idActivite);
    }
}
