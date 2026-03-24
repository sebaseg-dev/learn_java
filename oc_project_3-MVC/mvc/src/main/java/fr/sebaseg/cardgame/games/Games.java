package fr.sebaseg.cardgame.games;

import fr.sebaseg.cardgame.controller.GameController;
import fr.sebaseg.cardgame.model.Deck;
import fr.sebaseg.cardgame.view.CommandLineView;
import fr.sebaseg.cardgame.games.GameEvaluator;
import fr.sebaseg.cardgame.view.GameSwingView;

public class Games {
    public static void main(String[] args) {
        // GameController gc = new GameController(new Deck(), new View(), new HighCardGameEvaluator());
        // GameController gc = new GameController(new Deck(), new CommandLineView(), new LowCardGameEvaluator());

        GameSwingView gsv = new GameSwingView();
        gsv.createAndShowGUI();
        GameController gc = new GameController(new Deck(), gsv, new LowCardGameEvaluator());
        
        gc.run();
    }
}