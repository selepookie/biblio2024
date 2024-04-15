package bibliotheque.mvc.controller;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Mail;
import bibliotheque.mvc.model.DAOAuteur;
import bibliotheque.mvc.model.DAOMail;
import bibliotheque.mvc.view.AbstractViewAuteur;
import bibliotheque.mvc.view.AbstractViewMail;

import java.util.List;

public class MailController {
    protected DAOMail model;
    protected AbstractViewMail view;

    public MailController(DAOMail model, AbstractViewMail view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Mail> getAll(){
        List<Mail> l = model.getAll();
        return l;
    }

    public Mail add( Mail elt) {
        Mail nelt = model.add(elt);
        return nelt;
    }


    public boolean remove(Mail elt) {
        return model.remove(elt);
    }
    public Mail update(Mail elt) {
        return model.update(elt);
    }

    public Mail search(Mail rech) {
        return  model.read(rech);
    }
}
