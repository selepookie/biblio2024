package bibliotheque.mvc.controller;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Lecteur;
import bibliotheque.mvc.model.DAOAuteur;
import bibliotheque.mvc.model.DAOLecteur;
import bibliotheque.mvc.view.AbstractViewAuteur;
import bibliotheque.mvc.view.AbstractViewLecteur;

import java.util.List;

public class LecteurController {

    protected DAOLecteur model;
    protected AbstractViewLecteur view;

    public LecteurController(DAOLecteur model, AbstractViewLecteur view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Lecteur> getAll(){
        List<Lecteur> l = model.getAll();
        return l;
    }

    public Lecteur add( Lecteur elt) {
        Lecteur nelt = model.add(elt);
        return nelt;
    }


    public boolean remove(Lecteur elt) {
        return model.remove(elt);
    }
    public Lecteur update(Lecteur elt) {
        return model.update(elt);
    }

    public Lecteur search(Lecteur rech) {
        return  model.read(rech);
    }
}
