package fr.sebaseg.cardgame.games;

import fr.sebaseg.cardgame.controller.GameController;
import fr.sebaseg.cardgame.model.DeckFactory;
import fr.sebaseg.cardgame.view.CommandLineView;
import fr.sebaseg.cardgame.view.GameSwingView;

public class Games {
    public static void main(String[] args) {
//         GameController gc = new GameController(DeckFactory.makeDeck(DeckFactory.DeckType.Normal), new CommandLineView(), new HighCardGameEvaluator());
//         GameController gc = new GameController(DeckFactory.makeDeck(DeckFactory.DeckType.Normal), new CommandLineView(), new LowCardGameEvaluator());

        GameSwingView gsv = new GameSwingView();
        gsv.createAndShowGUI();
        GameController gc = new GameController(DeckFactory.makeDeck(DeckFactory.DeckType.Normal), gsv, new LowCardGameEvaluator());
        
        gc.run();
    }
}