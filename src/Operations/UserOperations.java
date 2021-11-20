package Operations;

import Model.useri;
import controller.useriController;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserOperations {

    private static useriController users = useriController.getInstance();

    public static void userOperations(){

        Scanner scann = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------");
        System.out.println("== BINE AI VENIT ==");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Introduceti comanda pe care o doriti din urmatoarele:");
        System.out.println("'login'\n'inregistrare'\n'exit'");
        System.out.println("------------------------------------------------------------------");

        while (true){
            String command = scann.nextLine();

            switch (command) {

                case "login":
                    System.out.println("Username:");
                    String username = scann.nextLine();
                    System.out.println("Password:");
                    String password = scann.nextLine();
                    boolean in = users.loginUser(username, password);
                    if (in) {
                        System.out.println("Te-ai autentificat cu succes");
                        RezervariOperations.rezervariOperations(username);
                    } else {
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
                        useri us = new useri(1, username2, password2);
                        users.addUser(us);
                    }else{
                        System.out.println("Ai introdus o parola ce nu contine caracterele necesare");
                        System.out.println("Te rugam sa o iei de la inceput si sa introduci o parola potrivita");
                        userOperations();
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
