package fr.sebaseg;

import fr.sebaseg.indie.controller.MainController;
import fr.sebaseg.indie.model.calculators.*;
import fr.sebaseg.indie.view.CommandLineView;
import fr.sebaseg.indie.view.ViewInterface;

public class App {
    public static void main(String[] args) {
        ViewInterface view = new CommandLineView();
        CalculatorInterface taxCalculator = new MicroWithholdTaxCalculator();
        CalculatorInterface socialContributionCalculator = new MicroSocialCalculator();
        CalculatorInterface trainingContributionCalculator = new ProfessionalTrainingContributionCalculator();

        MainController controller = new MainController(
                view,
                taxCalculator,
                socialContributionCalculator,
                trainingContributionCalculator
        );

        controller.start();
    }
}
