package personne.example.tpPersonne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import personne.example.tpPersonne.Service.AdresseService;
import personne.example.tpPersonne.entity.Adresse;

import java.util.List;

    @RestController
    public class AdresseController {
    @Autowired
    AdresseService adresseService;

    @GetMapping("adresses")
    public List<Adresse> getAdresses(){

        return adresseService.getAdresses();
    }
}