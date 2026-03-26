package fr.sebaseg.indie.controller;

import fr.sebaseg.indie.model.data.RevenueData;
import fr.sebaseg.indie.view.ViewInterface;

import java.math.BigDecimal;

public class MainController {
    private final ViewInterface view;

    public MainController(ViewInterface view) {
        this.view = view;
    }

    public void start() {
        view.showWelcomeMessage();

        BigDecimal revenue = BigDecimal.valueOf(readValidRevenue());
        final RevenueData revenueData = new RevenueData(revenue);
        view.showRevenue(revenueData.getRevenue());
    }

    private double readValidRevenue() {
        while (true) {
            try {
                String input = view.promptForRevenue();
                double revenue = Double.parseDouble(input);

                if (revenue > 0) {
                    return revenue;
                }

                view.showErrorMessage("Veuillez saisir une valeur positive.");
            } catch (NumberFormatException e) {
                view.showErrorMessage("Veuillez saisir un nombre valide.");
            }
        }
    }

}
