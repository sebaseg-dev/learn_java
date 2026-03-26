package fr.sebaseg.indie.view;

import fr.sebaseg.indie.model.data.BusinessActivity;

import java.math.BigDecimal;

public interface ViewInterface {
    void showWelcomeMessage();
    String promptForActivity(String[] activities);
    void showActivity(BusinessActivity activity);
    void showRevenue(BigDecimal revenue);
    String promptForRevenue();
    void showErrorMessage(String message);
}
