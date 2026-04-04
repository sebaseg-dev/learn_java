package fr.sebaseg;

import fr.sebaseg.indie.controller.MainController;
import fr.sebaseg.indie.model.calculators.*;
import fr.sebaseg.indie.model.config.JsonRatesProvider;
import fr.sebaseg.indie.model.service.SimulationService;
import fr.sebaseg.indie.view.CommandLineView;
import fr.sebaseg.indie.view.ViewInterface;

public class App {
    public static void main(String[] args) {
        // View
        ViewInterface view = new CommandLineView();

        // Model
        JsonRatesProvider ratesProvider = new JsonRatesProvider();
        FlatTaxCalculator taxCalculator = new MicroWithholdTaxCalculator(ratesProvider);
        FlatTaxCalculator socialContributionCalculator = new MicroSocialCalculator(ratesProvider);
        FlatTaxCalculator trainingContributionCalculator = new ProfessionalTrainingContributionCalculator(ratesProvider);

        RevenueTaxCalculator revenueTaxCalculator = new RevenueTaxCalculator(ratesProvider);

        SimulationService simulationService = new SimulationService(
                taxCalculator,
                socialContributionCalculator,
                trainingContributionCalculator,
                revenueTaxCalculator
        );

        // Controller
        MainController controller = new MainController(
                view,
                simulationService
        );

        controller.start();
    }
}
