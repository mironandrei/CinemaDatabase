package dao;

import Model.personalCinematograf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class personalCinematografDao {

    private Connection con;

    private PreparedStatement addPersonal;
    private PreparedStatement findAllPersonal;
    private PreparedStatement findPersonalByUsername;
    private PreparedStatement deletePersonal;

    public personalCinematografDao(Connection con){
        this.con = con;

        try {
            addPersonal = con.prepareStatement("INSERT INTO personalcinematograf VALUES(null,?,?)");
            findAllPersonal = con.prepareStatement("SELECT * FROM personalcinematograf");
            findPersonalByUsername = con.prepareStatement("SELECT * FROM personalcinematograf WHERE username = ?");
            deletePersonal = con.prepareStatement("DELETE FROM personalcinematograf WHERE username = ?");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public boolean addPersonal(personalCinematograf personal){
        try {
            addPersonal.setString(1,personal.getUsername());
            addPersonal.setString(2,personal.getPassword());
            return addPersonal.executeUpdate() != 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public List<personalCinematograf> findAllPersonal(){
        ArrayList<personalCinematograf> lista = new ArrayList<>();

        try {
            ResultSet rs = findAllPersonal.executeQuery();

            while(rs.next()){
                personalCinematograf personal = new personalCinematograf(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"));
                lista.add(personal);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lista;
    }

    public Optional<personalCinematograf> findPersonalByUsername(String username){

        try {
            findPersonalByUsername.setString(1,username);

            ResultSet rs = findPersonalByUsername.executeQuery();

            if(rs.next()){
                return Optional.of(new personalCinematograf(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Optional.empty();
    }

    public boolean deletePersonal(String username){

        try {
            deletePersonal.setString(1,username);
            return deletePersonal.executeUpdate() != 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
