import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Titan on 14/10/2017.
 */
public class Main {
    private static BaseDeDonnee bd;
    public static void main(String[] args) {

        try {
            System.out.println("Bonjour, bienvenue dans la bibliothéque nationale de France");
            ArrayList<Media> medias = new ArrayList<Media>();
            ArrayList<Personne> users = new ArrayList<Personne>();
            bd = new BaseDeDonnee();
            medias = bd.loadMedia();
            users = bd.loadUsers(medias);

            switch (menuLancement()) {
                case 1:
                    if(seConnecter()){
                        int res = menuConnecter();
                    }else
                        System.out.print("Utilisateur non reconnu");
                    break;
                case 2:
                    rechercherLivre();
                    break;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static int menuConnecter() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Entrer votre choix :\n1 - Emprunter un livre\n2 - Rechercher un livre\n ");
        int n = reader.nextInt();
        return n;
    }

    private static void rechercherLivre() {
    }

    private static boolean seConnecter() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Entrer votre nom :");
        String nom = reader.nextLine();
        System.out.println("Entrer votre prenom :");
        String prenom = reader.nextLine();
        return bd.selectUser(nom,prenom);
    }

    private static int menuLancement() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Entrer votre choix :\n1 - Se connecter\n2 - Rechercher un livre\n ");
        int n = reader.nextInt();
        return n;
    }
}
