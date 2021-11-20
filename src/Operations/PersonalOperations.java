package Operations;

import Model.personalCinematograf;
import controller.personalCinematografController;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonalOperations {

    private static personalCinematografController personalC = personalCinematografController.getInstance();

    public static void personalOperations(){

        Scanner scann = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------");
        System.out.println("== PERSONAL ==");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Introduceti comanda pe care o doriti din urmatoarele:");
        System.out.println("'login'\n'inregistrare'\n'exit'");
        System.out.println("------------------------------------------------------------------");

        while(true){

            String command = scann.nextLine();

            switch (command){

                case "login":
                    System.out.println("Username:");
                    String username = scann.nextLine();
                    System.out.println("Password:");
                    String password = scann.nextLine();

                    boolean in = personalC.loginPersonal(username,password);
                    if(in){
                        System.out.println("Te-ai autentificat cu succes");
                        PersonalRezervariOperations.personalRezervariOperations();
                    }else{
                        System.out.println("Username-ul sau parola gresita!");
                        System.out.println("------------------------------------------------------------------");
                    }
                    break;

                case "inregistrare":
                    System.out.println("Username:");
                    String username2 = scann.nextLine();
                    System.out.println("Password:");
                    String password2 = scann.nextLine();

                    if (validareParola(password2)){
                        personalCinematograf pers = new personalCinematograf(1,username2,password2);
                        personalC.addPersonal(pers);
                    }else{
                        System.out.println("Ai introdus o parola ce nu contine caracterele necesare");
                        System.out.println("Te rugam sa o iei de la inceput si sa introduci o parola potrivita");
                        personalOperations();
                    }
                    break;

                case "exit":
                    System.exit(0);
                    break;
            }
        }
    }

    public static boolean validareParola(String password)
    {

        if(true)
        {
            Pattern digit = Pattern.compile("[0-9]");
            Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

            Matcher hasDigit = digit.matcher(password);
            Matcher hasSpecial = special.matcher(password);

            return hasDigit.find() && hasSpecial.find();
        }
        else
            return false;

    }
}
