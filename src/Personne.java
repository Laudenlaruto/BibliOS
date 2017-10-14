import java.util.ArrayList;

/**
 * Created by Titan on 14/10/2017.
 */
public class Personne {
    private String nom;
    private String prenom;
    private ArrayList<Media> historiquePrêt;

    public Personne(String nom, String prenom, ArrayList<Media> historiquePrêt) {
        this.nom = nom;
        this.prenom = prenom;
        this.historiquePrêt = historiquePrêt;
    }
}
