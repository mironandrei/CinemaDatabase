package dao;

import Model.useri;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class useriDao {

    private Connection con;

    private PreparedStatement addUser;
    private PreparedStatement findAllUsers;
    private PreparedStatement findUserByUsername;
    private PreparedStatement deleteUser;

    public useriDao(Connection con){
        this.con = con;

        try {
            addUser = con.prepareStatement("INSERT INTO useri VALUES(null,?,?)");
            findAllUsers = con.prepareStatement("SELECT * FROM useri");
            findUserByUsername = con.prepareStatement("SELECT * FROM useri WHERE username = ?");
            deleteUser = con.prepareStatement("DELETE FROM useri WHERE username = ?");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean addUser(useri user){
        try {
            addUser.setString(1,user.getUsername());
            addUser.setString(2,user.getPassword());
            return addUser.executeUpdate() != 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public List<useri> getAllUsers(){
        ArrayList<useri> lista = new ArrayList<>();

        try {
            ResultSet rs = findAllUsers.executeQuery();
            while(rs.next()){
                useri newUser = new useri(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"));
                lista.add(newUser);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lista;
    }

    public Optional<useri> getUserByUsername(String username){
        try {
            findUserByUsername.setString(1,username);

            ResultSet rs = findUserByUsername.executeQuery();

            if(rs.next()){
                return Optional.of(new useri(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password")));

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean deleteUser(String username){
        try {
            deleteUser.setString(1,username);
            return deleteUser.executeUpdate() != 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }
}
