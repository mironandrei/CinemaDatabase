package main;

import Operations.PersonalOperations;
import Operations.UserOperations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while(true){

            System.out.println("------------------------------------------------------------------");
            System.out.println("Bine ai venit in aplicatia cinematografului !");
            System.out.println("------------------------------------------------------------------");
            System.out.println("Daca doresti sa continui in calitate de client, scrie 'client'. ");
            System.out.println("Pentru a accesa personalul scrie parola de trecere.");
            System.out.println("PS: (Parola este 1234)");
            System.out.println("------------------------------------------------------------------");
            System.out.println("Daca doresti sa inchizi aplicatia, scrie 'exit'.");
            System.out.println("------------------------------------------------------------------");
            String command = scan.nextLine();

            switch (command){

                case "1234":
                    PersonalOperations.personalOperations();
                    break;

                case "client":
                    UserOperations.userOperations();
                    break;

                case "exit":
                    System.exit(0);
                    break;
            }
        }

    }
}
