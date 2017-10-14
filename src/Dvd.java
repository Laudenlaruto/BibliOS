/**
 * Created by Titan on 14/10/2017.
 */
public class Dvd extends Media {
    private String realisateur;
    private String acteur;
    private int durée;

    public Dvd(String titre, String genre, String realisateur, String acteur, int durée) {
        super(titre, genre);
        this.realisateur = realisateur;
        this.acteur = acteur;
        this.durée = durée;
    }
}
