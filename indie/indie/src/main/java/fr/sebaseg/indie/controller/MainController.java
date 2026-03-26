package fr.sebaseg.indie.controller;

import fr.sebaseg.indie.model.calculators.MicroSocialCalculator;
import fr.sebaseg.indie.model.calculators.MicroTaxCalculator;
import fr.sebaseg.indie.model.calculators.ProfessionalTrainingContributionCalculator;
import fr.sebaseg.indie.model.data.BusinessActivity;
import fr.sebaseg.indie.model.data.EntrepreneurProfile;
import fr.sebaseg.indie.model.service.SimulationResult;
import fr.sebaseg.indie.model.service.SimulationService;
import fr.sebaseg.indie.view.ViewInterface;

import java.math.BigDecimal;

public class MainController {
    private final ViewInterface view;

    public MainController(ViewInterface view) {
        this.view = view;
    }

    public void start() {
        view.showWelcomeMessage();

        BusinessActivity activity = readValidActivity();
        boolean hasACRE = false;
        boolean hasTaxWithholding = true;
        BigDecimal turnover = readValidTurnover();

        EntrepreneurProfile profile = new EntrepreneurProfile(activity, hasACRE, hasTaxWithholding, turnover);

        view.showActivity(profile.getActivity());
        view.showRevenue(profile.getTurnover());

        MicroSocialCalculator socialCalculator = new MicroSocialCalculator();
        MicroTaxCalculator taxCalculator = new MicroTaxCalculator();
        ProfessionalTrainingContributionCalculator trainingCalculator = new ProfessionalTrainingContributionCalculator();

        SimulationResult result = new SimulationService(socialCalculator, taxCalculator, trainingCalculator).launchSimulation(profile);

        view.showResults(result);
    }

    private BusinessActivity readValidActivity() {
        BusinessActivity[] activities = BusinessActivity.values();

        String[] activityNames = new String[activities.length];
        for (int i = 0; i < activities.length; i++) {
            activityNames[i] = activities[i].name();
        }

        while (true) {
            try {
                String choiceStr = view.promptForActivity(activityNames);
                int choice = Integer.parseInt(choiceStr);

                if (choice >= 0 && choice < activities.length) {
                    return activities[choice];
                }

                view.showErrorMessage("Veuillez entrer un nombre entre 0 et " + (activities.length - 1));
            } catch (NumberFormatException e) {
                view.showErrorMessage("Veuillez saisir un nombre valide.");
            }
        }

    }

    private BigDecimal readValidTurnover() {
        while (true) {
            try {
                String input = view.promptForRevenue();
                BigDecimal turnover = new BigDecimal(input);

                if (turnover.signum() > 0) {
                    return turnover;
                }

                view.showErrorMessage("Veuillez saisir une valeur positive.");
            } catch (NumberFormatException e) {
                view.showErrorMessage("Veuillez saisir un nombre valide.");
            }
        }
    }

}
