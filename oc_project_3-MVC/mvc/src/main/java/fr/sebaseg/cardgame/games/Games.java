package fr.sebaseg.cardgame.games;

import fr.sebaseg.cardgame.controller.GameController;
import fr.sebaseg.cardgame.model.Deck;
import fr.sebaseg.cardgame.view.CommandLineView;
import fr.sebaseg.cardgame.games.GameEvaluator;

public class Games {
    public static void main(String[] args) {
        // GameController gc = new GameController(new Deck(), new View(), new HighCardGameEvaluator());
        GameController gc = new GameController(new Deck(), new CommandLineView(), new LowCardGameEvaluator());
        gc.run();
    }
}