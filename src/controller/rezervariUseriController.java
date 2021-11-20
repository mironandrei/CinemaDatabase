package controller;

import Model.rezervariUseri;
import dao.rezervariUseriDao;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class rezervariUseriController {

    private rezervariUseriDao rezervari;

    private rezervariUseriController(){
        rezervari = new rezervariUseriDao(ConnectionController.getInstance().getConnection());

    }

    private static final class singletonHolder{
        private static final rezervariUseriController instance = new rezervariUseriController();
    }

    public static final rezervariUseriController getInstance(){
        return singletonHolder.instance;
    }

    public boolean rezervare(rezervariUseri client){
        return rezervari.rezervare(client);
    }

    public List<rezervariUseri> afisareRezervari(){
        return rezervari.afisareRezervari();
    }

    public List<rezervariUseri> afisareRezervareDupaNume(String username){
        return rezervari.afisareRezervareDupaNume(username);
    }

    public boolean stergeRezervare(String username, Date data,int sala){
        return rezervari.stergeRezervare(username,data,sala);
    }

    public List<rezervariUseri> afisareRezervariDupaSalaSiData(int sala, Date data){
        return rezervari.afisareRezervariDupaSalaSiData(sala,data);
    }

    public List<rezervariUseri> afisareDisponibilitate(int sala, Date data){
        return rezervari.afisareDisponibilitate(sala,data);
    }
}
