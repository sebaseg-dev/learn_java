package fr.sebaseg.indie.view;

import fr.sebaseg.indie.model.data.BusinessActivity;
import fr.sebaseg.indie.model.service.SimulationResult;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
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

    @Override
    public void showResults(SimulationResult results) {
        Map<String, BigDecimal> data = results.getResults();
        BigDecimal turnover = results.turnover();
        BigDecimal taxDeduction = data.get("Tax Deduction").setScale(0, RoundingMode.HALF_UP);
        BigDecimal socialContribution = data.get("Social Contribution").setScale(0, RoundingMode.HALF_UP);
        BigDecimal professionalTrainingContribution = data.get("Professional Training Contribution").setScale(0, RoundingMode.HALF_UP);
        BigDecimal netIncome = turnover.subtract(taxDeduction).subtract(socialContribution).subtract(professionalTrainingContribution);

        System.out.println("++++++++++++++++SHOW RESULTS+++++++++++++++++");

        String border = "---------------------------------------------------------";
        String format = "| %-32s | %18s |%n";

        System.out.println(border);
        System.out.printf(format, "Poste", "Montant");
        System.out.println(border);
        System.out.printf(format, "+ Chiffre d'affaires", String.format("+ %.2f €", turnover));
        System.out.println(border);
        System.out.printf(format, "- Impôt sur le revenu", String.format("- %.2f €", taxDeduction));
        System.out.printf(format, "- Cotisations sociales", String.format("- %.2f €", socialContribution));
        System.out.printf(format, "- CFP*", String.format("- %.2f €", professionalTrainingContribution));
        System.out.println(border);
        System.out.printf(format, "= Revenus nets", String.format("= %.2f €", netIncome));
        System.out.println(border);
        System.out.println();
        System.out.println("(*) CFP = Cotisation à la Formation Professionnelle");
    }

    public void showRevenue(BigDecimal revenue) {
        System.out.println("Le chiffre d'affaires renseigné est de : " + revenue + "€");
    }

    public void showErrorMessage(String message) {
        System.out.println(message);
    }
}
