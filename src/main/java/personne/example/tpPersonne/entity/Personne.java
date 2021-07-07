package personne.example.tpPersonne.entity;

import personne.example.tpPersonne.entity.Adresse;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="personne")

    public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long id;
    private String nom;
    private String prenom;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_adresse")
    private Adresse adresse;

    @ManyToMany
    @JoinTable(name = "personne_activite", joinColumns = @JoinColumn(name="personne_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "activite_id", referencedColumnName = "id"))
    //@JsonIgnore
    private Set<Activite> activites = new HashSet<>();

    public Personne() {
    }

    public Personne(Long id, String nom, String prenom, Adresse adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse=" + adresse +
                '}';
    }


}


