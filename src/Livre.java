/**
 * Created by Titan on 14/10/2017.
 */
public class Livre extends Media {
    private String auteur;
    private int nbPages;
    private String ISBN;

    public Livre(String titre, String genre, String auteur, int nbPages, String ISBN) {
        super(titre, genre);
        this.auteur = auteur;
        this.nbPages = nbPages;
        this.ISBN = ISBN;
    }

}