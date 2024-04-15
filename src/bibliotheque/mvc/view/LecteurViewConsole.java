package bibliotheque.mvc.view;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Lecteur;
import bibliotheque.metier.TypeLivre;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;
import static bibliotheque.utilitaires.Utilitaire.affListe;

public class LecteurViewConsole extends AbstractViewLecteur{

    Scanner sc = new Scanner(System.in);


    @Override
    public void menu() {
        update(lecteurController.getAll());
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
        int nl = choixElt(listlec)-1;
        Lecteur l = listlec.get(nl);
        boolean ok = lecteurController.remove(l);
        if(ok) affMsg("client effacé");
        else affMsg("client non effacé");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }


    public void rechercher() {
        try {
            System.out.println("numlecteur ");
            int num = sc.nextInt();
            System.out.println("nom ");
            String nom = sc.nextLine();
            System.out.println("prénom ");
            String prenom = sc.nextLine();
            System.out.println("date naissance");
            String date = sc.nextLine();
            LocalDate dn = LocalDate.parse(date);
            //Lecteur rech = new Lecteur(nom, prenom, dn);
            //Lecteur a = lecteurController.search(rech);
            if(a==null) affMsg("lecteur inconnu");
            else {
                affMsg(a.toString());
                special(a);
            }
        }catch(Exception e){
            System.out.println("erreur : "+e);
        }

    }


    public void modifier() {
        int choix = choixElt(listlec);
        Lecteur l = listlec.get(choix-1);
        do {
            try {
                String nom = modifyIfNotBlank("nom", l.getNom());
                String prenom = modifyIfNotBlank("prénom", l.getPrenom());
                l.setNom(nom);
                l.setPrenom(prenom);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
        lecteurController.update(l);
    }


    public void ajouter() {
        Lecteur l;
        do {
            try {
                System.out.println("nom ");
                String nom = sc.nextLine();
                System.out.println("prénom ");
                String prenom = sc.nextLine();
                // l = new Lecteur(nom,prenom);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : "+e.getMessage());
            }
        }while(true);
        lecteurController.add(l);
    }

    // je sais pas quoi mettre comme options ??
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


    @Override
    public void affList(List la) {
        affListe(la);
    }
}
