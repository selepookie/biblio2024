package bibliotheque.mvc.view;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.mvc.controller.AuteurController;
import bibliotheque.mvc.controller.ExemplaireController;
import bibliotheque.mvc.controller.LecteurController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;

public abstract class AbstractViewLecteur implements Observer {

    protected LecteurController lecteurController;
    protected List<Lecteur> listlec;

    public void setController(LecteurController lecteurController) {
        this.lecteurController = lecteurController;
    }

    public abstract void menu();

    public abstract void affList(List la);

    public List<Lecteur> getAll(){
        return listlec;
    }
    @Override
    public void update(List listlec) {
        this.listlec = listlec;
        affList(listlec);
    }

}
