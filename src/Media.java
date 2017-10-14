/**
 * Created by Titan on 14/10/2017.
 */
public class Media {
    private String titre;
    private String genre;

    public Media(String titre, String genre) {
        this.titre = titre;
        this.genre = genre;
    }

    public String getTitre() {
        return titre;
    }

    public String getGenre() {
        return genre;
    }
}
