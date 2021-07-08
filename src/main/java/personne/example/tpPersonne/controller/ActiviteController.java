package personne.example.tpPersonne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import personne.example.tpPersonne.Service.ActiviteService;
import personne.example.tpPersonne.entity.Activite;

import java.util.List;

    @RestController
    public class ActiviteController {
    @Autowired
    ActiviteService activiteService;

    @GetMapping("activites")
    public List<Activite> getActivite() {
        return activiteService.getActivites();
    }

    @PostMapping("activite")
    public String addActivite(@RequestBody Activite activite){
        return activiteService.addActivite(activite);
    }
}