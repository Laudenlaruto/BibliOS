/**
 * Created by Titan on 14/10/2017.
 */
import java.sql.*;
import java.util.ArrayList;

public class BaseDeDonee {
    public Connection con;

    public BaseDeDonee() throws SQLException, ClassNotFoundException
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bnf","root","");
        /*ResultSet rs=stmt.executeQuery("select * from emp");
        while(rs.next())
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
        con.close();*/
        }catch(Exception e){ System.out.println(e);}
    }

    public ArrayList<Media> loadMedia(){
        ArrayList<Media> medias = new ArrayList<Media>();
        try {
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from livre");
            while (rs.next()){
                medias.add(new Livre(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)));
            }
            ResultSet rs1 = stmt.executeQuery("select * from dvd");
            while (rs1.next()){
                medias.add(new Dvd(rs1.getString(1),rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getInt(5)));
            }
            ResultSet rs2 = stmt.executeQuery("select * from cd");
            while (rs2.next()){
                medias.add(new Cd(rs1.getString(1),rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getInt(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return medias;
    }


    public ArrayList<Personne> loadUsers() {
        ArrayList<Personne> users = new ArrayList<Personne>();

        return users;
    }
}

