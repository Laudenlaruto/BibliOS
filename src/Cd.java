/**
 * Created by Titan on 14/10/2017.
 */
public class Cd extends Media {
    private String auteur;
    private String compositeur;
    private int durée;

    public String getAuteur() {
        return auteur;
    }

    public String getCompositeur() {
        return compositeur;
    }

    public int getDurée() {
        return durée;
    }

    public Cd(String titre, String genre, String auteur, String compositeur, int durée) {

        super(titre, genre);
        this.auteur = auteur;
        this.compositeur = compositeur;
        this.durée = durée;
    }
}
