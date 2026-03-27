package fr.sebaseg.cardgame.games;

import java.util.List;

import fr.sebaseg.cardgame.model.IPlayer;
import fr.sebaseg.cardgame.model.PlayingCard;

public class HighCardGameEvaluator implements GameEvaluator {
    @Override
    public IPlayer evaluateWinner(List<IPlayer> Players) {
        IPlayer bestPlayer = null;
        int bestRank = -1;
        int bestSuit = -1;
        
        for (IPlayer Player : Players) {
            boolean newBestPlayer = false;
            
            if (bestPlayer == null) {
                newBestPlayer = true;
            } else {
                PlayingCard pc = Player.getCard(0);
                int thisRank = pc.getRank().value();
                if (thisRank >= bestRank) {
                    if (thisRank > bestRank) {
                        newBestPlayer = true;
                    } else {
                        if (pc.getSuit().value() > bestSuit) {
                            newBestPlayer = true;
                        }
                    }
                }
            }
            
            if (newBestPlayer) {
                bestPlayer = Player;
                PlayingCard pc = Player.getCard(0);
                bestRank = pc.getRank().value();
                bestSuit = pc.getSuit().value();
            }
        }
        
        return bestPlayer;
    }
}