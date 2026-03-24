package fr.sebaseg;

import fr.sebaseg.indie.controller.MainController;
import fr.sebaseg.indie.view.CommandLineView;

public class App {
    public static void main(String[] args) {
        CommandLineView view = new CommandLineView();
        MainController controller = new MainController(view);

        controller.start();
    }
}
