package Operations;

import controller.personalCinematografController;
import controller.rezervariUseriController;
import controller.useriController;

import java.sql.Date;
import java.util.Scanner;

public class PersonalRezervariOperations {

    private static personalCinematografController personalC = personalCinematografController.getInstance();
    private static rezervariUseriController rezv = rezervariUseriController.getInstance();
    private static useriController users = useriController.getInstance();

    public static void personalRezervariOperations(){
        Scanner scann = new Scanner(System.in);

        System.out.println("------------------------------------------------------------------");
        System.out.println("Ai ajuns in meniul de rezervari in calitate de personal");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Introduceti comanda pe care o doriti din urmatoarele:");
        System.out.println("'verificareCapacitate'\n'stergeRezervare'\n'stergeUtilizator'\n'verificareRezervari'\n'logout'");
        System.out.println("------------------------------------------------------------------");

        while(true){
            String command = scann.nextLine();

            switch (command){
                case "verificareCapacitate":
                    System.out.println("Introduceti sala dorita: ");
                    int sala = Integer.parseInt(scann.nextLine());
                    System.out.println("Introduceti data dorita: ");
                    Date data1 = Date.valueOf(scann.nextLine());
                    rezv.afisareRezervariDupaSalaSiData(sala,data1).forEach(System.out::println);
                    System.out.println("------------------------------------------------------------------");
                    break;

                case "stergeRezervare":
                    System.out.println("Introduceti numele utilizatorului: ");
                    String nume = scann.nextLine();
                    System.out.println("Introdueti data rezervarii: ");
                    Date data = Date.valueOf(scann.nextLine());
                    System.out.println("Introduceti sala in care este facuta rezervarea");
                    int sala3 = Integer.parseInt(scann.nextLine());
                    rezv.stergeRezervare(nume,data,sala3);
                    System.out.println("Rezervarea din sala "+sala3+" a user-ului "+nume+" din data de "+ data +" a fost stearsa");
                    System.out.println("------------------------------------------------------------------");
                    break;

                case "stergeUtilizator":
                    System.out.println("Introduceti numele utilizatorului: ");
                    String name = scann.nextLine();
                    users.deleteUser(name);
                    System.out.println("Utilizatorul "+name+" a fost sterg din baza de date");
                    System.out.println("------------------------------------------------------------------");
                    break;

                case "verificareRezervari":
                    System.out.println("Introduceti numele utilizatorului: ");
                    String name1 = scann.nextLine();
                    System.out.println("Utilizatorul "+name1+" are urmatoarele rezervari: ");
                    rezv.afisareRezervareDupaNume(name1).forEach(System.out::println);
                    System.out.println("------------------------------------------------------------------");
                    break;

                case "logout":
                    PersonalOperations.personalOperations();
                    break;
            }
        }
    }

}
