package fr.sebaseg.cardgame.games;

import fr.sebaseg.cardgame.controller.GameController;
import fr.sebaseg.cardgame.model.DeckFactory;
import fr.sebaseg.cardgame.view.*;

public class Games {
    public static void main(String[] args) {
        GameViewables views = new GameViewables();

        GameSwingView gsv = new GameSwingView();
        gsv.createAndShowGUI();
        views.addViewable(gsv);

        for (int i = 0; i < 3; i++){
            GameSwingPassiveView passiveView = new GameSwingPassiveView();
            passiveView.createAndShowGUI();

            views.addViewable(passiveView);

            // sleep to move new Swing frame on window
            try{
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        GameController gc = new GameController(new Deck(), new View(), new HighCardGameEvaluator());
        GameController gc = new GameController(DeckFactory.makeDeck(DeckFactory.DeckType.Normal), views, new LowCardGameEvaluator());
        
        gc.run();
    }
}