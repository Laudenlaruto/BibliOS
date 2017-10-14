import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Titan on 14/10/2017.
 */
public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("Bonjour, bienvue dans la bibliothéque national");
            ArrayList<Media> medias = new ArrayList<Media>();
            ArrayList<Personne> users = new ArrayList<Personne>();
            BaseDeDonee bd = new BaseDeDonee();
            medias = bd.loadMedia();
            users = bd.loadUsers();




        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
