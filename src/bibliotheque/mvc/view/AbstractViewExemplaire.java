package bibliotheque.mvc.view;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Exemplaire;
import bibliotheque.mvc.controller.AuteurController;
import bibliotheque.mvc.controller.ExemplaireController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;

public abstract class AbstractViewExemplaire implements Observer {
    protected ExemplaireController ExemplaireController;
    protected List<Exemplaire> le;

    public void setController(ExemplaireController exemplaireController) {
        this.ExemplaireController = exemplaireController;
    }

    public abstract void menu();

    public abstract void affList(List le);

    public List<Exemplaire> getAll(){
        return le;
    }

    public void update(List le) {
        this.le = le;
        affList(le);
    }
}
