package controller;

import Model.personalCinematograf;
import dao.personalCinematografDao;

import java.util.List;
import java.util.Optional;

public class personalCinematografController {

    private personalCinematografDao personal;

    private personalCinematografController(){
        personal = new personalCinematografDao(ConnectionController.getInstance().getConnection());
    }

    private static final class SingletonHolder{
        private static final personalCinematografController instance = new personalCinematografController();
    }

    public static personalCinematografController getInstance(){
        return SingletonHolder.instance;
    }

    public List<personalCinematograf> findAllPersonal(){
        return personal.findAllPersonal();
    }

    public boolean deletePersonal(String username){
        return  personal.deletePersonal(username);
    }

    public Optional<personalCinematograf> findPersonalByUsername(String username){
        return personal.findPersonalByUsername(username);
    }

    public boolean addPersonal(personalCinematograf pers){
        if(!findPersonalByUsername(pers.getUsername()).isPresent()){
            System.out.println("Personalul s-a adaugat in baza de date");
            System.out.println("------------------------------------------------------------------");
            return personal.addPersonal(pers);
        }else{
            System.out.println("Personalul exista in baza de date");
            return false;
        }
    }

    public boolean loginPersonal(String username,String password){
        Optional<personalCinematograf> op = findPersonalByUsername(username);

        if(op.isPresent()){
            personalCinematograf personal = op.get();
            return personal.getPassword().equals(password);
        }
        return false;
    }
}
