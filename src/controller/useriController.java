package controller;

import Model.useri;
import dao.useriDao;

import java.util.List;
import java.util.Optional;

public class useriController {

    private useriDao userDao;

    private useriController(){
        userDao = new useriDao(ConnectionController.getInstance().getConnection());
    }

    private static final class SingletonHolder{
        private static final useriController instance = new useriController();

    }

    public static useriController getInstance(){
        return SingletonHolder.instance;
    }

    public List<useri> getAllUsers(){
        return userDao.getAllUsers();
    }

    public boolean deleteUser(String username){
        return userDao.deleteUser(username);
    }

    public Optional<useri> getUserByUsername(String username){
        return userDao.getUserByUsername(username);
    }

    public boolean addUser(useri user){
        if(!getUserByUsername(user.getUsername()).isPresent()){
            System.out.println("User-ul s-a adaugat in baza de date");
            System.out.println("------------------------------------------------------------------");
            return userDao.addUser(user);
        }else{
            System.out.println("Userul exista in baza de date");
            return false;
        }
    }

    public boolean loginUser(String username, String password){
        Optional<useri> op = getUserByUsername(username);

        if(op.isPresent()){
            useri u = op.get();
            return u.getPassword().equals(password);
        }
        return false;
    }
}
