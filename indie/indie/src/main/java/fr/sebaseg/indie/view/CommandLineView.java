package fr.sebaseg.indie.view;

import fr.sebaseg.indie.model.data.BusinessActivity;
import fr.sebaseg.indie.model.service.SimulationResult;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CommandLineView implements ViewInterface {
    private final ResourceBundle messages = ResourceBundle.getBundle("messages", Locale.FRANCE);
    private final Scanner sc = new Scanner(System.in);

    public CommandLineView() {
    }

    public void showWelcomeMessage() {
        System.out.println(messages.getString("welcome"));
    }

    @Override
    public String promptForActivity(String[] activities) {
        System.out.println(messages.getString("askActivityType"));
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

    public String promptForTurnover() {
        System.out.println(messages.getString("askTurnover"));
        return sc.nextLine();
    }

    @Override
    public void showResults(SimulationResult results) {
        BigDecimal turnover = results.turnover();
        BigDecimal withholdTaxes = results.taxWithholding().setScale(2, RoundingMode.HALF_UP);
        BigDecimal revenueTaxes = results.revenueTaxes().setScale(2, RoundingMode.HALF_UP);
        BigDecimal socialContribution = results.socialContribution().setScale(2, RoundingMode.HALF_UP);
        BigDecimal professionalTrainingContribution = results.professionalTrainingContribution().setScale(2, RoundingMode.HALF_UP);
        BigDecimal netIncomeAfterWithholdingTaxes = results.netIncomeAfterWithholdingTaxes().setScale(2, RoundingMode.HALF_UP);
        BigDecimal netIncomeAfterRevenueTaxes = results.netIncomeAfterRevenueTaxes().setScale(2, RoundingMode.HALF_UP);

        System.out.println("++++++++++++++++SHOW RESULTS+++++++++++++++++");

        String border = "------------------------------------------------------------------------------";
        String format = "| %-32s | %18s | %18s |%n";
        String numberFormat = "- %,.2f €";

        System.out.println(border);
        System.out.printf(format, "Poste", "Option PFL (*)", "Régime standard IR");
        System.out.println(border);
        System.out.printf(
                format,
                "+ Chiffre d'affaires",
                String.format(numberFormat, turnover),
                String.format(numberFormat, turnover)
        );
        System.out.println(border);
        System.out.printf(
                format,
                "- Impôt sur le revenu",
                String.format(numberFormat, withholdTaxes),
                String.format(numberFormat, revenueTaxes)
        );
        System.out.printf(
                format,
                "- Cotisations sociales",
                String.format(numberFormat, socialContribution),
                String.format(numberFormat, socialContribution)
        );
        System.out.printf(
                format, "- CFP (**)",
                String.format(numberFormat, professionalTrainingContribution),
                String.format(numberFormat, professionalTrainingContribution)
        );
        System.out.println(border);
        System.out.printf(
                format, "= Revenus nets",
                String.format(numberFormat, netIncomeAfterWithholdingTaxes),
                String.format(numberFormat, netIncomeAfterRevenueTaxes)
        );
        System.out.println(border);
        System.out.println();
        System.out.println("(*) PFV = Option pour le Prélèvement Forfaitaire Libératoire de l'impôt sur le revenu");
        System.out.println("(**) CFP = Cotisation à la Formation Professionnelle");
    }

    public void showRevenue(BigDecimal revenue) {
        System.out.println("Le chiffre d'affaires renseigné est de : " + revenue + "€");
    }

    public void showErrorMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showGoodbyeMessage() {
        System.out.println(messages.getString("goodbye"));
    }
}
