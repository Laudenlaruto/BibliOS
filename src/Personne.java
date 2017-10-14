import java.util.ArrayList;

/**
 * Created by Titan on 14/10/2017.
 */
public class Personne {
    private String nom;
    private String prenom;
    private ArrayList<Media> historiquePrêt;

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.historiquePrêt = new ArrayList<Media>();
    }
    public void addHistorique(ArrayList<Media> medias){
        this.historiquePrêt = medias;
    }
    public void addToHistorique(Media media){
        this.historiquePrêt.add(media);
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ArrayList<Media> getHistoriquePrêt() {
        return historiquePrêt;
    }
}
