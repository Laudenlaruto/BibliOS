/**
 * Created by Titan on 14/10/2017.
 */

import java.sql.*;
import java.util.ArrayList;

public class BaseDeDonnee {
    public Connection con;

    public BaseDeDonnee() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bnf", "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Media> loadMedia() {
        ArrayList<Media> medias = new ArrayList<Media>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from livre");
            while (rs.next()) {
                medias.add(new Livre(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
            }
            ResultSet rs1 = stmt.executeQuery("select * from dvd");
            while (rs1.next()) {
                medias.add(new Dvd(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getInt(5)));
            }
            ResultSet rs2 = stmt.executeQuery("select * from cd");
            while (rs2.next()) {
                medias.add(new Cd(rs2.getString(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getInt(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return medias;
    }


    public ArrayList<Personne> loadUsers(ArrayList<Media> medias) {
        ArrayList<Personne> users = new ArrayList<Personne>();
        try {
            Statement stmt2 = con.createStatement();
            ResultSet rs = stmt2.executeQuery("select * from user");
            while (rs.next()) {
                users.add(new Personne(rs.getString(1), rs.getString(2)));
            }

            ResultSet rs2 = stmt2.executeQuery("select * from emprunt");
            while (rs2.next()) {
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getNom().equals(rs2.getString(1))) {
                        for (int j = 0; j < medias.size(); j++) {
                            if (medias.get(j).getTitre().equals(rs2.getString(2))) {
                                users.get(i).addToHistorique(medias.get(j));
                            }
                        }
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void generateRetard() {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from emprunt");
            while (rs.next()) {
                if (rs.getDate(3).before(new java.util.Date())) {
                    System.out.println("Retard de :" + rs.getString(1) + ", media: " + rs.getString(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean selectUser(String nom, String prenom) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            PreparedStatement ps = con.prepareStatement("select * from user where nom =? and prenom=?");
            ps.setString(1,nom);
            ps.setString(2,prenom);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("User :"+ rs.getString(1)+rs.getString(2));
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void addLivre(Livre livre) {
        try {
            PreparedStatement ps = con.prepareStatement("insert into livre values(?,?,?,?,?)");
            ps.setString(1, livre.getTitre());
            ps.setString(2, livre.getGenre());
            ps.setString(3, livre.getAuteur());
            ps.setInt(4, livre.getNbPages());
            ps.setString(5, livre.getISBN());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCd(Cd cd) {
        try {
            PreparedStatement ps = con.prepareStatement("insert into livre values(?,?,?,?,?)");
            ps.setString(1, cd.getTitre());
            ps.setString(2, cd.getGenre());
            ps.setString(3, cd.getAuteur());
            ps.setString(4, cd.getCompositeur());
            ps.setInt(5, cd.getDurée());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCd(Dvd dvd) {
        try {
            PreparedStatement ps = con.prepareStatement("insert into livre values(?,?,?,?,?)");
            ps.setString(1, dvd.getTitre());
            ps.setString(2, dvd.getGenre());
            ps.setString(3, dvd.getRealisateur());
            ps.setString(4, dvd.getActeur());
            ps.setInt(5, dvd.getDurée());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(Personne personne) {
        try {
            PreparedStatement ps = con.prepareStatement("insert into user values(?,?)");
            ps.setString(1, personne.getNom());
            ps.setString(2, personne.getPrenom());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEmprunt(Personne personne, Media media) {
        try {
            PreparedStatement ps = con.prepareStatement("insert into emprunt values(?,?,?)");
            ps.setString(1, personne.getNom());
            ps.setString(2, media.getTitre());
            java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
            ps.setDate(3, sqlDate);
            ps.executeUpdate();
            personne.addToHistorique(media);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

