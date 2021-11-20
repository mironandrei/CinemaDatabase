package dao;

import Model.rezervariUseri;
import Operations.RezervariOperations;
import Operations.UserOperations;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class rezervariUseriDao {
    private Connection con;

    private PreparedStatement rezervare;
    private PreparedStatement afisareRezervari;
    private PreparedStatement afisareRezervareDupaNume;
    private PreparedStatement stergeRezervare;
    private PreparedStatement afisareRezervariDupaSalaSiData;
    private PreparedStatement afisareDisponibilitate;

    public rezervariUseriDao(Connection con){
        this.con = con;

        try {
            rezervare = con.prepareStatement("INSERT INTO rezervariuseri VALUES(null,?,?,?,?)");
            afisareRezervari = con.prepareStatement("SELECT * FROM rezervariuseri");
            afisareRezervareDupaNume = con.prepareStatement("SELECT * FROM rezervariuseri WHERE username = ?");
            stergeRezervare = con.prepareStatement("DELETE FROM rezervariuseri WHERE username = ? AND data = ? AND sala = ?");
            afisareRezervariDupaSalaSiData = con.prepareStatement("SELECT * FROM rezervariuseri WHERE sala = ? AND data = ?");
            afisareDisponibilitate = con.prepareStatement("SELECT * FROM rezervariuseri WHERE sala = ? AND data = ?");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean rezervare(rezervariUseri user){
        try {
            rezervare.setString(1,user.getUsername());
            rezervare.setInt(2,user.getSala());
            rezervare.setString(3,user.getFilm());
            rezervare.setDate(4,user.getData());

            return rezervare.executeUpdate() != 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public List<rezervariUseri> afisareRezervari(){
        ArrayList<rezervariUseri> lista = new ArrayList<>();

        try {
            ResultSet rs = afisareRezervari.executeQuery();

            while(rs.next()){

                rezervariUseri rezerv = new rezervariUseri(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getInt("sala"),
                        rs.getString("film"),
                        rs.getDate("data"));

                lista.add(rezerv);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lista;
    }

    public List<rezervariUseri> afisareRezervareDupaNume(String username){
        ArrayList<rezervariUseri> rezervari = new ArrayList<>();
        try {

            afisareRezervareDupaNume.setString(1,username);
            ResultSet rs = afisareRezervareDupaNume.executeQuery();

            while(rs.next()){
                rezervariUseri rez = new rezervariUseri(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getInt("sala"),
                        rs.getString("film"),
                        rs.getDate("data"));
            rezervari.add(rez);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rezervari;
    }

    public boolean stergeRezervare(String username,Date data, int sala){
        try {
            stergeRezervare.setString(1,username);
            stergeRezervare.setDate(2,data);
            stergeRezervare.setInt(3,sala);
            return stergeRezervare.executeUpdate() != 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public List<rezervariUseri> afisareRezervariDupaSalaSiData(int sala, Date data){
        ArrayList<rezervariUseri> lista = new ArrayList<>();
        int counter = 0;

        try {
            afisareRezervariDupaSalaSiData.setInt(1,sala);
            afisareRezervariDupaSalaSiData.setDate(2,data);

            ResultSet rs = afisareRezervariDupaSalaSiData.executeQuery();

            while(rs.next()){
                rezervariUseri rez = new rezervariUseri(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getInt("sala"),
                        rs.getString("film"),
                        rs.getDate("data"));

                lista.add(rez);
                counter++;
            }

            System.out.println("Au mai ramas "+ (20-counter) +" locuri in sala "+sala+" pentru data de "+data);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return lista;
    }


    public List<rezervariUseri> afisareDisponibilitate(int sala, Date data){
        ArrayList<rezervariUseri> lista = new ArrayList<>();
        int counter = 0;

        try {
            afisareDisponibilitate.setInt(1,sala);
            afisareDisponibilitate.setDate(2,data);

            ResultSet rs = afisareDisponibilitate.executeQuery();

            while(rs.next()){
                rezervariUseri rez = new rezervariUseri(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getInt("sala"),
                        rs.getString("film"),
                        rs.getDate("data"));

                lista.add(rez);
                counter++;
            }

            if(counter == 20) {
                System.out.println("Sala plina!");
                System.out.println("Incercati alta sala sau alta zi");
                UserOperations.userOperations();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return lista;
    }
}
