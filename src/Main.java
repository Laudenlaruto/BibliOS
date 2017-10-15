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
                    Personne pers = seConnecter();
                    if (pers != null) {
                        int res ;
                        do {
                            res=menuConnecter();
                            if (res == 2) {
                                ArrayList<Livre> livres = rechercherLivre();
                                if (livres.size() > 0) {
                                    afficherListeLivre(livres);
                                }
                            } else if (res == 1) {
                                emprunterLivre(pers);
                            }
                        }while (res!=3);
                    } else
                        System.out.print("Utilisateur non reconnu");
                    break;
                case 2:
                    afficherListeLivre(rechercherLivre());
                    break;

                default:
                    break;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void emprunterLivre(Personne pers) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Entrer le titre du livre que vous voulez emprunter:");
        String titre = reader.nextLine();
        ArrayList<Livre> livresEmprunter = bd.selectLivre(titre);
        if (livresEmprunter.size() > 0) {
            bd.addEmprunt(pers, livresEmprunter.get(0));
            System.out.println("Le livre a été emprunté");
        } else
            System.out.println("Aucun livre ne correspond à voter recherche");
    }

    private static int menuConnecter() {
        Scanner reader = new Scanner(System.in);
        System.out.println("\nEntrer votre choix :\n1 - Emprunter un livre\n2 - Rechercher un livre\n3 - Quitter\n");
        int n = reader.nextInt();
        return n;
    }

    private static ArrayList<Livre> rechercherLivre() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Entrer le titre du livre:");
        String titre = reader.nextLine();
        return bd.selectLivre(titre);
    }

    private static Personne seConnecter() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Entrer votre nom :");
        String nom = reader.nextLine();
        System.out.println("Entrer votre prenom :");
        String prenom = reader.nextLine();
        return bd.selectUser(nom, prenom);
    }

    private static int menuLancement() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Entrer votre choix :\n1 - Se connecter\n2 - Rechercher un livre\n ");
        int n = reader.nextInt();
        return n;
    }


    private static void afficherListeLivre(ArrayList<Livre> livres) {
        System.out.println("Voici la liste des livres :");
        for (Livre livre : livres) {
            System.out.println(livre.toString());
        }
    }
}
