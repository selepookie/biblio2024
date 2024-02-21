package bibliotheque.metier;

import java.time.LocalDate;
import java.util.List;

public class Livre extends Ouvrage {
    private String isbn;
    private int nombrePages;
    private TypeLivre typeLivre;
    private String resume;

    public Livre(String titre, byte ageMin, LocalDate dateParution, TypeOuvrage typeOuvrage, double prixLocation, String langue, String genre, String isbn, int nombrePages, TypeLivre typeLivre, String resume) {
        super(titre, ageMin, dateParution, typeOuvrage, prixLocation, langue, genre);
        this.isbn=isbn;
        this.nombrePages=nombrePages;
        this.typeLivre=typeLivre;
        this.resume=resume;

    }

    public double amendeRetard(int oui){
        double cc=0;
        System.out.println("coucou");
        return cc;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(int nombrePages) {
        this.nombrePages = nombrePages;
    }

    public TypeLivre getTypeLivre() {
        return typeLivre;
    }

    public void setTypeLivre(TypeLivre typeLivre) {
        this.typeLivre = typeLivre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "isbn='" + isbn + '\'' +
                ", nombrePages=" + nombrePages +
                ", typeLivre=" + typeLivre +
                ", resume='" + resume + '\'' +
                '}';
    }
}
