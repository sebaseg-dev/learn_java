package fr.sebaseg;

import fr.sebaseg.indie.controller.MainController;
import fr.sebaseg.indie.view.CommandLineView;
import fr.sebaseg.indie.view.ViewInterface;

public class App {
    public static void main(String[] args) {
        ViewInterface view = new CommandLineView();
        MainController controller = new MainController(view);

        controller.start();
    }
}
