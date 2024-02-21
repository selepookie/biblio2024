package bibliotheque.metier;

import java.util.ArrayList;
import java.util.List;

public class Exemplaire {
    private String matricule;
    private String descriptionOuvrage;
    private Ouvrage ouvrage;
    private Rayon rayon;
    private List<Location> locations = new ArrayList<>();

    public Exemplaire(String matricule, String descriptionOuvrage, Ouvrage ouvrage) {
        this.matricule = matricule;
        this.descriptionOuvrage = descriptionOuvrage;
        this.ouvrage = ouvrage;
    }

    public Exemplaire(){}

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDescriptionOuvrage() {
        return descriptionOuvrage;
    }

    public void setDescriptionOuvrage(String descriptionOuvrage) {
        this.descriptionOuvrage = descriptionOuvrage;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        this.rayon = rayon;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

}
