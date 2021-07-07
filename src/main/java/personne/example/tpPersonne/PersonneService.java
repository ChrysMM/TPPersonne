package personne.example.tpPersonne;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;

@Service

public class PersonneService {

    @Autowired
    PersonneRepository personneRepository;
    @Autowired
    AdresseRepository adresseRepository;

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
}
