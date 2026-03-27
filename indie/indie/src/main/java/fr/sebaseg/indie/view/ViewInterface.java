package fr.sebaseg.indie.view;

import fr.sebaseg.indie.model.data.BusinessActivity;
import fr.sebaseg.indie.model.service.SimulationResult;

import java.math.BigDecimal;

public interface ViewInterface {
    void showWelcomeMessage();
    String promptForActivity(String[] activities);
    void showActivity(BusinessActivity activity);
    void showRevenue(BigDecimal revenue);
    String promptForTurnover();
    void showResults(SimulationResult results);

    void showErrorMessage(String message);

    void showGoodbyeMessage();
}
