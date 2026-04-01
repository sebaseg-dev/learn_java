package fr.sebaseg.indie.controller;

import fr.sebaseg.indie.model.calculators.CalculationException;
import fr.sebaseg.indie.model.calculators.FlatTaxCalculator;
import fr.sebaseg.indie.model.calculators.RevenueTaxCalculator;
import fr.sebaseg.indie.model.data.BusinessActivity;
import fr.sebaseg.indie.model.data.EntrepreneurProfile;
import fr.sebaseg.indie.model.service.SimulationResult;
import fr.sebaseg.indie.model.service.SimulationService;
import fr.sebaseg.indie.view.ViewInterface;

import java.math.BigDecimal;

public class MainController {
    enum APP_STATE {
        INIT,
        RUN,
        STOP
    }

    private final ViewInterface view;
    private final FlatTaxCalculator taxCalculator;
    private final FlatTaxCalculator socialContributionCalculator;
    private final FlatTaxCalculator trainingContributionCalculator;
    private final RevenueTaxCalculator revenueTaxCalculator;

    public MainController(
            ViewInterface view,
            FlatTaxCalculator taxCalculator,
            FlatTaxCalculator socialContributionCalculator,
            FlatTaxCalculator trainingContributionCalculator,
            RevenueTaxCalculator revenueTaxCalculator
    ) {
        this.view = view;
        this.taxCalculator = taxCalculator;
        this.socialContributionCalculator = socialContributionCalculator;
        this.trainingContributionCalculator = trainingContributionCalculator;
        this.revenueTaxCalculator = revenueTaxCalculator;
    }

    public void start() {
        APP_STATE state = APP_STATE.RUN;
        view.showWelcomeMessage();

        while (state == APP_STATE.RUN) {
            try {
                BusinessActivity activity = readValidActivity();
                boolean hasACRE = false;
                boolean hasTaxWithholding = true;
                BigDecimal turnover = readValidTurnover();

                EntrepreneurProfile profile = new EntrepreneurProfile(activity, hasACRE, hasTaxWithholding, turnover);

                view.showActivity(profile.getActivity());
                view.showRevenue(profile.getTurnover());

                SimulationResult result = new SimulationService(taxCalculator, socialContributionCalculator, trainingContributionCalculator, revenueTaxCalculator).launchSimulation(profile);

                view.showResults(result);

                state = APP_STATE.STOP;
            } catch (CalculationException e) {
                view.showErrorMessage(e.getMessage());
            } catch (Exception e) {
                view.showErrorMessage("Erreur inattendue : " + e.getMessage());
                break;
            }
        }

        view.showGoodbyeMessage();

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
                String input = view.promptForTurnover();
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
