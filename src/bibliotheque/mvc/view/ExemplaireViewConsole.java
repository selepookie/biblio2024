package bibliotheque.mvc.view;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;
import bibliotheque.mvc.controller.ExemplaireController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;
import static bibliotheque.utilitaires.Utilitaire.affListe;

public class ExemplaireViewConsole extends AbstractViewExemplaire{
    Scanner sc = new Scanner(System.in);


    @Override
    public void menu() {
        update(ExemplaireController.getAll());
        List options = Arrays.asList("ajouter", "retirer", "rechercher","modifier","fin");
        do {
            int ch = choixListe(options);

            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    rechercher();
                    break;
                case 4:
                    modifier();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    private void retirer() {
        int nl = choixElt(le)-1;
        Exemplaire e = le.get(nl);
        boolean ok = ExemplaireController.remove(e);
        if(ok) affMsg("exemplaire effacé");
        else affMsg("exemplaire non effacé");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }


    public void rechercher() {
        try {
            System.out.println("nom ");
            String nom = sc.nextLine();
            System.out.println("prénom ");
            String prenom = sc.nextLine();
            System.out.println("nationalité");
            String nat = sc.nextLine();
            Auteur rech = new Auteur(nom, prenom, nat);
            Auteur a = ExemplaireController.search(rech);
            if(a==null) affMsg("auteur inconnu");
            else {
                affMsg(a.toString());
                special(a);
            }
        }catch(Exception e){
            System.out.println("erreur : "+e);
        }

    }


    public void modifier() {
        int choix = choixElt(le);
        Exemplaire ex = le.get(choix-1);
        do {
            try {
                String mat = modifyIfNotBlank("matricule", ex.getMatricule());
                String descetat = modifyIfNotBlank("desc etat", ex.getDescriptionEtat());
                // Ouvrage ouv = modifyIfNotBlank("ouvrage",ex.getOuvrage())
                // jpense pas qui faut vu qu'on recup l'ouvrage autre part
                ex.setMatricule(mat);
                ex.setDescriptionEtat(descetat);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        ExemplaireController.update(ex);
    }


    public void ajouter() {
        Exemplaire ex;
        do {
            try {
                System.out.println("matricule ");
                String mat = sc.nextLine();
                System.out.println("description etat ");
                String descetat = sc.nextLine();
                System.out.println("ouvrage");
                // ouv =
                // ouvrage ??
                // ex = new Exemplaire(mat,descetat,ouv);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : "+e.getMessage());
            }
        }while(true);
        ExemplaireController.add(ex);
    }

    public void special(Auteur a) {

        List options = Arrays.asList("lister ouvrages", "lister livres", "lister par genre","fin");
        do {
            int ch = choixListe(options);

            switch (ch) {

                case 1:
                    listerOuvrages(a);
                    break;
                case 2:
                    listerLivres(a);
                    break;
                case 3:
                    listerGenre(a);
                    break;
                case 4 :return;
            }
        } while (true);

    }


    // jsp je dois lister quoi

    @Override
    public void affList(List la) {
        affListe(la);
    }
}
