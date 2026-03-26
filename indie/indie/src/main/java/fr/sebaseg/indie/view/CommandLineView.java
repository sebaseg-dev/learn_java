package fr.sebaseg.indie.view;

import fr.sebaseg.indie.model.data.BusinessActivity;

import java.math.BigDecimal;
import java.util.Scanner;

public class CommandLineView implements ViewInterface {
    private final Scanner sc = new Scanner(System.in);

    public CommandLineView() {
    }

    public void showWelcomeMessage() {
        System.out.println("Welcome to indie v1");
    }

    @Override
    public String promptForActivity(String[] activities) {
        System.out.println("Veuillez choisir la catégorie de votre activité parmi les propositions suivantes:");
        for(int i = 0; i < activities.length; i++) {
            System.out.println(i + " - " + activities[i]);
        }
        return sc.nextLine();
    }

    @Override
    public void showActivity(BusinessActivity activity) {
        System.out.println("L'activité choisie par l'utilisateur est : " + activity.name());
        System.out.println("Cela correspond à une catégorie d'impôts : " + activity.getTaxCategory());
        System.out.println("Cela correspond à une catégorie sociale : " + activity.getSocialCategory());
        System.out.println("Cela correspond à une catégorie CFP : " + activity.getProfessionalTrainingContribution());
    }

    public String promptForRevenue() {
        System.out.println("Veuillez renseigner votre chiffre d'affaires prévisionnel pour l'année:");
        return sc.nextLine();
    }

    public void showRevenue(BigDecimal revenue) {
        System.out.println("Le chiffre d'affaires renseigné est de : " + revenue + "€");
    }

    public void showErrorMessage(String message) {
        System.out.println(message);
    }
}
