package bibliotheque.mvc.view;

import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Ouvrage;
import bibliotheque.mvc.controller.LecteurController;
import bibliotheque.mvc.controller.OuvrageController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;

public abstract class AbstractViewOuvrage implements Observer {

    protected OuvrageController ouvrageController;
    protected List<Ouvrage> listlec;

    public void setController(OuvrageController ouvrageController) {
        this.ouvrageController = ouvrageController;
    }

    public abstract void menu();

    public abstract void affList(List la);

    public List<Ouvrage> getAll(){
        return listlec;
    }
    @Override
    public void update(List listlec) {
        this.listlec = listlec;
        affList(listlec);
    }
}
