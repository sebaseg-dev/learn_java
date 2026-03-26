package fr.sebaseg.indie.view;

import java.math.BigDecimal;

public interface ViewInterface {
    void showWelcomeMessage();
    void showRevenue(BigDecimal revenue);
    String promptForRevenue();
    void showErrorMessage(String message);
}
