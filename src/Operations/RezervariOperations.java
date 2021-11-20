package Operations;

import Model.rezervariUseri;
import controller.rezervariUseriController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class RezervariOperations {

    private static rezervariUseriController rezv = rezervariUseriController.getInstance();

    public static void rezervariOperations(String username){
        Scanner scann = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------");
        System.out.println("Ai ajuns in meniul de rezervari");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Avem urmatoarele filme disponibile in momentul de fata:");
        System.out.println("fast&furious 9      in salile 1 si 2");
        System.out.println("john wick 3         in salile 3 si 4");
        System.out.println("joker               in salile 5 si 6");
        System.out.println("interstellar        in salile 7 si 8");
        System.out.println("shutter island      in sala 9");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Introduceti comanda pe care o doriti din urmatoarele:");
        System.out.println("'rezervare'\n'afisareRezervari'\n'stergeRezervare'\n'logout'");
        System.out.println("------------------------------------------------------------------");


        while(true) {
            String command = scann.nextLine();

            switch (command) {
                case "rezervare":

                    System.out.println("Introduceti datele clientului");
                    int id = 0;
                    System.out.println("Introduceti filmul: ");
                    String film = scann.nextLine();

                    System.out.println("Introduceti sala: ");
                    int sala = Integer.parseInt(scann.nextLine());

                    if(sala <= 0 || sala > 9){
                        System.out.println("Ai introdus o sala inexistenta");
                        System.out.println("Te rugam, ia-o de la inceput mai cu atentie");
                        rezervariOperations(username);
                    }

                    System.out.println("Introduceti data rezervarii: ");
                    Date data = Date.valueOf(scann.nextLine());

                    rezv.afisareDisponibilitate(sala,data);

                    if(!verificareData(data)){
                        rezervariUseri rezervari = new rezervariUseri(id, username, sala, film, data);
                        rezv.rezervare(rezervari);
                        System.out.println("Rezervare inregistrata cu succes!");
                    }else{
                        System.out.println("Nu ati introdus o data valida");
                        System.out.println("Incercati din nou");
                        rezervariOperations(username);
                    }
                    System.out.println("------------------------------------------------------------------");
                    break;

                case "afisareRezervari":
                    System.out.println("Rezervarile clientului sunt:");
                    rezv.afisareRezervareDupaNume(username).forEach(System.out::println);
                    System.out.println("------------------------------------------------------------------");
                    break;

                case "stergeRezervare":
                    System.out.println("Alege data de la care se va sterge rezervarea");
                    Date data1 = Date.valueOf(scann.nextLine());
                    System.out.println("Introduceti sala in care este facuta rezervarea");
                    int sala3 = Integer.parseInt(scann.nextLine());
                    rezv.stergeRezervare(username,data1,sala3);
                    System.out.println("Rezervarea din sala "+sala3+" a user-ului "+username+ " din data de "+ data1 +" a fost stearsa");
                    System.out.println("------------------------------------------------------------------");
                    break;

                case "logout":
                    UserOperations.userOperations();
                    break;
            }
        }

    }

    public static boolean verificareData(Date data){

        LocalDate dataLocala = LocalDate.now();

        if(dataLocala.isAfter(data.toLocalDate())){
            return true;
        }
        return false;
    }
}
