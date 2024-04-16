package bibliotheque.mvc.model;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Ouvrage;
import bibliotheque.mvc.observer.Subject;

import java.util.List;

public abstract class DAOOuvrage extends Subject {

    public abstract Ouvrage add(Ouvrage elt) ;

    public abstract boolean remove( Ouvrage elt) ;

    public abstract Ouvrage update(Ouvrage elt) ;

    public abstract Ouvrage read(Ouvrage rech) ;

    public abstract List<Ouvrage> getAll() ;
}
