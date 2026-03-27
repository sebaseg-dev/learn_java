package fr.sebaseg;

import fr.sebaseg.indie.controller.MainController;
import fr.sebaseg.indie.model.calculators.*;
import fr.sebaseg.indie.model.config.JsonRatesProvider;
import fr.sebaseg.indie.view.CommandLineView;
import fr.sebaseg.indie.view.ViewInterface;

public class App {
    public static void main(String[] args) {
        // View
        ViewInterface view = new CommandLineView();

        // Model
        JsonRatesProvider ratesProvider = new JsonRatesProvider();
        CalculatorInterface taxCalculator = new MicroWithholdTaxCalculator(ratesProvider);
        CalculatorInterface socialContributionCalculator = new MicroSocialCalculator(ratesProvider);
        CalculatorInterface trainingContributionCalculator = new ProfessionalTrainingContributionCalculator(ratesProvider);

        // Controller
        MainController controller = new MainController(
                view,
                taxCalculator,
                socialContributionCalculator,
                trainingContributionCalculator
        );

        controller.start();
    }
}
