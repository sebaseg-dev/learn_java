package fr.sebaseg.indie.view;

import java.util.Scanner;

public class CommandLineView {
    private final Scanner sc = new Scanner(System.in);

    public CommandLineView() {
    }

    public void showWelcomeMessage() {
        System.out.println("Welcome to indie v1");
    }

    public String promptForRevenue() {
        System.out.println("Veuillez renseigner votre chiffre d'affaires prévisionnel pour l'année:");
        return sc.nextLine();
    }

    public void showRevenue(double revenue) {
        System.out.println("Le chiffre d'affaires renseigné est de : " + revenue + "€");
    }

    public void showErrorMessage(String message) {
        System.out.println(message);
    }
}
