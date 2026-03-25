package fr.sebaseg.cardgame.games;

import fr.sebaseg.cardgame.controller.GameController;
import fr.sebaseg.cardgame.model.DeckFactory;
import fr.sebaseg.cardgame.view.CommandLineView;
import fr.sebaseg.cardgame.view.GameSwingView;
import fr.sebaseg.cardgame.view.GameViewable;
import fr.sebaseg.cardgame.view.GameViewables;

import java.util.ArrayList;
import java.util.List;

public class Games {
    public static void main(String[] args) {
//         GameController gc = new GameController(DeckFactory.makeDeck(DeckFactory.DeckType.Normal), new CommandLineView(), new HighCardGameEvaluator());
//         GameController gc = new GameController(DeckFactory.makeDeck(DeckFactory.DeckType.Normal), new CommandLineView(), new LowCardGameEvaluator());

        GameSwingView gsv = new GameSwingView();
        gsv.createAndShowGUI();
//        GameController gc = new GameController(DeckFactory.makeDeck(DeckFactory.DeckType.Normal), gsv, new LowCardGameEvaluator());

        GameViewables gv = new GameViewables();
        gv.addViewable(gsv);
        gv.addViewable(new CommandLineView());

        GameController gc = new GameController(
                DeckFactory.makeDeck(DeckFactory.DeckType.Normal),
                gv,
                new LowCardGameEvaluator()
        );
        
        gc.run();
    }
}